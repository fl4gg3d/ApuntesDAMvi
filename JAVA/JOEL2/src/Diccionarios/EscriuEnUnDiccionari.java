package Diccionarios;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class EscriuEnUnDiccionari {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		sc.nextLine();
		
		LinkedHashMap<String, String> diccionari = new LinkedHashMap<>();
		
		for (int i = 0; i < casos; i++) {
			
			diccionari.put(sc.nextLine(), sc.nextLine());
			
		}
		String nomBuscar = sc.nextLine();
		
		System.out.println(diccionari);
		System.out.println(diccionari.get(nomBuscar));
		
	}

}
