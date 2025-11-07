package ExamenBucles;

import java.util.Scanner;

public class SuperTieBreak {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		
		int Djokovic = 6;
		int Alcaraz = 7;
		
		boolean condition = false; 
		
		while(condition == false){
			
			String punto = sc.nextLine();
			
			if(punto.equals("ALCARAZ")) {
				Alcaraz++;
			}
			else if (punto.equals("DJOKOVIC")) {
				Djokovic++;
			}
			
			if(Alcaraz >= 10 && Alcaraz - Djokovic >=2 || 
					Djokovic >= 10 && Djokovic - Alcaraz >=2) {
				condition = true;
			}
			
		}
		if(Djokovic > Alcaraz) {
			System.out.println("GUAYA DJOKOVIC");
		}
		else if (Djokovic < Alcaraz){
			System.out.println("GUAYA ALCARAZ");
		}
		System.out.println(Alcaraz);
		System.out.println(Djokovic);
	}

}
