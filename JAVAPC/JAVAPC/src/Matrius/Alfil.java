package Matrius;

import java.util.Scanner;

public class Alfil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			String pos = sc.next();
			
			char letra = pos.charAt(0);
			char numero = pos.charAt(1);
			
			String[][] mat = new String[8][8];
			for (int j = 0; j < mat.length; j++) {
				for (int j2 = 0; j2 < mat[0].length; j2++) {
					mat[j][j2] = ".";
				}
			}
			
		}
		
	}

}
