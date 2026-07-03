package objetos;

import principal.Global;

import java.awt.*;


public class Passaro {
    protected Image img = Global.carregarImagem("resources/images/passaro.png");
    int x = 300, y = Global.altura_tela / 2;
    int tamanho = 48;

    double angulo = -30;
    double mudarAngulo = 2;

    boolean vivo = true;

    private double gravidade = 0.4, velocidadeQueda = 0, forcaPulo = 8 ;

    public Passaro(){

    }

    public void desenharPassaro(Graphics2D g2){
        g2.create();
        g2.rotate(Math.toRadians(angulo), x + tamanho/2, y + tamanho/2);
        g2.drawImage(img, x, y,tamanho, tamanho, null);
        g2.dispose();
    }

    public void pular(){
        velocidadeQueda = -forcaPulo;
        mudarAngulo = -10;
    }

    public void mudarAngulo(){
        angulo += mudarAngulo; 

        if(angulo <= -30) mudarAngulo = gravidade*5 ;

        if(angulo < -31) angulo = -31;  

        if(angulo > 80) angulo = 80;

    }

    public void update(){
        if(vivo){
            y += velocidadeQueda;
            velocidadeQueda += gravidade;
            mudarAngulo();
        }
    }

}
