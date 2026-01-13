package ExamenProbaMatDicc;

import java.util.Scanner;

public class CreuNordica {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int files = sc.nextInt(); 
		int colum = sc.nextInt();
		
		String[][] mat = new String[files][colum];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = ".";
			}
		}
		//Linea Mitad
		for (int i = 0; i < mat[0].length; i++) {
			mat[files / 2][i] = "X";
		}
		
		for (int i = 0; i < mat.length; i++) {
			mat[i][colum / 3] = "X";
		}
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}

}
