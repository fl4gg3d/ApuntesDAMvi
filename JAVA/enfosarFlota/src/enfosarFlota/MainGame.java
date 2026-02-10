package enfosarFlota;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class MainGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		PlayerInfo p1 = new PlayerInfo();
		int[][] flotaFalsa = new int[10][10];
		int[][] flotaReal = new int[10][10];

		menu();
		boolean intro = false;

		while (!intro) {

			int inputUserMenu = sc.nextInt();

			switch (inputUserMenu) {
			case 1:
				mainGame(flotaFalsa, flotaReal, p1);
				break;
			case 2:
				intro = false;
				break;
			default:
				break;
			}
		}

	}

	private static void mainGame(int[][] flotaFalsa, int[][] flotaReal, PlayerInfo p1) {

		rellenarTableroF(flotaFalsa);
		rellenarTableroR(flotaReal);
		mostrarTableroF(flotaFalsa);
		boolean gameInProgress = true;
		while(gameInProgress) {
			sacarPosicion(p1);
			bombardear(flotaReal, flotaFalsa, p1);
		}
		
		
		
	}

	private static void bombardear(int[][] flotaReal, int[][] flotaFalsa, PlayerInfo p1) {
		
		if(flotaReal[p1.posF][p1.posC] == 0) {
			System.out.println("AGUA!");
		} else {
			flotaFalsa[p1.posF][p1.posC] = flotaReal[p1.posF][p1.posC];
			System.out.println("ENFONSAT!");
			p1.movements++;
		}
		
	}

	private static void sacarPosicion(PlayerInfo p1) {
		System.out.println("Selecciona on vols llançar el missil: (ex: 1,a)");
		String position = sc.nextLine();
		pasarLetra(p1,position);
	}

	private static void pasarLetra(PlayerInfo p1, String position) {
		
		
		
		String[] split = position.split(",");
		p1.posC = Integer.parseInt(split[0]);
		String sfil = split[1].toLowerCase();
		char cfil = sfil.charAt(0);
		p1.posF = cfil - 'a';
	}

	private static void rellenarTableroR(int[][] flotaReal) {
		ArrayList<Integer> numeros = new ArrayList<Integer>();
		for (int i = 0; i < 8; i++) {
			numeros.add(1);
		}
		for (int i = 0; i < 92; i++) {
			numeros.add(0);
		}
		boolean noInvalido = false;
		while (!noInvalido) {
			Collections.shuffle(numeros);
			int index = 0;
			for (int i = 0; i < flotaReal.length; i++) {
				for (int j = 0; j < flotaReal[0].length; j++) {
					flotaReal[i][j] = numeros.get(index);
					index++;
				}
			}
			noInvalido = alrededor(flotaReal);
		}
		
	}

	private static boolean alrededor(int[][] flotaReal) {
		boolean noInvalido = true;

		for (int i = 0; i < flotaReal.length; i++) {
			for (int j = 0; j < flotaReal[0].length; j++) {
				if (flotaReal[i][j] == 1) {
					if(comprobar(flotaReal, i, j)) {
						return false;
					}
				}
			}
		}
		return noInvalido;
	}

	private static boolean comprobar(int[][] flotaReal, int i, int j) {

		if (/* arriba */!esticFora(flotaReal, i - 1, j) && flotaReal[i - 1][j] == 1 ||
		/* derecha */!esticFora(flotaReal, i, j + 1) && flotaReal[i][j + 1] == 1 ||
		/* abajo */!esticFora(flotaReal, i + 1, j) && flotaReal[i + 1][j] == 1 ||
		/* izquierda */!esticFora(flotaReal, i, j - 1) && flotaReal[i][j - 1] == 1 ||
		/* arribaD */!esticFora(flotaReal, i - 1, j + 1) && flotaReal[i - 1][j + 1] == 1 ||
		/* arribaI */!esticFora(flotaReal, i - 1, j - 1) && flotaReal[i - 1][j - 1] == 1 ||
		/* abajoD */!esticFora(flotaReal, i + 1, j + 1) && flotaReal[i + 1][j + 1] == 1 ||
		/* abajoI */!esticFora(flotaReal, i + 1, j - 1) && flotaReal[i + 1][j - 1] == 1) {
			return true;
		}

		return false;
	}

	private static boolean esticFora(int[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}
	}

	private static void mostrarTableroF(int[][] flotaFalsa) {
		for (int i = 0; i < flotaFalsa.length; i++) {
			for (int j = 0; j < flotaFalsa[0].length; j++) {
				System.out.print(flotaFalsa[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void rellenarTableroF(int[][] flotaFalsa) {
		for (int i = 0; i < flotaFalsa.length; i++) {
			for (int j = 0; j < flotaFalsa[0].length; j++) {
				flotaFalsa[i][j] = 0;
			}
		}
	}

	private static void menu() {

		System.out.println("1. Jugar");
		System.out.println("2. Exit");

	}

}
