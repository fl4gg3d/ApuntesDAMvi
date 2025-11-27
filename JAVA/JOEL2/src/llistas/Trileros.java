package llistas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Trileros {

	public static void main(String[] args) {

		Scanner nigga = new Scanner(System.in);

		int cubos = nigga.nextInt();
		ArrayList<Integer> listaInt = new ArrayList<Integer>();
		boolean niggant = false;
		boolean cuboGana = false;
		for(int i = 0; i < cubos; i++) {
			listaInt.add(0);
		}
		listaInt.set(0, 1);
		while(!niggant) {
			int pos1 = nigga.nextInt();
			int pos2 = nigga.nextInt();
			
			if(pos1 != -1 && pos2 != 2) {
				Collections.swap(listaInt, pos1, pos2);
			} else {
				niggant = true;
			}
			
		}
		int posicion = listaInt.indexOf(1);
		System.out.println(listaInt);
		System.out.println(posicion);
		
	}
}
