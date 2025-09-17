package Goofy;

import java.util.Scanner;

public class HelloWorld2 {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Elige suma(1) o resta(2) ");
		
		int respuesta = sc.nextInt();
		
		if(respuesta == 1) {
			System.out.println("Usted a elegido suma");
			System.out.println("Escribe el primer numero: ");
			int num1 = sc.nextInt();
			sc.nextLine();
			System.out.println("Escriba el segundo numero");
			int num2 = sc.nextInt();
			int suma = num1 + num2;
			System.out.println("HelloWorld");
		}
		else if(respuesta == 2) {
			System.out.println("Usted a elegido resta");
			System.out.println("Escribe el primer numero: ");
			int num1 = sc.nextInt();
			sc.nextLine();
			System.out.println("Escriba el segundo numero");
			int num2 = sc.nextInt();
			int resta = num1 - num2;
			System.out.println("HelloWorld");
		}
	}

}
