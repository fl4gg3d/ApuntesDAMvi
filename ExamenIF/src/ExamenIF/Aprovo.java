package ExamenIF;

import java.util.Scanner;

public class Aprovo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int nota1 = sc.nextInt();

		int nota2 = sc.nextInt();

		int nota3 = sc.nextInt();

		int suma = nota1 + nota2 + nota3;

		int media = suma / 3;

		System.out.println(media);

		if (nota1 == 0 || nota2 == 0 || nota3 == 0 || nota1 < 4 || nota2 < 4 || nota3 < 4) {
			System.out.println("SUSPES");
		}
		else if (media >= 5) {
			System.out.println("APROVAT");
		}
		else if (nota3 == 9 || nota3 == 10) {
			System.out.println("APROVAT FINAL");
		}
		else if (media < 5 ) {
			System.out.println("SUSPES");
		}
	}
}
