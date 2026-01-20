package matrius;

import java.util.Scanner;

public class GatoEnRaya {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			int files = sc.nextInt();
			int colum = sc.nextInt();
			int[][] mat = new int[files][colum];

			for (int j = 0; j < mat.length; j++) {
				for (int j2 = 0; j2 < mat[0].length; j2++) {
					mat[j][j2] = sc.nextInt();
				}
			}
			
			

		}

	}

	private static boolean esticfora(int[][] mat, int files, int colum) {

		if (files < 0 || colum < 0 || files > mat.length - 1 || colum > mat[0].length - 1) {

			return true;

		} else {

			return false;

		}

	}

}
