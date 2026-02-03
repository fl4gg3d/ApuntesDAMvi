package lightOutPackage;

import java.util.Scanner;

public class MainGame {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		//he decidido guardar el size en la classe player ya q se me hace mas comodo.
		
		boolean exit = false;

		Player p1 = new Player();

		menu();
		//opcions
		while (!exit) {

			int inputMenu = sc.nextInt();

			switch (inputMenu) {
			case 1:
				mainGame(p1);
				menu();
				break;
			case 2:
				settingsMenu(p1);
				break;
			case 3:
				exit = true;
			default:
				System.out.println("Invalid value | Please enter bettween 1 - 3");
				break;
			}

		}

	}
	
	//una funcion simple de mostrar la tabla
	private static void mostrarTabla(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	//main game = dolor de cabesa
	private static void mainGame(Player p1) {

		boolean playing = true;
		
		
		/*antes de iniciar para verificamos que el jugador a configurado el nombre o tamaño, 
		 * en el caso que no lo haya configurado salta un mensaje para que lo configure.*/
		sc.nextLine();
		if (p1.nom == null) {
			System.out.println("Player name is null, please enter a name: ");
			playerName(p1);
		}
		if (p1.size == 0) {
			boarSize(p1);
		}
		
		
		//creamos la matriz y la llenamos con la funcion fillboard que la llena aleatoriamente de 1 y 0
		int[][] board = new int[p1.size][p1.size];
		fillBoard(board);
		
		//mientras playing sea true, el juego seguira.
		while (playing) {

			mostrarTabla(board);
			System.out.println("Please select row and column. Ex:(1 2)");
			int fInput = sc.nextInt();
			int cInput = sc.nextInt();
			changeLights(board, fInput, cInput);
			//verifica que todo sea 0. En caso que todo sea 0, cambia "playing" a "false" 
			playing = verify(board);
			//suma cada vez que pasa un "turno"
			p1.movements++;
			//Para no estar media hora intentando resolver el puzzle, 67 = acabar el juego.
			if (fInput == 67 && cInput == 67) {
				playing = false;
			}
		}
		//GAME OVER
		System.out.println("GAME OVER " + p1.nom);
		System.out.println("YOUR STATS: " + p1.movements);
	}
	
	//Verifica si todo es 0
	private static boolean verify(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j]!=0) {
					return true;
				}
			}
		}
		return false;
	}

	// "iluminar, desiluminar"
	/*Basicamente, en el caso de arriba, verifica si esta fuera, despues mira si la posicion de arriba es 0 o 1 y dependiendo de cual es lo cambia */
	private static void changeLights(int[][] board, int f, int c) {
		
		// arriba
		if (!esticFora(board, f - 1, c)) {
			if (board[f - 1][c] == 0) {
				board[f - 1][c] = 1;
			} else {
				board[f - 1][c] = 0;
			}
		}
		// abajo
		if (!esticFora(board, f + 1, c)) {
			if (board[f + 1][c] == 0) {
				board[f + 1][c] = 1;
			} else {
				board[f + 1][c] = 0;
			}
		}
		// derecha
		if (!esticFora(board, f, c + 1)) {
			if (board[f][c + 1] == 0) {
				board[f][c + 1] = 1;
			} else {
				board[f][c + 1] = 0;
			}
		}
		// izquierda
		if (!esticFora(board, f, c - 1)) {
			if (board[f][c - 1] == 0) {
				board[f][c - 1] = 1;
			} else {
				board[f][c - 1] = 0;
			}
		}
		//centro
		if(!esticFora(board, f, c) && board[f][c] == 0) {
			board[f][c] = 1;
		} else if(!esticFora(board, f, c) && board[f][c] == 1) {
			board[f][c] = 0;
		} else {
			System.out.println("INVALID POSITION");
		}
	}
	//Estoy Fuera?
	private static boolean esticFora(int[][] mat2, int f, int c) {

		if (f < 0 || c < 0 || f > mat2.length - 1 || c > mat2[0].length - 1) {
			return true;
		} else {

			return false;
		}
	}
	
	//llena la tabla aleatoriamente de 1 y 0
	private static void fillBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = (int) (Math.random() * 2);
			}
		}
	}
	
	//Ajustes
	private static void settingsMenu(Player p1) {

		System.out.println("1. Change name");
		System.out.println("2. Board size");
		System.out.println("3. Go back");

		int inputSettings = sc.nextInt();

		switch (inputSettings) {
		// caso 1, ejecuta la funcion playerName y al acabar muestra el menu
		case 1:
			System.out.println("Enter name: ");
			playerName(p1);
			menu();
			break;
		// caso 2, ejecuta la funcion boardSize y al acabar muestra el menu
		case 2:
			boarSize(p1);
			menu();
			break;
		case 3:
			menu();
			break;
		default:
			break;
		}
	}
	
	//tamaño de la tabla, cambia "size" de player.
	private static void boarSize(Player p1) {
		System.out.println("Please enter a size: ");
		int size = sc.nextInt();
		System.out.println("Board size: " + size + "X" + size);
		
		p1.size = size;
	}
	
	//Cambia el nombre
	private static void playerName(Player p1) {
		String name = sc.nextLine();
		p1.nom = name;
	}
	
	//Muestra el menu
	private static void menu() {

		System.out.println("1. Play");
		System.out.println("2. Settings");
		System.out.println("3. Exit");

	}

}
