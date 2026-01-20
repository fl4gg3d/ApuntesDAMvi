package Diccionarios;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Capitals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			LinkedHashMap<String, String> dicc = new LinkedHashMap<String, String>();
			
			int numPaisos = sc.nextInt();
			
			sc.nextLine();
			
			for (int j = 0; j < numPaisos - 1; j++) {
				String[]paisos = sc.nextLine().split("-");
				dicc.put(paisos[0], paisos[1]);
			}
			
			String paisSeleccionado = sc.nextLine();
			System.out.println(dicc.getOrDefault(paisSeleccionado, "NO HO SE"));
		}

	}

}
