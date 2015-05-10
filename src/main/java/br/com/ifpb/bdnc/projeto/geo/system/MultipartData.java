/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.bdnc.projeto.geo.system;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author João
 */
public class MultipartData {
     
    private String folder;
    
    public void setFolder(String folder){
        this.folder = folder;
    }    
    
    public boolean saveImage(String path, FileItemStream item, String nameToSave){
        try{
            File f = new File(path+File.separator+folder);            
            File parent = new File(f.getParent());
            
            if(!parent.exists())
                parent.mkdir();
            if (!f.exists())
                f.mkdir();
            
            System.out.println(f.getAbsolutePath());
            
            File savedFile = new File(f.getAbsoluteFile()+File.separator+nameToSave);
            
            FileOutputStream fos = new FileOutputStream(savedFile);
            InputStream is = item.openStream();
            
            int x = 0;
            byte[] b = new byte[1024];
            while((x = is.read(b)) != -1){
                fos.write(b, 0, x);
            }
            fos.flush();
            fos.close();
            
            return true;
            
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    public String processFile(HttpServletRequest request)
            throws ServletException, IOException {
    
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);

        if (isMultipart) {
            ServletFileUpload upload = new ServletFileUpload();
            try {
                FileItemIterator itr = upload.getItemIterator(request);

                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (!item.isFormField()) {                        
                        String path = request.getServletContext().getRealPath("/");
                        String nameToSave = "profileImage" + Calendar.getInstance().getTimeInMillis() + item.getName();
                        if (saveImage(path+"/userImages", item, nameToSave)) {
                            return folder+"/"+nameToSave;
                        }
                    }
                }

            } catch (FileUploadException ex) {
                System.out.println("erro ao obter informaçoes sobre o arquivo");
            }

        }else{
            System.out.println("Erro no formulario!");
        }

        return null;
    }   
   
    
}
