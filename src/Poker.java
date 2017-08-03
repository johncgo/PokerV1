import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Poker {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("C:/Users/Jonathan/workspace/Poker do gera/pokerK.txt"));
	Jogador teste = null;
	while(br.ready()){
		   String row = br.readLine();
		   Jogador player1 = new Jogador();
		   Jogador player2 = new Jogador();
		   Carta temp[] = new Carta[5];
		   int contador = 0;
		   row = row.replace(" ","");
		   for(int i = 0; i < ((row.length()/2)-2);i+=2){
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
				   valor = (int)valorTmp;
			   }
			   
			   temp[contador] = new Carta(valor, naipe);
			   contador++;
		   }
		   
		   player1.setMao(temp);
		   contador = 0;
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
				   valor = (int)valorTmp;
			   }
			   
			   temp[contador] = new Carta(valor, naipe);
			   contador++;
		   }
		   
		   player2.setMao(temp);
		   
	}
	
}
}
