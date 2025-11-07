package Ejercicios;

import java.util.Scanner;

public class ElsDonutsAmelia {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			int x = a;
			int y = b;
			
			while(y != 0) {
				int temp = y;
				y = x % y;
				x = temp;
			}
			int mcd_ab = x;
			
			int mcm_ab = (a * b)/ mcd_ab;
		}
		
	}

}
