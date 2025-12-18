package matrius;

import java.util.Scanner;

public class SumaFilesIColumnes {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int filas = sc.nextInt();
		int colum = sc.nextInt();
		
		int [][] mat = new int [filas][colum];
		
		omplirMat(mat);
		int numPos = sc.nextInt();
		sumaMatColum(mat, numPos);
	}

	private static void sumaMatColum(int[][] mat, int numPos) {
		int SumColum = 0;
		int SumFilas = 0;
		for (int i = 0; i < mat.length; i++) {
			SumColum += mat[i][numPos];
		}
		for (int i = 0; i < mat[0].length; i++) {
			SumFilas += mat[numPos][i];
		}
		System.out.println(SumFilas + " " + SumColum);
	}

	private static void omplirMat(int[][] mat) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
	}
}
