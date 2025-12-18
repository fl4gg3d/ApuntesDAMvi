package matrius;

import java.util.Scanner;

public class EscriuMatriu2 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int filas = sc.nextInt();
		int columnas = sc.nextInt();
		int [][] mat = new int [filas][columnas];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		int numCam = sc.nextInt();
		int numRemplace = sc.nextInt();
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				if(mat[i][j] == numCam) {
					mat[i][j] = numRemplace;
				}
			}
		}
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
}
