package Ejercicios;

import java.util.Scanner;

public class SumaDePataques {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int camions = sc.nextInt();
		int acumulador = 0;
		
		for(int i = 0; i < camions; i++) {
			int patas = sc.nextInt();

			acumulador = patas + acumulador;
			
		}
		System.out.println(acumulador);
	}

}
