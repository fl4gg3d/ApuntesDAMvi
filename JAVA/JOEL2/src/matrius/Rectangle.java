package matrius;

import java.util.Scanner;

public class Rectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int Filas = sc.nextInt();
		int Colums = sc.nextInt();
		
		int f1 = sc.nextInt();
		int c1 = sc.nextInt();
		
		int f2 = sc.nextInt();
		int c2 = sc.nextInt();
		String[][] matriu = new String[Filas][Colums];
		
		//OmplirMat
		for (int i = 0; i < matriu.length; i++) {
			for (int j = 0; j < matriu[0].length; j++) {
				matriu[i][j] = ".";
			}
		}
		
		for (int i = 0; i < matriu.length; i++) {
			for (int j = 0; j < matriu[0].length; j++) {
				if(i >= f1 && j >= c1 && i <= f2 && j <= c2) {
					matriu[i][j] = "X";
				}
			}
		}
		
		
		//PrintarMat
		for (int i = 0; i < matriu.length; i++) {
			for (int j = 0; j < matriu[0].length; j++) {
				System.out.print(matriu[i][j] + " ");
			}
			System.out.println();
		} 
		
	}

}
