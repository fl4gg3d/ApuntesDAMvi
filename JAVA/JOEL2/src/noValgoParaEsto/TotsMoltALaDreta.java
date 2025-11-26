package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TotsMoltALaDreta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			int llargLista = sc.nextInt();
			ArrayList<Integer> listaInteger = new ArrayList<Integer>();
			for (int j = 0; j < llargLista; j++) {
				listaInteger.add(sc.nextInt());
			}
			int posicion = sc.nextInt();
			Collections.rotate(listaInteger, posicion);
			for (Integer foreachInt : listaInteger) {
				System.out.print(foreachInt + " ");			}
		}
	}
}
