package matrius;

import java.util.Scanner;

public class OftalMólogo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String fraseGiro = sc.nextLine();
		
		int[][] mat = new int[2][2];
		int contador = 1;
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = contador;
				contador++;
			}
		}
		for (int i = 0; i < fraseGiro.length(); i++) {
			
			char frase = fraseGiro.charAt(i);
			
			
			
		}
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
}
