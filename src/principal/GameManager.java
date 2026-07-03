package principal;

import java.awt.Graphics2D;

import objetos.*;

public class GameManager {

    public Passaro passaro = new Passaro();

    public GameManager(){

    }

    public void update(){
        passaro.update();
    }

    public void desenharComponentes(Graphics2D g2){
        passaro.desenharPassaro(g2);
    }

}
