package br.com.ifpb.bdnc.projeto.geo.system;


import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

    public static void resize(String imagePath, String minImagePath, int width, int height) throws HeadlessException {
        try {
            imagem = ImageIO.read(new File(imagePath));
            BufferedImage newImagem = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = newImagem.createGraphics();
            g.drawImage(imagem, 0, 0, width, height, null);
            File f;                        
            f = new File(minImagePath);            
            ImageIO.write(newImagem, "JPG", f);
            JOptionPane.showMessageDialog(null, "Imagem redimensionada com sucesso.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao redimensionar imagem.");
        }
    }

}