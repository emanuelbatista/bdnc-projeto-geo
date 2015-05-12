
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author dijalma
 */
public class RedimensionarImagem {

    BufferedImage imagem;
    static int cont = 0;

    public RedimensionarImagem(String caminho, int width, int height) {

        try {
            this.imagem = ImageIO.read(new File(caminho));
            BufferedImage newImagem = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = newImagem.createGraphics();
            g.drawImage(imagem, 0, 0, width, height, null);
            File f;
            
            do {
                
                String diretorio = "newImagem_0" + (++cont) + ".jpg";
                f = new File(diretorio);

            } while (f.exists());

            ImageIO.write(newImagem, "JPG", f);

            JOptionPane.showMessageDialog(null, "Imagem redimensionada com sucesso.");
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao redimensionar imagem.");
        }
    }

}