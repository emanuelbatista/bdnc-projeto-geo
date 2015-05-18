package br.com.ifpb.bdnc.projeto.geo.system;


import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
/**
 *
 * @author dijalma
 */
public class RedimencionadorImagem {

    private static BufferedImage imagem;

    public RedimencionadorImagem(String caminho, int width, int height) {
    }

    public static void resize(String pathAbsolute, String imagePath, String minImagePath, int width, int height) throws HeadlessException {
        try {
            File file = new File(pathAbsolute+imagePath);            
            imagem = ImageIO.read(file);
            BufferedImage newImagem = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = newImagem.createGraphics();
            g.drawImage(imagem, 0, 0, width, height, null);
            File f;                        
            f = new File(minImagePath);            
            ImageIO.write(newImagem, "JPG", f);            
        } catch (IOException ex) {
            ex.printStackTrace();            
        }
    }

}