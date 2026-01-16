package matrius;

import java.util.Scanner;

public class BlackFriday {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int files = sc.nextInt();
		int colum = sc.nextInt();
		
		int[][] mat = new int [files][colum];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		
		int[][] matMulti = new int[files][colum];
		int multi = sc.nextInt();
		
		for (int i = 0; i < matMulti.length; i++) {
			for (int j = 0; j < matMulti[0].length; j++) {
				
				matMulti[i][j] = mat[i][j] * multi;
				
			}
		}
		
		for (int i = 0; i < matMulti.length; i++) {
			for (int j = 0; j < matMulti[0].length; j++) {
				System.out.print(matMulti[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
}
