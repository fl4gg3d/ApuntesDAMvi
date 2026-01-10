package matrius;

import java.util.Scanner;

public class MatriuTransposada {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int files = sc.nextInt();
		int colum = sc.nextInt();
		
		int[][] mat = new int[files][colum];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < mat[0].length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[j][i] + " ");   
			}
			System.out.println();
		}
		
		
		
	}

}
