package matrius;

import java.util.Scanner;

public class SumaDeMatrius {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int medida = sc.nextInt();

		int[][] mat = new int[medida][medida];
		int[][] mat2 = new int[medida][medida];
		int[][] matFinal = new int[medida][medida];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < mat2.length; i++) {
			for (int j = 0; j < mat2[0].length; j++) {
				mat2[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < matFinal.length; i++) {
			for (int j = 0; j < matFinal[0].length; j++) {

				matFinal[i][j] = mat[i][j] + mat2[i][j];

			}
		}

		for (int i = 0; i < matFinal.length; i++) {
			for (int j = 0; j < matFinal[0].length; j++) {
				System.out.print(matFinal[i][j] + " ");

			}
			System.out.println();
		}

	}

}
