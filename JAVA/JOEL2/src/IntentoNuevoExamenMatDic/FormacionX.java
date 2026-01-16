package IntentoNuevoExamenMatDic;

import java.util.Scanner;

public class FormacionX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int f = sc.nextInt();
		int c = sc.nextInt();
		
		int[][] mat = new int[f][c];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int fX = sc.nextInt();
		int cX = sc.nextInt();
		int count = 0;
		
		if(mat[fX][cX] == 0) {
			//no hay avion
			System.out.println("DOWN");
			}
		else {
			// arribaDerecha
			if(!esticFora(mat, fX - 1, cX + 1) && mat[fX - 1][cX + 1] == 1) {
				count++;
			}
			// abajoDerecha
			if(!esticFora(mat, fX + 1, cX + 1) && mat[fX + 1][cX + 1] == 1) {
				count++;
			}
			// arribaIzquierda
			if(!esticFora(mat, fX - 1, cX - 1) && mat[fX - 1][cX - 1] == 1) {
				count++;
			}
			// abajoIzquierda
			if(!esticFora(mat, fX - 1, cX + 1) && mat[fX + 1][cX - 1] == 1) {
				count++;
			}
		}
		
		if(count == 4) {
			System.out.println("X");
		}
		if(count < 4 && count != 0) {
			System.out.println("PARTIAL X");
		}
		if(count == 0 && mat[fX][cX] != 0) {
			System.out.println("ALONE");
		}
			
		}
		
	private static boolean esticFora(int[][] mat, int f, int c) {

			if (f < 0 || c < 0 || f > mat.length - 1 || c > mat[0].length - 1) {
				return true;
			} else {

				return false;
			}
		
		
	}

}
