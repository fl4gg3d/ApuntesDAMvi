package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Scanner;

public class Unique {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();		
		for(int i = 0; i < casos; i++) {
			int llargLista = sc.nextInt();
			sc.nextLine();
			ArrayList<String> llistaStr = new ArrayList<String>();
			for (int j = 0; j < llargLista; j++) {
				
				String word = sc.nextLine();
				
				if (llistaStr.contains(word)) {
					
				}else {
					llistaStr.add(word);
				}
				
			}
			System.out.println(llistaStr);
			
		}
	}
}
