
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
	
	
}
