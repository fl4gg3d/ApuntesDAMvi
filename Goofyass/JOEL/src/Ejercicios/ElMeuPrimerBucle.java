 package Ejercicios;

import java.util.Scanner;

public class ElMeuPrimerBucle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		boolean a = true;
		
		
		while(a) {
			int num = sc.nextInt();
			
			
			if(num == 0) {
				a = false;
			}
			else {
				int suma = num + 1;
				System.out.println(suma);
			}
			
		}
		
		

	}

}
