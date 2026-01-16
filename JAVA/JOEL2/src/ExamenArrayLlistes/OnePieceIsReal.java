package ExamenArrayLlistes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class OnePieceIsReal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String frase = sc.nextLine();
		boolean islatrobada = false;
		String[] islas = frase.split(" ");
		
		
		for (int i = 0; i < islas.length; i++) {
			System.out.println(islas[i]);
		}
		
		String islaRumbo = sc.nextLine(); 
		
	}

}
