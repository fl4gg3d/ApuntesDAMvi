package memory;

import java.util.Scanner;

public class memory {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args){

		boolean sortir = false;

		menu();
		
		while (!sortir) {
			
			int userResponse = sc.nextInt();
			
			switch (userResponse) {
			case 1:
				System.out.println("1");
				break;
			case 2:
				setting();
			case 3:
				System.out.println("3");
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

	private static void setting() {
		
		jugadors jug1 = new jugadors();
		jugadors jug2 = new jugadors();
		
		System.out.println("1. Change name");
		System.out.println("2. Back");
		
		int userSetting = sc.nextInt();
		
		if(userSetting == 1) {
			jug1.nom = sc.nextLine();
			jug2.nom = sc.nextLine();
		}
		
	}

	private static void menu() {
		System.out.println("1. Play");
		System.out.println("2. Settings");
		System.out.println("3. Victories");
		System.out.println("4. Exit");
	}

}
