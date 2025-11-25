package ExamenBucles;

import java.util.Scanner;

public class XifratgeCesarLight {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String frase = "";
		boolean dentro = true;
		
		
		
		while(dentro == true) {
			
			System.out.println("1. Introduir una frase o paraula en MAJÚSCULES.");
			System.out.println("2. Modificar la frase introduïda tot afegint més paraules.");
			System.out.println("3. Eliminar la frase introduïda");
			System.out.println("4. Nombre de canvis en xifrar.");
			System.out.println("5. Sortir");
			
			int selec = sc.nextInt();
			
			sc.nextLine();
			
			if(selec == 1) {
				System.out.println("Opcion 1");
				frase = sc.nextLine();
				frase = frase.toUpperCase();
			}
			else if (selec == 2) {
				String concatenar = sc.nextLine();
				concatenar = concatenar.toUpperCase();
				frase = frase + concatenar;
			}
			else if (selec == 3) {
				frase = "";
			}
			else if (selec == 4) {
				
			}
			else if(selec == 5){
				dentro = false;
			}
			System.out.println(frase);
			
			
			
			
			
			
		}
		
		

	}

}
