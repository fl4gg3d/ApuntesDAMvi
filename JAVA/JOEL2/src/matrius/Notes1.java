package matrius;

import java.util.Scanner;

public class Notes1 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			int fila = sc.nextInt();
			int colum = sc.nextInt();
			int[][] notas = new int[fila][colum];

			for (int j = 0; j < notas.length; j++) {
				for (int j2 = 0; j2 < notas[0].length; j2++) {
					notas[j][j2] = sc.nextInt();
				}
			}
			int conta = 0;
			
		}
	}
}
