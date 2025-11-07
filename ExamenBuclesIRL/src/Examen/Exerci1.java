package Examen;

import java.util.Scanner;

public class Exerci1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int Laura = 6;
		int David = 5;
		int valoraciones = 0;
		boolean TortitasBicenturi = false;
		boolean acaba = false;

		while (acaba == false) {

			String punto = sc.nextLine();

			if (punto.equals("DAVID")) {
				David++;
				valoraciones++;
			} else if (punto.equals("LAURA")) {
				Laura++;
				valoraciones++;
			} else if (punto.equals("JORDI")) {
				TortitasBicenturi = true;
			}
			if (Laura == 10 || David == 10) {
				acaba = true;
			} else if (valoraciones == 5) {
				acaba = true;
			}
		}
		if (TortitasBicenturi == true) {
			System.out.println("Guanya Jordi perque es el millor MASTERCHEF");
		} else if (David < Laura) {
			System.out.println("Guaya Laura amb " + Laura + " I han valorat " + valoraciones + " Jutges");
		} else if (David > Laura) {
			System.out.println("Guanya David amb " + David + " I han valorat " + valoraciones + " Jutges");
		} else if (David == Laura) {
			System.out.println("EMPAT");
		}
	}
}
