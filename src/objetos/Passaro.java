package objetos;

import principal.Global;

import java.awt.*;


public class Passaro {
    Image img = Global.carregarImagem("resources/images/passaro.png");
    int x = 300, y = Global.altura_tela / 2;
    int tamanho = 48;

    double angulo = -30;
    double mudarAngulo = 2;

    Cano cano = null;

    boolean vivo = true;

    private double gravidade = 0.4, velocidadeQueda = 0, forcaPulo = 8 ;

    public Passaro(){

    } 

    public void setCano(Cano cano){
        this.cano = cano;
    }

    public void colisao(){
        //* Colisao com cano parte de cima e de baixo
        if(x + tamanho > cano.x1 &&
            x < cano.x1 + cano.dx &&
            y + tamanho > cano.y1 &&
            y < cano.y1 + cano.dy
        ){
            vivo = false;
        }

        if(x + tamanho > cano.x1 &&
            x < cano.x1 + cano.dx &&
            y + tamanho > cano.y2 &&
            y < cano.y2 + cano.dy
        ){
            vivo = false;
        }

        //* Colisao com os extremos da tela */
        if(y < 0) vivo = false;
        if(y > Global.altura_tela - tamanho) vivo = false;

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
            colisao();
        }
    }

    public void desenharPassaro(Graphics2D g2){
        Graphics2D g2d = (Graphics2D) g2.create();
        if(vivo){
            g2d.rotate(Math.toRadians(angulo), x + tamanho/2, y + tamanho/2);
            g2d.drawImage(img, x, y,tamanho, tamanho, null);    
            g2d.dispose(); 
        }
    }

}
