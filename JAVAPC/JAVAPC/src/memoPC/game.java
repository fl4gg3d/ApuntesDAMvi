package memoPC;

import java.util.Scanner;

public class game {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			
			players[] playersArray = playersFunction();
			players player1 = playersArray[0];
			players player2 = playersArray[1];
		
			boolean sortir = false;

			menu();
			
			while (!sortir) {
				
				int userResponse = sc.nextInt();
				
				sc.nextLine();
				
				switch (userResponse) {
				case 1:
					System.out.println("1");
					break;
				case 2:
					setting(player1, player2);
					break;
				case 3:
					victoriesCount(player1, player2);
					break;
				case 4:
					sortir = true;
					System.out.println("See you next time!");
					break;
				default:
					System.out.println(" Wrong Value | Please select a number bettwen 1 - 4");
				}
				
				
			}

		}
		
		private static void victoriesCount(players player1,players player2) {
			System.out.println("El nombre de victories de " + player1.nom + " es igual a " + player1.numVictories);
			System.out.println("El nombre de victories de " + player2.nom + " es igual a " + player2.numVictories);
	}
		private static void setting(players player1,players player2) {
			
			System.out.println("1. Change name");
			System.out.println("2. Change board size");
			System.out.println("3. Exit");
			
			int userSetting = sc.nextInt();
			
			sc.nextLine();
			
			if(userSetting == 1) {
				player1.nom = sc.nextLine();
				player2.nom = sc.nextLine();
			}
			else if(userSetting == 2) {
				
			}
			else {
				menu();
			}
			
		}
		private static void menu() {
			System.out.println("1. Play");
			System.out.println("2. Settings");
			System.out.println("3. Victories");
			System.out.println("4. Exit");
		}
		private static players[] playersFunction() {
			players jug1 = new players();
			players jug2 = new players();
			players[] playeadores = new players[2];
			playeadores[0] = jug1;
			playeadores[1] = jug2;
			return playeadores;
		}


}

