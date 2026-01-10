package matrius;

import java.util.Scanner;

public class EleccionsAlConsellEscolar {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tamany = sc.nextInt();
		
		String[][] mat = new String[tamany][tamany];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = ".";
			}
		}
		//Diagonal
		for (int i = 0; i < mat.length; i++) {
			mat[i][i] = "X";
		}
		for (int i = 0; i < mat.length; i++) {
			mat[i][mat.length - 1 - i] = "X";
		}
		//Fin Diagonal
		
		//Bores
		for (int i = 0; i < mat.length; i++) {
			mat[i][mat.length - 1] = "X";
			mat[mat.length - 1][i] = "X";
		}
		for (int i = 0; i < mat.length; i++) {
			mat[0][mat.length - 1 - i] = "X";
			mat[mat.length - 1 - i][0] = "X";
		}
		//Fin Boras
		
		//printar
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
		
		
	}
}