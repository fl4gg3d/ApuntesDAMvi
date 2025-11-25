package Practicas;

import java.util.ArrayList;
import java.util.Scanner;

public class ExamenArrayProva {

	public class SalsaOMerequetengue {

	    public static void main(String[] args) {

	        Scanner sc = new Scanner(System.in); 

	        String frase = sc.nextLine();

	        String[] fraseSplit = frase.split(" ");

	        // ArrayList per guardar paraules sense repetir
	        ArrayList<String> paraulesUnices = new ArrayList<>();

	        // ELIMINAR DUPLICATS MANTENINT ORDRE
	        for (int i = 0; i < fraseSplit.length; i++) {

	            if (!paraulesUnices.contains(fraseSplit[i])) {
	                paraulesUnices.add(fraseSplit[i]);
	            }
	        }

	        // IMPRIMIR RESULTAT (COM ARRAY)
	        for (int i = 0; i < paraulesUnices.size(); i++) {
	            System.out.print(paraulesUnices.get(i) + " ");
	        }
	        System.out.println();

	        // COMPROVAR SI CONTÉ PARAULES CLAU
	        boolean teMereketengue = false;
	        boolean teSalsa = false;

	        for (int i = 0; i < paraulesUnices.size(); i++) {
	            if (paraulesUnices.get(i).equalsIgnoreCase("Mereketengue")) {
	                teMereketengue = true;
	            }
	            if (paraulesUnices.get(i).equalsIgnoreCase("Salsa")) {
	                teSalsa = true;
	            }
	        }

	        // RESULTAT FINAL
	        if (teMereketengue && teSalsa) {
	            System.out.println("Mereketengue i Salsa");
	        } 
	        else if (teMereketengue) {
	            System.out.println("Mereketengue");
	        } 
	        else if (teSalsa) {
	            System.out.println("Salsa");
	        } 
	        else {
	            System.out.println("Cap");
	        }
	    }
	}

}
