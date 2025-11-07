package Examen;

import java.util.Scanner;

public class Exercici2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		long capacitat = sc.nextInt();
		int casos = sc.nextInt();
		int aforament = 0;
		int maxafo = 0;
		int gentesale = 0;
		int max = 0;

		for (int i = 0; i < casos; i++) {
			int entrada = sc.nextInt();
			int salida = sc.nextInt();
			
			max = entrada + max;
			gentesale = salida + gentesale;
			aforament = max - gentesale;
		}
		if(maxafo < max) {
			maxafo = max + maxafo;
		}
		if (aforament >= capacitat || aforament < 0) {
			System.out.println("ERROR");
		} else {
			System.out.println(maxafo);
			System.out.println(aforament);
		}
	}
}
