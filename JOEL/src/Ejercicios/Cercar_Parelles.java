package Ejercicios;

import java.util.Scanner;

public class Cercar_Parelles {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();

		int b = sc.nextInt();

		int c = sc.nextInt();

		if (a == b && b == c) {
			System.out.println("SI");
		} else if (a == b || a == c || b == a || b == c || c == a || c == b) {
			System.out.println("SI");
		} else {
			System.out.println("NO");
		}
	}
}
