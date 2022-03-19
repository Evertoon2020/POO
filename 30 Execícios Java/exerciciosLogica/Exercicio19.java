package exerciciosLogica;

import java.util.Scanner;

public class Exercicio19 {

	public void run() {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite um valor: ");
		double n = input.nextDouble();
		System.out.println( extensoMoney(n) );
	}
	
	private String extensoMoney(double n) {  // 15892.54
		String nExtenso = "";
		int   inteiro   = (int) n ;   // (int)15892.54 = // 15892
		float pog = (float) 0.000002; // correção de subtrair um int de um float
		
		int   decimal   = (int)(((n - inteiro)+pog) * 100) ; // 15892.54 - 15892 = 0.54 * 100 = 54 
		
		Exercicio18 exercicio18 = new Exercicio18();
		
		nExtenso += exercicio18.extenso(inteiro);
		nExtenso += ((inteiro==1)?" real ":((inteiro>1)?" reais ":""));
		
		nExtenso += ((inteiro!=0)&&(decimal!=0))?" e ": "";
		
		nExtenso += exercicio18.extenso(decimal);
		nExtenso += ((decimal==1)?" centavo ":((inteiro>1)?" centavos ":""));
		
		return(nExtenso);
	}
	
}
