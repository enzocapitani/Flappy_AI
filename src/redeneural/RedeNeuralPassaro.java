package redeneural;

import java.util.Random;

import objetos.Cano;
import objetos.Passaro;
import principal.Global;

public class RedeNeuralPassaro {
	
	Passaro passaro;
	
	final int QT_ENTRADAS = 2;
	final int QT_OCULTOS = 2;
	
	double neuronios[];
	double pesos[];
	double pesos2[];
	int entradas[];
	
	double saida;
	
	public RedeNeuralPassaro(Passaro passaro) {
		
		this.passaro = passaro;
		neuronios = new double[2];
		pesos = new double[QT_ENTRADAS * QT_OCULTOS];
		pesos2 = new double[neuronios.length];
		entradas = new int[2];
		
		definirPesos(pesos);
		definirPesos(pesos2);
		
	}
	
	private void definirPesos(double pesos[]) {
		Random rand = new Random();
		
		for(int i = 0; i < pesos.length; i++) {
			
			pesos[i] = rand.nextDouble();
			if(rand.nextBoolean()) pesos[i] *= -1;
		
		}
	}
	
	public void definirEntradas() {
		Cano cano = passaro.cano;
		
		int x = cano.x1 + cano.dx/2;
		if(x > Global.largura_tela/2) x = Global.largura_tela/2;
		
		this.entradas[0] = x;
		//Y meio do cano;
		this.entradas[1] = cano.espacoTela + (int)cano.abertura/2;
	}
	
	private double relu(double value) {
		return Math.max(0, value);
	}
	
	public void updateRede() {
		definirEntradas();
	}
	
	public boolean decisao() {
		
		neuronios[0] = relu(entradas[0] * pesos[0] + entradas[1] * pesos[1]);
		neuronios[1] = relu(entradas[0] * pesos[2] + entradas[1] * pesos[3]);
		
		return relu(neuronios[0] * pesos2[0] + neuronios[1] * pesos2[1]) > 0;
		
	}
	
}
