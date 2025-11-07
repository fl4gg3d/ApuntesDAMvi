package Ejercicios;

import java.util.Scanner;

public class IntervalDeNumeros {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		
		int num2 = sc.nextInt();
		
		if(num1 >= num2) {
			for(int i = num1; i >= num2; i--) {
				System.out.println(i);
			}
		}
		else {
			System.out.println("El segon numero no es mes petit que el primer");
		}
		
		

	}

}
