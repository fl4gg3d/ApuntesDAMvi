package matrius;

import java.util.Scanner;

public class IndexOfMatriu {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int linies = sc.nextInt();
		int colum = sc.nextInt();
		int[][] mat1 = new int[linies][colum];
		
		
		omplirMatriu(mat1);
		printarPosicioMatriu(mat1);
		
	}
	
	private static void printarPosicioMatriu(int[][] mat1) {
		int numPos = sc.nextInt();
		boolean EstaElNumero = false;
		int linea = 0;
		int colum = 0;
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				if(mat1[i][j] == numPos) {
					EstaElNumero = true;
					linea = i;
					colum = j;
				}

			}
		}
		if (EstaElNumero) {
			System.out.println(linea +" "+ colum);
		}
		else {
			System.out.println(-1 +" "+-1);
		}
		
	}

	private static void omplirMatriu(int[][] mat1) {
		
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[0].length; j++) {
				mat1[i][j] = sc.nextInt();
			}
		}
		
	}

}
