package objetos;

import java.awt.*;
import java.util.Random;

import principal.Global;

public class Cano {
    
    Random rand = new Random();

    int x1, x2, y1, y2;
    int velocidade = 3;
    int dx, dy;
    double abertura = Global.altura_tela * 0.2;

    Image img = Global.carregarImagem("resources/images/Cano.png");

    int espacoTela;

    public Cano(){
        espacoTela = rand.nextInt(300) + 100;

        dx = (int)(Global.largura_tela * 0.04);

        dy = (int)(Global.altura_tela*1.5);
    
        x1 = 200;

        y1 = -dy + espacoTela;
        y2 = (int) (espacoTela + abertura);

        System.out.println(dx+" "+Global.altura_tela*1.5);

    }

    public void desenharCano(Graphics2D g2){
        Graphics2D g2d = (Graphics2D)g2.create();
        g2d.setColor(Color.GREEN);
        g2d.drawImage(img, x1, y2, null);

        g2d.rotate(Math.toRadians(180), x1 + dx/2, y1 + dy/2);
        g2d.drawImage(img, x1, y1, dx, dy, null);

        g2d.dispose();
    }

}
