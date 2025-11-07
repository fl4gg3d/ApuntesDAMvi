package Ejercicios;

import java.util.Scanner;

public class SumadePatates2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; casos > i; i++) {
			int cacaute = sc.nextInt();
			int suma = 0;
			
			for(int j = 0; j < cacaute; j++) {
				
				int patatas = sc.nextInt();
				suma += patatas;
				
			}
			System.out.println(suma);
		}
		
	}

}
