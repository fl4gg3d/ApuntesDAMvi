package Matrius;

import java.util.Scanner;

public class GatoEnRaya {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			int f = sc.nextInt();
			int c = sc.nextInt();
			
			int[][] mat = new int[f][c];
			
			for (int j = 0; j < mat.length; j++) {
				for (int j2 = 0; j2 < mat[0].length; j2++) {
					mat[j][j2] = sc.nextInt();
				}
			}
			
			int count = 0;
			
			for (int j = 0; j < mat.length; j++) {
				for (int j2 = 0; j2 < mat[0].length; j2++) {
					if(mat[j][j2] != 0) {
						if(!esticFora(mat, j, j2 + 2) && mat[j][j2 + 1] == 1 && mat[j][j2 + 2] == 1) {
							count++;
							mat[j][j2 + 1] = 0;
							mat[j][j2 + 2] = 0;
						}
						if(!esticFora(mat, j + 2, j2) && mat[j + 1][j2] == 1 && mat[j + 2][j2] == 1){ 
							count++;
							mat[j + 1][j2] = 0;
							mat[j + 2][j2] = 0;
						}
						if(!esticFora(mat, j + 2, j2 + 2) && mat[j + 1][j2 + 1] == 1 && mat[j + 2][j2 + 2] == 1){ 
							count++;
							mat[j + 1][j2 + 1] = 0;
							mat[j + 1][j2 + 2] = 0;
						}
					}
					
					
				}
			}
			
			System.out.println(count);
			
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
