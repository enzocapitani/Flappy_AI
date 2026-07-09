package principal.managers;

import java.awt.Graphics2D;
import java.util.ArrayList;

import objetos.*;
import principal.Global;

public class GameManager {

    public Passaro passaro = new Passaro();
    //public Passaro passaro1 = new PassaroIA(300);

    final int QT_CANOS = 10;
    int espacamento = (int) (Global.largura_tela * 0.25);

    ArrayList<Cano> canos = new ArrayList<>();

    public GameManager(){
        inicializarSom();
        inicializarObj();
    }

    public void inicializarSom(){
        SoundManager.load("jump", "/resources/sons/jump.wav");
        SoundManager.load("hit", "/resources/sons/hitHurt.wav");
    }

    public void inicializarObj(){
        for(int i = 0; i < QT_CANOS; i++){
            canos.add(new Cano(Global.largura_tela + i * espacamento ));
        }
    }

    public void definirPosCano(){
        for (Cano cano : canos) {
            if(cano.x1 < -cano.dx){
                cano.x1 = canoMaisDist() + espacamento;
            }
        }
    }

    public void definirCanoPassaro(){
        int distancia = Integer.MAX_VALUE;
        for (Cano cano : canos) {

            //* Vê o cano mais próximo atualmente, adiciona ele ao objeto do pássaro 
            //*  e verifica se ele ainda é maior que a metade do outro, se não, muda de cano
            if(cano.x1 - passaro.x < distancia && cano.x1 - passaro.x > -cano.dx/2){
                distancia = cano.x1 - passaro.x;
                passaro.setCano(cano);
            }

        }
    }

    public int canoMaisDist(){
        int melhorDistancia = 0;
        for(Cano cano : canos){
            if(cano.x1 >  melhorDistancia) melhorDistancia = cano.x1;
        }

        return melhorDistancia;
    }

    public void reset(){
        passaro.reset();
        for(int i = 0; i < canos.size(); i++){
            canos.get(i).setX(Global.largura_tela + i * espacamento);
        }
    }

    public void update(){
        definirCanoPassaro();

        passaro.update();
        canos.forEach(cano -> cano.update());

        definirPosCano();

        if(!passaro.vivo) reset();
    }

    public void desenharComponentes(Graphics2D g2){
        passaro.desenharPassaro(g2);
        
        for (Cano canos : canos) {
            canos.desenharCano(g2);
        }

    }

}
