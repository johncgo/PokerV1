import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Poker {
	public static void main(String[] args) throws IOException {
		double horaInicio = System.currentTimeMillis(); //hora de inicio
		
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/Jonathan/workspace/Poker do gera/pokerK.txt"));
		Jogador teste = null;
		while(br.ready()){
			String row = br.readLine();
			Jogador player1 = new Jogador();
			Jogador player2 = new Jogador();
			Carta temp[] = new Carta[5];
			int contador = 0;
			row = row.replace(" ","");
			
			for(int i = 0; i < ((row.length()/2)-1);i+=2){
				int valor;
				char valorTmp = row.charAt(i);
				char naipe = row.charAt(i+1);

				if(valorTmp == 'T'){
					valor = 10;
				}
				else if(valorTmp == 'J'){
					valor = 11;
				}
				else if(valorTmp == 'Q'){
					valor = 12;
				}
				else if(valorTmp == 'K'){
					valor = 13;
				}
				else if(valorTmp == 'A'){
					valor = 14;
				}
				else{
					valor = Character.getNumericValue(valorTmp);
				}

				temp[contador] = new Carta(valor, naipe);
				contador++;
			}

			temp = ordenacao(temp);
			player1.setMao(temp);
			contador = 0;
			temp = new Carta[5];
			
			for(int i = row.length()/2; i < row.length();i+=2){
				int valor;
				char valorTmp = row.charAt(i);
				char naipe = row.charAt(i+1);

				if(valorTmp == 'T'){
					valor = 10;
				}
				else if(valorTmp == 'J'){
					valor = 11;
				}
				else if(valorTmp == 'Q'){
					valor = 12;
				}
				else if(valorTmp == 'K'){
					valor = 13;
				}
				else if(valorTmp == 'A'){
					valor = 14;
				}
				else{
					valor =  Character.getNumericValue(valorTmp);
				}

				temp[contador] = new Carta(valor, naipe);
				contador++;
			}
			temp = ordenacao(temp);
			player2.setMao(temp);
			teste = player2;
			//for usado apenas pra testar os metodos, pode colocar ai e mudar a variavel teste em cima pra p1 ou p2
			/*if(teste.trinca(teste.getMao())){
				
					String cartas = "";
					for(int i = 0; i < 5;i++){
						cartas+= teste.mao[i].getValor();
						cartas+= teste.mao[i].getNaipe();
						cartas+= " ";
					}
					System.out.println("tem trinca: " + cartas);
				}*/
				
				
		}
		double horaFim = System.currentTimeMillis(); //hora que terminou
		
		System.out.println("Tempo Gasto em segundos= "+((horaFim-horaInicio)/1000));
		String cartas = "";
		for(int i = 0; i < 5;i++){
			cartas+= teste.mao[i].getValor();
			cartas+= teste.mao[i].getNaipe();
			cartas+= " ";
		}
		//System.out.println(cartas);
	}
	public static Carta[] ordenacao(Carta[] mao){
		for(int i = 0; i<5; i++){
			for(int j = 0; j<=3; j++){
				int v1 = mao[j].getValor();
				int v2 = mao[j+1].getValor();
				if (v1 > v2) {
					Carta aux = mao[j];
					mao[j] = mao[j+1];
					mao[j+1] = aux;
				}
			}
		}
		return mao;
	}
}
