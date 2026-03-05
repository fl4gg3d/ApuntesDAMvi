package recursividad;

import java.util.Scanner;

public class Ambrosio {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			
			int pisos = sc.nextInt();
			
			System.out.println(piramide(pisos));
		}	
	}

	private static int piramide(int pisos) {
		if(pisos == 1) {
			return 1;
		}
		else {
			return piramide(pisos-1) + pisos*pisos;
		}
	}
}
