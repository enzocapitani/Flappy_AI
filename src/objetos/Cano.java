package objetos;

import java.awt.*;
import java.util.Random;

import principal.Global;

public class Cano {
    
    Random rand = new Random();

    public int x1, y1, y2;
    int velocidade = 3;
    public int dx, dy;
    public double abertura = Global.altura_tela * 0.21;

    Image img = Global.carregarImagem("/resources/images/Cano.png");

    public int espacoTela;

    public Cano(int x){
        espacoTela = rand.nextInt(300) + 100;

        dx = (int)(Global.largura_tela * 0.04);

        dy = (int)(Global.altura_tela*1.5);
    
        this.x1 = x;

        y1 = -dy + espacoTela;
        y2 = (int) (espacoTela + abertura);

    }

    public void update(){
        x1 -= velocidade;
    }

    public void setX(int x){
        this.x1 = x;
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
