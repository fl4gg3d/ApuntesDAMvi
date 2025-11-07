package Ejercicios;

import java.util.Scanner;

public class Felicitat_Ascendent {

	public static void main(String[] args) {
		
		int f1;
		int f2;
		int f3;
		
		Scanner sc = new Scanner(System.in);
		
		
		f1 = sc.nextInt();
		f2 = sc.nextInt();
		f3 = sc.nextInt();
		
		if(f1 < f2 && f2 < f3) {
			System.out.println("SI");
		}
		else {
			System.out.println("NO");
		}
	}

}
