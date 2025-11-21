package noValgoParaEsto;

import java.util.Scanner;

public class BasketMania {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			int V = 0;
			
			int L = 0;
			
			int tiros = sc.nextInt();
			
			sc.nextLine();
			
			for (int j = 0; j < tiros; j++) {
				
				String canasta = sc.nextLine();
				
				String[] puntosSplit = canasta.split(" ");
				
				int puntsInt = Integer.parseInt(puntosSplit[1]);
				
				if(puntosSplit[0].equals("V")) {
					V += puntsInt;
				} else if(puntosSplit[0].equals("L")) {
					L += puntsInt;
				}
				
			}
			if(V > L) {
				System.out.println("V" +" "+ L +" "+ V);
			}
			else if (V < L) {
				System.out.println("L" +" "+ L +" "+ V);
			} else {
				System.out.println("E" +" "+ L +" "+ V);
			}
			
		} 
		
		
		
	}

}
