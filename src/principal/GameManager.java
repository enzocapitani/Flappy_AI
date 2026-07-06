package principal;

import java.awt.Graphics2D;
import java.util.ArrayList;

import objetos.*;

public class GameManager {

    public Passaro passaro = new Passaro();

    final int QT_CANOS = 10;
    int espacamento = (int) (Global.largura_tela * 0.25);

    ArrayList<Cano> canos = new ArrayList<>();

    public GameManager(){
        inicializarObj();
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

    public int canoMaisDist(){
        int melhorDistancia = 0;
        for(Cano cano : canos){
            if(cano.x1 >  melhorDistancia) melhorDistancia = cano.x1;
        }

        return melhorDistancia;
    }

    public void update(){
        passaro.update();
        canos.forEach(cano -> cano.update());
        definirPosCano();
    }

    public void desenharComponentes(Graphics2D g2){
        passaro.desenharPassaro(g2);
        
        for (Cano canos : canos) {
            canos.desenharCano(g2);
        }

    }

}
