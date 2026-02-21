package uno;

import java.util.Scanner;

public class MainGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		boolean menuOn = true;

		menu();
		while (menuOn) {

			int menuInput = sc.nextInt();
			switch (menuInput) {
			case 1:
				game();
				break;
			case 2:
				settings();
				break;
			case 3:
				menuOn = false;
				break;
			default:
				break;
			}
		}
	}

	private static void game() {
		
		boolean fi = false;
		
		while(!fi) {
			seleccionarCarta();
			boolean cartaValida = esCartaValida();
			if(cartaValida) {
				tirarCarta();
			} else {
				robar();
			}
			canviTorn();
			fi = fiPartida();
		}
		
	}

	private static boolean fiPartida() {
		// TODO Auto-generated method stub
		return false;
	}

	private static void robar() {
		// TODO Auto-generated method stub
		
	}

	private static void canviTorn() {
		// TODO Auto-generated method stub
		
	}

	private static void tirarCarta() {
		// TODO Auto-generated method stub
		
	}

	private static void seleccionarCarta() {
		// TODO Auto-generated method stub
		
	}

	private static boolean esCartaValida() {
		// TODO Auto-generated method stub
		return false;
	}

	private static void settings() {
		// TODO Auto-generated method stub
		
	}

	private static void menu() {

		System.out.println("1. Jugar");
		System.out.println("2. Ajustes");
		System.out.println("3. Salir");

	}

}
