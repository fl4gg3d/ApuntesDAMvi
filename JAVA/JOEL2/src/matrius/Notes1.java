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
			int cont = 0;
			for (int j = 0; j < notas.length; j++) {
				int suma = 0;
				for (int j2 = 0; j2 < notas[0].length; j2++) {
					suma +=	notas[cont][j2];
				}
				System.out.print(suma / colum + " ");
				cont++;
			}
		}
	}
}
