/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ifpb.bdnc.projeto.geo.servlets;

import br.com.ifpb.bdnc.projeto.geo.entities.Image;
import br.com.ifpb.bdnc.projeto.geo.system.MultipartData;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author DouglasGabriel
 */
public class CadastraImagem extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Image image = mountImage(request);
    }

    private Image mountImage(HttpServletRequest request) {
        Image image = new Image();
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            ServletFileUpload upload = new ServletFileUpload();
            try {
                FileItemIterator itr = upload.getItemIterator(request);
                while (itr.hasNext()) {
                    FileItemStream item = itr.next();
                    if (item.isFormField()) {
                        InputStream in = item.openStream();
                        byte[] b = new byte[in.available()];
                        in.read(b);
                        if (item.getFieldName().equals("description")) {
                            image.setDescription(new String(b));
                        } else if (item.getFieldName().equals("authors")) {
                            image.setAuthors(new String(b));
                        } else if (item.getFieldName().equals("date")) {
                            image.setDate(LocalDate.parse(new String(b), DateTimeFormatter.ofPattern("dd/MM/yyyy")));
                        } else if (item.getFieldName().equals("lat")){
                            image.getCoord().setLat(new String(b));
                        } else if (item.getFieldName().equals("lng")){
                            image.getCoord().setLng(new String(b));
                        } else if (item.getFieldName().equals("heading")){
                            image.getCoord().setHeading(new String(b));
                        } else if (item.getFieldName().equals("pitch")){
                            image.getCoord().setPitch(new String(b));
                        } else if (item.getFieldName().equals("zoom")){
                            image.getCoord().setZoom(new String(b));
                        }
                    } else {
                        if (!item.getName().equals("")) {
                            MultipartData md = new MultipartData();
                            String folder = "historicImages";
                            md.setFolder(folder);
                            String path = request.getServletContext().getRealPath("/");
                            String nameToSave = "pubImage" + Calendar.getInstance().getTimeInMillis() + item.getName();
                            image.setImagePath(folder + "/" + nameToSave);
                            md.saveImage(path, item, nameToSave);
                        }
                    }
                }
            } catch (FileUploadException | IOException ex) {
                System.out.println("Erro ao manipular dados");
            }
        }
        return image;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}