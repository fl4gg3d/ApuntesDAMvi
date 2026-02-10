package memory;

import java.util.Scanner;

public class MainGame {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Player p1 = new Player();
		Player p2 = new Player();
		
		int inputMenu;
		inputMenu = menu();
		boolean menu = true;
		
		sc.nextLine();
		
		while(menu) {
			switch (inputMenu) {
			case 1:
				mainGame(p1, p2);
				break;
			case 2:
				settings(p1, p2);
				break;
			default:
				System.out.println("Valor invalido");
				break;
			}
		}
		
	}

	private static void settings(Player p1, Player p2) {
		
		System.out.println("1. Nom");
		System.out.println("2. Tamany tauler");
		System.out.println("3. Sortir y mostrar configuracion actual");
		
		int settings = sc.nextInt();
		
		sc.nextLine();
		
		switch (settings) {
		case 1:
			canviNom(p1, p2);
			break;
		case 2:
			canviTamany(p1);
			break;
		case 3:
			System.out.println("Noms: "+p1.nom + " y " + p2.nom);
			System.out.println("Tamany tauler: " + p1.F + "/" + p1.C);
			menu();
			break;
		default:
			break;
		}
		
	}

	private static void canviTamany(Player p1) {
		
		System.out.println("nombre de files");
		p1.F = sc.nextInt();
		System.out.println("nombre de columnes");
		p1.C = sc.nextInt();
		
	}

	private static void canviNom(Player p1, Player p2) {
		
		System.out.println("nom jugador 1: ");
		p1.nom = sc.nextLine(); 
		System.out.println("nom jugador 2: ");
		p2.nom = sc.nextLine();
	}

	private static void mainGame(Player p1, Player p2) {
		
		if (p1.nom == null) {
			System.out.println("No has afegit nom als jugadors");
			canviNom(p1, p2);
		}
		
		int[][] tauler = new int[p1.F][p1.C];
		
	}

	private static int menu() {

		System.out.println("1. Play");
		System.out.println("2. Settings");
		System.out.println("3. Exit");
		
		int menuInput = sc.nextInt();
		
		return menuInput;
	}

}
