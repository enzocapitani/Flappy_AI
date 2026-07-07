package principal;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//Essa classe tem unicamente a função de armazenar váriaveis
//em que todo o projeto pode ver
public class Global {

    //Constantes da tela
    public static final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int largura_tela = (int) screenSize.getWidth();
    public static final int altura_tela = (int) screenSize.getHeight();

    //Carrega imagens
    public static Image carregarImagem(String path) {
        try {


            BufferedImage imagem = ImageIO.read(Global.class.getResource(path));

            if (imagem != null) {
                return imagem;

            } else {
                System.out.println("O arquivo não é uma imagem válida.");
                return null;
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar a imagem: " + e.getMessage());
            return null;
        }
    }


}
