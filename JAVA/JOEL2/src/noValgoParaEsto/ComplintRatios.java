package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Scanner;

public class ComplintRatios {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			ArrayList<String> listaStr = new ArrayList<String>();
			int llargLista = sc.nextInt();
			for (int j = 0; j < llargLista; j++) {
				listaStr.add(sc.next());
			}
			int position = sc.nextInt();
			
			listaStr.remove(position);
			
			for(String nombre : listaStr) {
				System.out.print(nombre + " ");
			}
			
		}
		

	}

}
