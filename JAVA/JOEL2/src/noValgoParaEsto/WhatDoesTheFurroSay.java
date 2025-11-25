package noValgoParaEsto;

import java.util.Scanner;

public class WhatDoesTheFurroSay {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		sc.nextLine();
		
		for (int i = 0; i < casos; i++) {
			
			boolean hayFurros = false; 
			
			String frase = sc.nextLine();
			String[] fraseSplit = frase.split(" ");
			String[] furryWords = new String[fraseSplit.length];
			for (int j = 0; j < fraseSplit.length; j++) {
				
				if(fraseSplit[j].equals("grrr")||fraseSplit.equals("woof")||fraseSplit.equals("meow")) {
					furryWords[j] = fraseSplit[j];
					hayFurros = true;
				}
				
			}
			
			if(frase.contains("Hector")) {
				System.out.println("Gato pasando por el campo de batalla");
			}
			else if(hayFurros == true) {
				System.out.print("[");
				for (int h = 0; h < furryWords.length; h++) {
					System.out.print(furryWords[h] + ", ");
				}
				System.out.print("]");
			} else {
				System.out.println("No hay Furros cerca");
			}
		}

	}

}
