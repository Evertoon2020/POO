package exerciciosLogica;

import java.util.Scanner;

public class Exercicio18b {
	
	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite um valor inteiro: ");
		long n = input.nextLong();
		System.out.println( extenso(n) );
	}
	
	private String extensoCDU(int n) { // 852
		String nExtenso = "";
		int c = (int) (n/100);     // 852 / 100 = (int) 8.52 = 8
		int d = (int)((n%100)/10); // 852 % 100 = 52;  52 / 10 = (int)5.2 = 5
		int u = (int)((n%100)%10); // 852 % 100 = 52;  52 % 10 = (int)2.0 = 2
		String[] centenas   = new String[]{"",(((d==0)&&(u==0))?"cem":"cento"),"duzentos","trezentos","quatrocentos","quinhentos","seiscentos","setecentos", "oitocentos","novecentos"};						
		String[] unidadeDez = new String[]{"dez","onze","doze","treze","quatorze", "quinze","dezesseis","dezessete","dezoito","dezenove"};
		String[] dezenas    = new String[]{"",unidadeDez[u],"vinte","trinta", "quarenta", "cinquenta","sessenta", "setenta", "oitenta", "noventa"};
		String[] unidades   = new String[]{"","um","dois","três","quatro","cinco","seis","sete","oito","nove"};
		nExtenso = centenas[c] + (((c!=0)&&((d!=0)||(u!=0)))?" e ":"") +  dezenas[d] + (((d != 1)&&((d!=0)&&(u!=0)))?" e ":"") + unidades[u];
		return (nExtenso);
	}
	
	public String extenso( long n ) {
		
		String nExtenso = "";
		
		int quin = (int)(n / Math.pow(10,18));
		nExtenso += ((quin == 1)? extensoCDU(quin)+" Quintilhão ": ((quin > 1)? extensoCDU(quin)+" Quintilhões ": ""));
		n = (long) ((quin != 0) ? ( n % Math.pow(10,18) ) : n );

		int quad = (int)(n / Math.pow(10,15));
		nExtenso += ((quad == 1)? extensoCDU(quad)+" Quadrilhão ": ((quad > 1)? extensoCDU(quad)+" Quadrilhões ": ""));
		n = (long) ((quad != 0) ? ( n % Math.pow(10,15) ) : n ); 
		
		int trilh = (int)(n / Math.pow(10,12));
		nExtenso += ((trilh == 1)? extensoCDU(trilh)+" Trilhão ": ((trilh > 1)? extensoCDU(trilh)+" Trilhões ": ""));
		n = (long) (( trilh != 0) ? ( n % Math.pow(10,12) ) : n );
		
		int bilh = (int)(n / Math.pow(10, 9)); 
		nExtenso += ((bilh == 1)? extensoCDU(bilh)+" Bilhão ": ((bilh > 1)? extensoCDU(bilh)+" Bilhões ": ""));
		n = (long) (( bilh != 0) ? ( n % Math.pow(10,9) ) : n );
		
		int milh = (int)(n / Math.pow(10, 6));
		nExtenso += ((milh == 1)? extensoCDU(milh)+" Milhão ": ((milh > 1)? extensoCDU(milh)+" Milhões ": ""));
		n = (long) (( milh != 0) ? ( n % Math.pow(10,6) ) : n );
		
		int mil  = (int)(n / Math.pow(10, 3)); 
		nExtenso += ((mil >= 1) ? extensoCDU(mil)+" Mil ": "");
		n = (long) (( mil != 0) ? ( n % Math.pow(10,3) ) : n );
		
		int cdu  = (int) n;
		nExtenso += extensoCDU( cdu );
		
		return ( nExtenso );
	}
	
	
}


