package Ejercicios;

import java.util.Scanner;

public class Ambrosio {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		
		for(int j = 0; j < casos; j++) {
			
			int pisos = sc.nextInt();
			
			double bombon = 0;
			
			for(double i = 1; i <= pisos; i++) {
				bombon = bombon + Math.pow(i, 2);
			}
			
			int Bombones = (int)bombon;
			System.out.println(Bombones);
			
		}
		

	}

}
