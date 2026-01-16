package ExamenArrayLlistes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BibliotecaArcana {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		ArrayList<String> animals = new ArrayList<String>();
		ArrayList<String> tipo = new ArrayList<String>();
		
		for(int i = 0; i < casos; i++) {
			String nombreAnimal = sc.next();
			String tipoAnimal = sc.nextLine();
		}
		
		int drac = Collections.frequency(tipo, "drac");
		int esperit = Collections.frequency(tipo, "esperit");;
		int fada = Collections.frequency(tipo, "fada");;
		int troll = Collections.frequency(tipo, "troll");;
		
		Collections.sort(tipo);
		Collections.sort(animals);
		
		System.out.println("Drac" + drac);
		System.out.println("Esperit" + esperit);
		System.out.println("Dada" + fada);
		System.out.println("Troll" + troll);
		
		for (String animalsName : animals) {
			System.out.println(animalsName + " ");
		}
		
	}
}
