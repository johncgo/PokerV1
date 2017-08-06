
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
	
	public boolean par(Carta[] mao){
		boolean verificador = false;
		for(int i = 0; i<4 ; i++){
			int cartaAtual = mao[i].getValor();
			if(cartaAtual == mao[i+1].getValor()){
				verificador = true;
			}
		}
		return verificador;
	}
	
	public boolean doisPares(Carta[] mao){
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
	
	public boolean fullHouse(Carta[] mao){
		boolean verificador1 = false;
		boolean verificador2 = false;
		boolean verificador3 = false;
		int valor = -1;
		for(int i = 0; i<3;i++){
			int cartaAtual = mao[i].getValor();
			if(cartaAtual == mao[i+1].getValor() && cartaAtual == mao[i+2].getValor() && cartaAtual != 0){
				verificador1 = true;
				valor = cartaAtual;
				mao[i].setValor(0);
				mao[i+1].setValor(0);
				mao[i+2].setValor(0);
			}	
		}
		for(int i = 0; i<4 ; i++){
			int cartaAtual = mao[i].getValor();
			if(cartaAtual == mao[i+1].getValor() && cartaAtual != 0){
				verificador2 = true;
			}
		}
		if(verificador1 && verificador2){
			verificador3 = true;
		}
		
		for(int i = 0; i<5;i++){
			if(mao[i].getValor() == 0){
				mao[i].setValor(valor);
			}
		}
		return verificador3;
	}
}

