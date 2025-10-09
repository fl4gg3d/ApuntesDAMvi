package Ejercicios;

import java.util.Scanner;

public class Hora_Valida {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int hores = sc.nextInt();
		int minuts = sc.nextInt();
		int segons = sc.nextInt();
		
		
		
		if(hores <= 23 && minuts <= 59 && segons <= 59) {
			System.out.println("SI");
		}
		else {
			System.out.println("NO");
		}

	}

}
