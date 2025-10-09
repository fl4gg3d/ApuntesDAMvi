package Ejercicios;

import java.util.Scanner;

public class Compte_Enrere {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int numero_cuenta = sc.nextInt();
		
		for(int i = numero_cuenta; i >= 0; i-- ) {
			System.out.println(i);
		}
	}
}
