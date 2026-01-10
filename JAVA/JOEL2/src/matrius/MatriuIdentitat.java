package matrius;

import java.util.Scanner;

public class MatriuIdentitat {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tamany = sc.nextInt();

		int[][] mat = new int[tamany][tamany];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = 0;
			}
		}

		for (int i = 0; i < mat.length; i++) {
			mat[i][i] = 1;
		}

		// printar
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println("");
		}
	}

}
