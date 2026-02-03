package memoPC;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class game {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			
		//GUARDAR JUGADORES
			players[] playersArray = playersFunction();
			players player1 = playersArray[0];
			players player2 = playersArray[1];
			
		//TABLA
			String[][] fakeboard = new String[4][4];
			String[][] realboard = new String[4][4];
			
			boolean devMenu = false;
			boolean sortir = false;
			
			menu();
			
			while (!sortir) {
				
				int userResponse = sc.nextInt();
				sc.nextLine();
				
				switch (userResponse) {
				case 1:
					int torn = 0;
					memory(player1, player2, torn, fakeboard, realboard);
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
				case 67:
					devMenu = true;
					devMode(devMenu, fakeboard, realboard);
					break;
				default:
					System.out.println(" Wrong Value | Please select a number bettwen 1 - 4");
				}
			}
		}
		//JUEGO PRINCIPAL
		private static void memory(players player1, players player2, int torn, String[][] fakeboard, String[][] realboard) {
			
			rellenarFakeBoard(fakeboard);
			rellenarRealBoard(realboard);
			boolean gameReady = true;
			
			if (player1.nom == null && player2.nom == null) {
				System.out.println("No s'ha assignat nom als jugadors!: (Ex: Pepe)");
				player1.nom = sc.nextLine();
				player2.nom = sc.nextLine();
			}
			while(gameReady) {
				if(torn == 0) {
					System.out.println("Turno de " + player1.nom);
				} else {
					System.out.println("Turno de " + player2.nom);
				}
				MostrarTabla(fakeboard);
				MostrarTabla(realboard);
				int[] pos = keyPlay();
				
				int f1 = pos[0];
				int c1 = pos[1];
				int f2 = pos[2];
				int c2 = pos[3];
				
				fakeboard[f1][c1] = realboard[f1][c1];
				fakeboard[f2][c2] = realboard[f2][c2];
				
				if (realboard[f1][c1].equals(realboard[f2][c2])) {
					System.out.println("Pareja correcta");
					
					if (torn == 0) {
						player1.puntos++;
					} else {
						player2.puntos++;
					}
					
				} else {
					
					System.out.println("No es pareja");
					
					fakeboard[f1][c1] = "X";
					fakeboard[f2][c2] = "X";
					
					if (torn == 0) {
						torn = 1;
					} else {
						torn = 0;
					}
				}
				for (int i = 0; i < fakeboard.length; i++) {
					for (int j = 0; j < fakeboard.length; j++) {
						if (fakeboard[i][j].equals("X")) {
							
						} else {
							gameReady = false;
							System.out.println("Fin de la partida");
							
							if (player1.puntos > player2.puntos) {
								player1.numVictories++;
								System.out.println("Guanya el jugador " + player1.nom + " amb " + player1.puntos + " obtinguts");
							} else if(player1.puntos < player2.puntos){
								System.out.println("Guanya el jugador " + player2.nom + " amb " + player2.puntos + " obtinguts");
								player2.numVictories++;
							} else {
								System.out.println("Empate");
							}
						}
					}
				}
				player1.puntos = 0;
				player2.puntos = 0;
			}
		}
		//DEV MENU
		private static void devMode(boolean devMenu, String[][] fakeboard, String[][] realboard) {
			
			while(devMenu) {
				System.out.println("Selecciona una opcio: ");
				System.out.println("1. Probar sistema keyPlay");
				System.out.println("2. Mostrar tablas");
				System.out.println("3. Salir");
				
				int adminResponse = sc.nextInt();
				
				switch (adminResponse) {
				case 1:
					keyPlay();
					break;
				case 2:
					rellenarFakeBoard(fakeboard);
					MostrarTabla(fakeboard);
					rellenarRealBoard(realboard);
					MostrarTabla(realboard);
					break;
				case 3:
					devMenu = false;
					menu();
					break;
				default:
					System.out.println("Selecione un numero del 1 - 3");
					break;
				}
			}
		}
		//MOSTRAR TABLERO
		private static void MostrarTabla(String[][] board) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}
		}
		//SELECCIONAR CARTAS
		private static int[] keyPlay() {
			int[] position = new int[4];
			System.out.println("Selecciona las cartas: (Ex: 1 2)");
			for (int i = 0; i < position.length; i++) {
				position[i] = sc.nextInt();
			}
			return position;
		}
		//RELLENAR TABLA FAKE
		private static void rellenarFakeBoard(String[][] fakeboard) {
			for (int i = 0; i < fakeboard.length; i++) {
				for (int j = 0; j < fakeboard[0].length; j++) {
					fakeboard[i][j] = "X";
				}
			}
		}
		//RELLENAR TABLA REAL
		private static void rellenarRealBoard(String[][] realboard) {
			ArrayList<String> arrayList = new ArrayList<String>();
			for (int i = 1; i <= 8; i++) {
				arrayList.add(String.valueOf(i));
				arrayList.add(String.valueOf(i));
			}
			Collections.shuffle(arrayList);
			int index = 0;
			for (int i = 0; i < realboard.length; i++) {
				for (int j = 0; j < realboard[0].length; j++) {
					realboard[i][j] = arrayList.get(index);
					index++;
				}
			}
		}
		//CONTADOR VICTORIAS
		private static void victoriesCount(players player1,players player2) {
			System.out.println("El nombre de victories de " + player1.nom + " es igual a " + player1.numVictories);
			System.out.println("El nombre de victories de " + player2.nom + " es igual a " + player2.numVictories);
		}
		//AJUSTES
		private static void setting(players player1,players player2) {
			
			System.out.println("1. Change name");
			System.out.println("2. Exit");
			
			int userSetting = sc.nextInt();
			
			sc.nextLine();
			
			if(userSetting == 1) {
				player1.nom = sc.nextLine();
				player2.nom = sc.nextLine();
				menu();
			}
			else {
				menu();
			}
			
		}
		//MENU DISPLAY
		private static void menu() {
			System.out.println("1. Play");
			System.out.println("2. Settings");
			System.out.println("3. Victories");
			System.out.println("4. Exit");
//			System.out.println("67. DevMode");
		}
		//PLAYER CREATION 
		private static players[] playersFunction() {
			players jug1 = new players();
			players jug2 = new players();
			players[] playeadores = new players[2];
			playeadores[0] = jug1;
			playeadores[1] = jug2;
			return playeadores;
		}


}

