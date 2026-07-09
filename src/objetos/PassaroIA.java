package objetos;

import redeneural.RedeNeuralPassaro;

public class PassaroIA extends Passaro{
	
	RedeNeuralPassaro redeneural;
	
	public PassaroIA(int x) {
		this.x = x;
		this.redeneural = new RedeNeuralPassaro(this);
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
