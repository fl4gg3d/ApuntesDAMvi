package ExamenProva;

import java.util.Scanner;

public class SalsaOMerequetengue {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		String frase = sc.nextLine();
		
		String[] fraseSplit = frase.split(" ");
		
		for (int i = 0; i < fraseSplit.length; i++) {
			
			
		}
		
		if(frase.contains("Mereketengue")) {
			System.out.println(frase);
			System.out.println("Mereketengue");
		}
		else if(frase.contains("Salsa")) {
			System.out.println(frase);
			System.out.println("Salsa");
		}
		else if(frase.contains("Mereketengue") && frase.contai("Salsa")) {
			System.out.println(frase);
			System.out.println("Mereketengue i Salsa");
		} else {
			System.out.println(frase);
			System.out.println("Cap");
		}
		
	}
//lo siento dani, no se pensar. Tengo que practicar mas.
}
