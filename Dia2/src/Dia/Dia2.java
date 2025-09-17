package Dia;

import java.util.Scanner;

public class Dia2 {

	public static void main(String[] args) {
		
		int Jugador2 = 0;
		int Jugador1 = 0;
		
		Scanner sc = new Scanner(System.in);

		Jugador1 = sc.nextInt();
		
		sc.nextLine();
		
		Jugador2 = sc.nextInt();
		
		if(Jugador1 > 3 || Jugador1 < 1 || Jugador2 > 3 || Jugador2 < 1 ) {
			System.out.println("ERROR");
		}
		else {
			if(Jugador1 == 1 && Jugador2 == 3) {
				System.out.println("Jugador1");
				}
			else if(Jugador1 == 2 && Jugador2 == 1){
					System.out.println("Jugador1");
				}
			else if (Jugador1 == 3 && Jugador2 == 2) {
					System.out.println("Jugador1");
				}
			else if(Jugador2 == 1 && Jugador1 == 3) {
				System.out.println("Jugador2");
				}
			else if(Jugador2 == 2 && Jugador1 == 1){
					System.out.println("Jugador2");
				}
			else if (Jugador2 == 3 && Jugador1 == 2) {
					System.out.println("Jugador2");
				}
			else if (Jugador1 == Jugador2){
				System.out.println("EMPATE");
			}
		}
		sc.close();
	}
}
