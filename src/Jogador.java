
public class Jogador {
	Carta mao[];
	
	
	public Jogador() {
		this.mao = new Carta[5];
	}


	public Carta[] getMao() {
		return mao;
	}


	public void setMao(Carta[] mao) {
		this.mao = mao;
	}
	//acho melhor fazer as regras na classe jogador por que já tá instanciada ai fica suave
	
	public boolean straight(Carta[] mao){
		int valorDeCarta;
		boolean verificador = true;
		int contadorMao = 0;
		for(int i = 1; i<15;i++){
			valorDeCarta = mao[contadorMao].getValor();
			if(valorDeCarta == i && contadorMao<4){
				contadorMao++;
				
				if(mao[contadorMao].getValor() != valorDeCarta+1){
					verificador = false;
					i = 15;//sai do for
					
				}
				
			}
		}
		
		return verificador;
	}
	
	public boolean flush(Carta[] mao){
		boolean verificador = true;
		for(int i = 0; i<4;i++){
			if(mao[i].getNaipe() != mao[i+1].getNaipe()){
				verificador = false;
			}
		}
		return verificador;
	}
	
	public boolean trinca(Carta[] mao){
		boolean verificador = false;
		for(int i = 0; i<3;i++){
			int cartaAtual = mao[i].getValor();
			if(cartaAtual == mao[i+1].getValor() && cartaAtual == mao[i+2].getValor()){
				verificador = true;
			}
			
		}
		return verificador;
	}
	
	public boolean dupla(Carta[] mao){
		boolean verificador = false;
		for(int i = 0; i<4 ; i++){
			int cartaAtual = mao[i].getValor();
			if(cartaAtual == mao[i+1].getValor()){
				verificador = true;
			}
		}
		return verificador;
	}
	
	public boolean duplaDupla(Carta[] mao){
		boolean verificador1 = false;
		boolean verificador2 = false;
		for(int i = 0; i<4 ; i++){
			int cartaAtual = mao[i].getValor();
			if(cartaAtual == mao[i+1].getValor()){
				verificador1 = true;
			}
			else if(cartaAtual == mao[i+1].getValor() && verificador1){
				verificador2 = true;
			}
		}
		
		return verificador2;
	}
	
	public boolean quadra(Carta[] mao){
		boolean verificador = false;
		for(int i = 0; i< 2;i++){
			int cartaAtual = mao[i].getValor();
			if(cartaAtual == mao[i+1].getValor() && cartaAtual == mao[i+2].getValor() &&
					cartaAtual == mao[i+3].getValor()){
				verificador = true;
			}
		}
		
		return verificador;
	}
	
	public boolean straightFlush(Carta[] mao){
		boolean verificador = false;
		if(flush(mao) && straight(mao)){
			verificador = true;
		}
		
		return verificador;
	}
	
	public boolean royalFlash(Carta[] mao){
		boolean verificador = false;
		int cartaAtual = mao[0].getValor();
		if(straightFlush(mao) && cartaAtual == 10){
			verificador = true;
		}
		return verificador;
	}
}

