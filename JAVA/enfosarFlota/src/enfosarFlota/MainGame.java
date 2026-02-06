package enfosarFlota;

import java.util.Scanner;

public class MainGame {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int[][] flotaFalsa = new int[10][10];
		int[][] flotaReal = new int[10][10];
		
		menu();	
		boolean intro = false;
		
		while(intro) {
			int inputUserMenu = sc.nextInt();
			
			switch (inputUserMenu) {
			case 1:
				mainGame();
				break;
			case 2:
				intro = false;
				break;
			default:
				break;
			}
		}
		
		
	
	}
	private static void mainGame() {
		
		
		
	}
	private static void menu() {
		
		System.out.println("1. Jugar");
		System.out.println("2. Exit");
		
	}

}
