package objetos;

import principal.Global;

import java.awt.*;


public class Passaro {
    protected Image img = Global.carregarImagem("resources/images/passaro.png");
    int x = 300, y = Global.altura_tela / 2;
    int tamanho = 64;

    boolean vivo = true;

    private double gravidade = 0.2, velocidadeQueda = 0, forcaPulo = 5;

    public Passaro(){

    }

    public void desenharPassaro(Graphics2D g2){
        g2.drawImage(img, x, y,tamanho, tamanho, null);
    }

    public void pular(){
        velocidadeQueda = -forcaPulo;
    }

    public void update(){
        if(vivo){
            y += velocidadeQueda;
            velocidadeQueda += gravidade;

            if(y > 700) pular();
        }
    }

}
