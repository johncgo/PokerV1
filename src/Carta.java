
public class Carta {
	private char naipe;
	private int valor;
	
	public Carta(){
		
	}
	public Carta(int valor, char naipe) {
		this.setNaipe(naipe);
		this.setValor(valor);
	}
	public char getNaipe() {
		return naipe;
	}
	public void setNaipe(char naipe) {
		this.naipe = naipe;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}
