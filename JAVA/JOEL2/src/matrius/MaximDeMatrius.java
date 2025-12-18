package matrius;

import java.util.Scanner;

public class MaximDeMatrius {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			int fila = sc.nextInt();
			int colum = sc.nextInt();

			int[][] mat = new int[fila][colum];

			int pos1 = 0;
			int pos2 = 0;
			int MAX = 0;

			for (int j = 0; j < mat.length; j++) {
				for (int j2 = 0; j2 < mat[0].length; j2++) {
					mat[j][j2] = sc.nextInt();
					if(mat[j][j2] > MAX) {
						MAX = mat[j][j2];
					}
				}
			}
			for (int j = 0; j < mat.length; j++) {
				for (int j2 = 0; j2 < mat[0].length; j2++) {
					if(mat[j][j2] == MAX) {
						pos1 = j + 1;
						pos2 = j2 + 1;
					}
				}
			}
			System.out.print(pos1+ " ");
			System.out.print(pos2);
		}
	}

}
