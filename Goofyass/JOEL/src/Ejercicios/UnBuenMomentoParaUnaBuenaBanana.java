package Ejercicios;

import java.util.Scanner;

public class UnBuenMomentoParaUnaBuenaBanana {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			 int vida = sc.nextInt();
			 int daño = sc.nextInt();
			 if (vida > daño) {
				 if(daño > vida * 0.2) {
					 System.out.println("Momento Banana");
				 }
				 else {
					 System.out.println("Nope");
				 }
			 }
			 else {
				 System.out.println("Nope");
			 }
		}
	}
}
