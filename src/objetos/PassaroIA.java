package objetos;

import principal.Global;
import redeneural.RedeNeuralPassaro;

public class PassaroIA extends Passaro{
	
	public RedeNeuralPassaro redeneural;

	
	public PassaroIA(int x) {
		this.x = x;
		this.redeneural = new RedeNeuralPassaro(this);
	}
	
	@Override
	public void reset() {
		distanciaPercorrida = 0;
		 y = Global.altura_tela / 2;
        velocidadeQueda = -forcaPulo;
        angulo = -31;
        vivo = true;
	}
	
	@Override
	public void update() {
		if(vivo) {
			y+= velocidadeQueda;
			velocidadeQueda += gravidade;

			redeneural.updateRede();
			
			mudarAngulo();
			colisao();
			
			if(redeneural.decisao()) pular();
			
		}
	}
	
}
