package buscaminas;

import java.util.Random;
import java.util.Scanner;

public class MainGame {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Player p1 = new Player();
		config conf1 = new config();
		Position pos = new Position();
		
		boolean menu = true;
		
		menu();
		while(menu) {
			int menuInput = sc.nextInt();
			
			switch (menuInput) {
			case 1:
				mainGame(p1, conf1, pos.posF, pos.posC);
				break;
			case 2:
				settings(conf1, p1);
				break;
			case 3:
				menu = false;
				break;
			case 4: 
				ayuda();
			default:
				break;
			}
		}
		
	}

	private static void ayuda() {
		
	}
	
	private static void mainGame(Player p1, config conf1, int posF, int posC) {
		boolean gameOn = true;
		int[][] camp = new int[conf1.tamF][conf1.tamC];
		int[][] mines = new int[conf1.tamF][conf1.tamC];
		
		inicialitzarMines(mines, conf1);
		inicialitzarCamp(camp);
		
		while(gameOn) {
			demanarcoord(posF,posC);
			camp = descobrir(posF,posC,mines,camp);
			gameOn = partidaAcabada(posF,posC,camp);
			visualitzarCamp(camp);
		}
		fiPartida(camp,mines, p1);
	}

	private static boolean partidaAcabada(int posF, int posC, int[][] camp) {
		return false;
	}

	private static void fiPartida(int[][] camp, int[][] mines, Player p1) {
		// TODO Auto-generated method stub
	}

	private static void demanarcoord(int posF, int posC) {
		System.out.println("Selecciona fila: ");
		posF = sc.nextInt()-1;
		System.out.println("Selecciona columna: ");
		posC = sc.nextInt()-1;
	}

	private static int[][] descobrir(int posF, int posC, int[][] mines, int[][] camp) {
		
		int n = destapar(posF,posC,mines);
		camp[posF][posC] = n;
		
		return camp;
	}

	private static int destapar(int posF, int posC, int[][] mines) {
		
		return 0;
	}

	private static void visualitzarCamp(int[][] camp) {
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp[0].length; j++) {
				System.out.print(camp[i][j] + " ");
			}
			System.out.println("");
		}
	}

	private static void inicialitzarCamp(int[][] camp) {
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp[0].length; j++) {
				camp[i][j] = 9;
			}
		}
	}

	private static void inicialitzarMines(int[][] mines, config conf1) {
		Random f = new Random();
		Random c = new Random();
		for (int i = 0; i < conf1.nombreMines; i++) {
			mines[f.nextInt(0, conf1.tamF)][c.nextInt(0, conf1.tamC)] = 1;
		}
	}

	private static void menu() {
		System.out.println();
		
		System.out.println("1. Jugar");
		System.out.println("2. Opcions");
		System.out.println("3. Sortir");
		System.out.println("4. Aiuda");
		
		System.out.println();
	}
	
	
	private static void settings(config conf1, Player p1) {
		boolean settings = true;
		settingDisplay();
		while(settings) {
			int settingInput = sc.nextInt();
			
			switch (settingInput) {
			case 1:
				canviarJoc(conf1);
				break;
			case 2:
				sc.nextLine();
				canviarNom(p1);
				break;
			case 3:
				settings = false;
				menu();
			default:
				break;
			}
			
		}
	}

	private static void settingDisplay() {
		System.out.println("1. Canviar camp joc");
		System.out.println("2. Canviar nom");
		System.out.println("3. Sortir");
	}

	private static void canviarJoc(config conf1) {
		boolean confCorrecte = false;
		while(!confCorrecte) {
			System.out.println("Selecciona tamany files: ");
			conf1.tamF = sc.nextInt();
			System.out.println("Selecciona tamany columnes: ");
			conf1.tamC = sc.nextInt();
			System.out.println("Selecciona el num de mines: ");
			conf1.nombreMines = sc.nextInt();
			
			System.out.println("Configuracio actual: ");
			System.out.println("Tamany = " + conf1.tamF + "x" + conf1.tamC);
			System.out.println("Num. Mines = " + conf1.nombreMines);
			
			System.out.println("Esta tot correcte?: (ex: Y/N)");
			sc.nextLine();
			String resposta = sc.nextLine();
			if(resposta.toLowerCase().equals("y")) {
				confCorrecte = true;
				settingDisplay();
			}
		}		
	}
	private static void canviarNom(Player p1) {
		boolean nombreCorrecto = false;
		while(!nombreCorrecto) {
			System.out.println("Introdueix un nom:");
			p1.nom = sc.nextLine();
			
			System.out.println("Es este tu nombre? (ex: Y/N)");
			System.out.println("--"+p1.nom+"--");
			String inputNom = sc.nextLine();
			if(inputNom.toLowerCase().equals("y")) {
				nombreCorrecto = true;
				settingDisplay();
			}
		}
	}
	private static boolean esticFora(int[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}
	}
}
