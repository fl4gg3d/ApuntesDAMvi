package matrius;

import java.util.Iterator;
import java.util.Scanner;

public class travolta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int f = sc.nextInt();
		int c = sc.nextInt();

		// numero seleccionado
		int numT = sc.nextInt();
		boolean noT = false;
		boolean yesT = false;
		int numTF = 0;
		
		int[][] mat = new int[f][c];

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if (!esticFora(mat, i, j + 1) && !esticFora(mat, i, j - 1)) {
					if (mat[i][j + 1] == numT && mat[i][j - 1] == numT) {
						yesT = true;
						numTF = mat[i][j];
					}
				}
			}
		}
		if(yesT) {
			System.out.println(numTF);
		}else {
			System.out.println("NO");
		}
		
	}

	private static boolean esticFora(int[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}

	}

}
