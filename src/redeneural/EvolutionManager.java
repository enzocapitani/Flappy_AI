package redeneural;

import java.util.ArrayList;
import java.util.Random;

import objetos.*;

public class EvolutionManager {
	Random rand = new Random();
	
	int qtMelhores = 5;
	
	PassaroIA melhores[];
	
	public EvolutionManager() {
		melhores = new PassaroIA[qtMelhores];
	}
	
	public void evoluir(ArrayList<PassaroIA> passaros) {
		selecionarMelhores(passaros);
		crossover(passaros);
	}
	
	public void crossover(ArrayList<PassaroIA> passaros) {
		
		for(int i = 0; i < passaros.size(); i++) {
			
			PassaroIA atual = passaros.get(i);
			if(contem(atual)) continue;
			
			for(int j = 0; j < atual.redeneural.pesos.length; j++) {
				int escolhido = rand.nextInt(qtMelhores);
				definirGenes(atual.redeneural.pesos[j], melhores[escolhido].redeneural.pesos[j]);
			}
			
			for(int j = 0; j < atual.redeneural.pesos2.length; j++) {
				int escolhido = rand.nextInt(qtMelhores);
				definirGenes(atual.redeneural.pesos2[j], melhores[escolhido].redeneural.pesos2[j]);
			}
			
		}
		
	}
	
	public void definirGenes(double peso, double pesoMae) {
			double mutacao = 0;
			
			if(rand.nextInt(10) < 2) {
				mutacao = rand.nextDouble(0.1, 0.2);
				if(rand.nextBoolean()) mutacao *= -1;			
			}
			
			peso = pesoMae + mutacao;
			
			if(peso > 1) {
				peso = 1;	
			}else if(peso < -1) {
				peso = -1;
			}
		}
	
	public void selecionarMelhores(ArrayList<PassaroIA> passaros) {
		
		for(PassaroIA passaro : passaros) {
			verificarMelhor(passaro);
		}
		
	}
	
	public void verificarMelhor(PassaroIA passaro) {
		for(int i = 0; i < melhores.length; i++) {
			
			if(melhores[i] == null) {
				melhores[i] = passaro;
				break;
			}
			
			if(melhores[i].distanciaPercorrida < passaro.distanciaPercorrida) {
				melhores[i] = passaro;
			}
			
		}
	}
	
	private boolean contem(PassaroIA passaro) {
		for (int i = 0; i < melhores.length; i++) {
			if(passaro == melhores[i]) return true;
		}
		return false;
	}
	
}
