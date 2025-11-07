package Ejercicios;

import java.util.Scanner;

public class DobleBucle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int koko = sc.nextInt();
	
		
		for(int i = 1; i <= koko; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print(i);
			}
		}
	}
}
