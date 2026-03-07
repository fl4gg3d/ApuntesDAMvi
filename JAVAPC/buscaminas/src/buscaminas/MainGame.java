package buscaminas;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import Core.Board;
import Core.Window;

public class MainGame {

	static int nMines = 5;
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> guanyar = new ArrayList<String>();

	public static void main(String[] args) {
		//Hola Dani, cuidado con el volumen ejecutarlo.
		
		// Interfaz Grafica
		Board b = new Board();
		Window f = new Window(b);
		b.setFont(new Font("Comic Sans", Font.BOLD, 35));
		f.changeSize(800, 600);
		b.setActimgbackground(true);
		b.setImgbackground("assets/images/nija.png");
		b.setActborder(true);
		String[] lletres = { "", "1", "2", "3", "4", "5", "6", "7", "8", "*", "🚩", "💣" };
		b.setText(lletres);
		int[] colorlletres = { 0x0000FF, 0x00FF00, 0xFFFF00, 0xFF0000, 0xFF00FF, 0x00FFFF, 0x521b98, 0xFFFFFF, 0xFF8000,
				0x7F00FF, 0xFF0000, 0xFF0000};
		b.setColortext(colorlletres);
		f.setTitle("Buscaminas");
		f.playMusic("assets/music/fondo.wav");

		// End interfaz grafica
		// TODO Auto-generated method stub
		Player p1 = new Player();
		p1.nom = "p1";
		config conf1 = new config();
		Position pos = new Position();

		boolean menu = true;
		
		while (menu) {
			
			String opcio = f.showInputPopup("¡HolaMundo!\n\n"+"1 - Jugar\n"+"2 - Opcions\n"+"3 - Sortir\n"+"4 - Aiuda");

			switch (opcio) {
			case "1":
				mainGame(p1, conf1, pos, b, f);
				break;
			case "2":
				settings(conf1, p1, f);
				break;
			case "3":
				menu = false;
				f.close();
				break;
			case "4":
				ayuda(p1, f);
				break;
			default:
				f.showPopup("Input invalido");
				break;
			}
		}

	}

	private static void ayuda(Player p1, Window f) {
		boolean aiuda = true;
//		visualAiuda();
		while (aiuda) {
			String opcio = f.showInputPopup("Opcions\n"+"1 - Mostrar nom\n"+"2 - Mostrar llista guanyadors\n"+"3 - Sortir\n");
			switch (opcio) {
			case "1":
				f.showPopup(p1.nom);
				break;
			case "2":
				System.out.println();
				String guanyadors = "";
				System.out.println("Guanyadors:\n");
				for (String nomPlayer : guanyar) {
					guanyadors += nomPlayer + "\n";
				}
				f.showPopup(guanyadors);
				break;
			case "3":
				aiuda = false;
				break;
			default:
				f.showPopup("Input invalido");
				break;
			}
//			visualAiuda();
		}

	}
//	Abans de saber del showInputPopUp tenia aquesta funcio que mostraba la part visual d'opcions
//	private static void visualAiuda() {
//		System.out.println();
//
//		System.out.println("1. Nom actual");
//		System.out.println("2. Guanyadors");
//		System.out.println("3. Sortir");
//
//		System.out.println();
//	}

	/**
	 * Ejecuta la lógica principal de una partida.
	 *
	 * Inicializa el tablero, coloca las minas y gestiona el turno del jugador hasta
	 * que la partida finaliza.
	 *
	 * @param p1    jugador actual
	 * @param conf1 configuración del tablero
	 * @param pos   objeto que almacena la posición seleccionada
	 * @param b
	 * @param f
	 */
	private static void mainGame(Player p1, config conf1, Position pos, Board b, Window f) {
		boolean gameOn = true;
		int[][] camp = new int[conf1.tamF][conf1.tamC];
		int[][] mines = new int[conf1.tamF][conf1.tamC];
		inicialitzarMines(mines, conf1);
		inicialitzarCamp(camp);
		System.out.println();

		while (gameOn) {
			visualitzarCamp(camp, b);
			demanarcoord(pos, b, camp, f);
			descobrir(pos.posF, pos.posC, mines, camp, p1, pos.clic, f);
			gameOn = partidaAcabada(pos.posF, pos.posC, mines, camp, p1, f);
		}
		fiPartida(camp, mines, b);
	}

	/**
	 * Comprueba si la partida ha terminado.
	 *
	 * La partida termina cuando: - El jugador selecciona una mina. - Se descubren
	 * todas las casillas sin minas.
	 *
	 * @param posF  fila seleccionada
	 * @param posC  columna seleccionada
	 * @param mines matriz que contiene las minas
	 * @param camp  tablero visible del jugador
	 * @param p1    jugador actual
	 * @param f
	 * @return true si la partida continúa, false si ha terminado
	 */
	private static boolean partidaAcabada(int posF, int posC, int[][] mines, int[][] camp, Player p1, Window f) {
		boolean fi = true;
		if (mines[posF][posC] == 11) {
			f.playSFX("assets/sounds/bomb.wav");
			fi = false;
			f.showPopup("HAS PERDIDO 😭😭");
		} else if (fi) {
			int cont = 0;
			for (int i = 0; i < camp.length; i++) {
				for (int j = 0; j < camp[0].length; j++) {
					if (camp[i][j] == 9) {
						cont++;
					}
				}
			}
			if (cont == nMines) {
				f.playSFX("assets/sounds/victory.wav");
				fi = false;
				guanyar.add(p1.nom);
				f.showPopup("HAS GANADO 👍🤙");
			}
		}
		return fi;
	}

	/**
	 * Muestra el mensaje de fin de partida.
	 *
	 * @param camp  tablero visible
	 * @param mines tablero con la posición de las minas
	 * @param b     b
	 * @param p1    jugador actual
	 */
	private static void fiPartida(int[][] camp, int[][] mines, Board b) {
		visualitzarCamp(mines, b);

	}

	/**
	 * Solicita al jugador las coordenadas que desea descubrir.
	 *
	 * @param pos  objeto donde se guardan fila y columna elegidas
	 * @param b
	 * @param camp
	 * @param f 
	 */
	private static void demanarcoord(Position pos, Board b, int[][] camp, Window f) {
		boolean posActua = false;
		do {

			try {
				Thread.sleep(50); /// donem una mica de retard per no colapsar el buffer del mouse.
			} catch (InterruptedException e) {
			}

			int leftCol = b.getCurrentMouseCol();
			int leftRow = b.getCurrentMouseRow();
			if (leftCol != -1 && leftRow != -1) {
				pos.clic = "left";
				pos.posF = leftRow;
				pos.posC = leftCol;
				posActua = true;
				f.playSFX("assets/sounds/wire.wav");
			}
			int rightCol = b.getCurrentRightMouseCol();
			int rightRow = b.getCurrentRightMouseRow();
			if (rightCol != -1 && rightRow != -1) {
				pos.clic = "right";
				pos.posF = rightRow;
				pos.posC = rightCol;
				posActua = true;
			}
		} while (!posActua);
	}

	/**
	 * Descubre una casilla del tablero.
	 *
	 * Si la casilla no tiene minas alrededor, descubre recursivamente las casillas
	 * vecinas.
	 *
	 * @param posF  fila seleccionada
	 * @param posC  columna seleccionada
	 * @param mines matriz de minas
	 * @param camp  tablero visible
	 * @param p1    jugador actual
	 * @param clic
	 * @param f
	 * @return tablero actualizado
	 */
	private static void descobrir(int posF, int posC, int[][] mines, int[][] camp, Player p1, String clic, Window f) {

		if (clic.equals("left")) {

			if (esticFora(camp, posF, posC) || camp[posF][posC] != 9) {
				return;
			}

			int n = destapar(posF, posC, mines, camp, p1, f);
			camp[posF][posC] = n;

			if (n == 0) {
				// arriba
				if (!esticFora(camp, posF - 1, posC) && mines[posF - 1][posC] == 0) {
					descobrir(posF - 1, posC, mines, camp, p1, clic, f);
				}
				// abajo
				if (!esticFora(camp, posF + 1, posC) && mines[posF + 1][posC] == 0) {
					descobrir(posF + 1, posC, mines, camp, p1, clic, f);
				}
				// derecha
				if (!esticFora(camp, posF, posC + 1) && mines[posF][posC + 1] == 0) {
					descobrir(posF, posC + 1, mines, camp, p1, clic, f);
				}
				// izquierda
				if (!esticFora(camp, posF, posC - 1) && mines[posF][posC - 1] == 0) {
					descobrir(posF, posC - 1, mines, camp, p1, clic, f);
				}
			}
		} else {
			if (camp[posF][posC] == 9) {
				camp[posF][posC] = 10;
			} else if (camp[posF][posC] == 10) {
				camp[posF][posC] = 9;
			}
		}
	}

	/**
	 * Cuenta el número de minas adyacentes a una casilla.
	 *
	 * Si la casilla contiene una mina, se notifica al jugador.
	 *
	 * @param posF  fila seleccionada
	 * @param posC  columna seleccionada
	 * @param mines matriz de minas
	 * @param camp  tablero visible
	 * @param p1    jugador actual
	 * @param f2
	 * @return número de minas adyacentes
	 */
	private static int destapar(int posF, int posC, int[][] mines, int[][] camp, Player p1, Window f2) {

		int contar = 0;

		if (mines[posF][posC] != 1) {
			for (int i = -1; i <= 1; i++) {
				for (int j = -1; j <= 1; j++) {

					int f = posF + i;
					int c = posC + j;

					if (!esticFora(mines, f, c) && mines[f][c] == 11) {
						contar++;
					}

				}
			}
		} else {
			System.out.println("Mina");
			partidaAcabada(posF, posC, mines, camp, p1, f2);
		}
		return contar;

	}

	private static void visualitzarCamp(int[][] camp, Board b) {
		b.draw(camp, 't');
	}

	/**
	 * Inicializa el tablero visible llenándolo con el valor 9, que representa
	 * casillas ocultas.
	 *
	 * @param camp matriz del tablero
	 */
	private static void inicialitzarCamp(int[][] camp) {
		for (int i = 0; i < camp.length; i++) {
			for (int j = 0; j < camp[0].length; j++) {
				camp[i][j] = 9;
			}
		}
	}

	/**
	 * Coloca minas aleatoriamente en el tablero.
	 *
	 * @param mines matriz donde se almacenan las minas
	 * @param conf1 configuración del tablero
	 */
	private static void inicialitzarMines(int[][] mines, config conf1) {
		
		for (int i = 0; i < nMines; i++) {
			boolean valido = false;
			while(!valido) {
				Random rand = new Random();
				
				int f = rand.nextInt(0, conf1.tamF);
				int c = rand.nextInt(0, conf1.tamC);
				
				if(mines[f][c] != 11) {
					mines[f][c] = 11;
					valido = true;
				}
			}
		}
	}
//  Antes de tener el showInputPopUp mostraba por consola el menu
//	private static void menu() {
//		System.out.println();
//
//		System.out.println("1. Jugar");
//		System.out.println("2. Opcions");
//		System.out.println("3. Sortir");
//		System.out.println("4. Aiuda");
//
//		System.out.println();
//	}

	/**
	 * Muestra el menú de configuración.
	 *
	 * Permite cambiar: - Tamaño del tablero - Nombre del jugador
	 *
	 * @param conf1 configuración del tablero
	 * @param p1    jugador actual
	 * @param f 
	 */
	private static void settings(config conf1, Player p1, Window f) {
		boolean settings = true;
//		settingDisplay();
		while (settings) {
			
			String opcio = f.showInputPopup("Opcions\n"+"1 - Canviar parametres joc\n"+"2 - Canviar nom\n"+"3 - Sortir\n");

			switch (opcio) {
			case "1":
				canviarJoc(conf1, f);
				break;
			case "2":
				canviarNom(p1, f);
				break;
			case "3":
				settings = false;
				break;
			default:
				f.showPopup("Input invalido");
				break;
			}

		}
	}

//	private static void settingDisplay() {
//		System.out.println("1. Canviar camp joc");
//		System.out.println("2. Canviar nom");
//		System.out.println("3. Sortir");
//	}

	/**
	 * Permite modificar la configuración del tablero.
	 *
	 * El usuario puede definir: - Número de filas - Número de columnas - Número de
	 * minas
	 *
	 * @param conf1 configuración del tablero
	 * @param f 
	 */
	private static void canviarJoc(config conf1, Window f) {
		boolean confCorrecte = false;
		while (!confCorrecte) {
			String tamFS = f.showInputPopup("Selecciona tamany files: \n");
			conf1.tamF = Integer.parseInt(tamFS);
			String tamCS = f.showInputPopup("Selecciona tamany columnes: \n");
			conf1.tamC = Integer.parseInt(tamCS);
			String nMinesS = f.showInputPopup("Selecciona el num de mines: \n");
			nMines = Integer.parseInt(nMinesS);

			String resposta = f.showInputPopup("Configuracio actual: \n"+"Tamany = " + conf1.tamF + "x" + conf1.tamC+"\n"+"Num. Mines = " + nMines+"\n"+"Esta tot correcte?: (ex: Yes/No)");
			if (resposta.toLowerCase().equals("yes")) {
				confCorrecte = true;
//				settingDisplay();
			}
		}
	}

	private static void canviarNom(Player p1, Window f) {
		boolean nombreCorrecto = false;
		while (!nombreCorrecto) {
			p1.nom = f.showInputPopup("Introdueix un nom:\n");
			String inputNom = f.showInputPopup("És aquest nom correcte?: ex:(yes/no)\n" + "------" + p1.nom + "------");
			if (inputNom.toLowerCase().equals("yes")) {
				nombreCorrecto = true;
//				settingDisplay();
			}
		}
	}

	/**
	 * Comprueba si una posición está fuera de los límites del tablero.
	 *
	 * @param mat2 matriz de referencia
	 * @param f    fila
	 * @param c    columna
	 * @return true si está fuera, false si está dentro
	 */
	private static boolean esticFora(int[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}
	}
}
