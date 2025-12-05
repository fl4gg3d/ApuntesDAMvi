package examenprovaLlistaArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class IntercanviMaximMinims {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Random random = new Random();
		
		ArrayList<Integer> lista1 = new ArrayList<Integer>();
		ArrayList<Integer> lista2 = new ArrayList<Integer>();
		ArrayList<Integer> listaComuns = new ArrayList<Integer>();
		boolean flag = false;
		
		for (int i = 0; i < 10; i++) {
			lista1.add(random.nextInt(0, 21));
			lista2.add(random.nextInt(0, 21));
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(lista1.get(i) == lista2.get(j)) {
					listaComuns.add(lista1.get(i));
				}
			}
		}
		System.out.println(lista1);
		System.out.println(lista2);
		System.out.println("Lista comuns"+" "+listaComuns);
		int posMin = listaComuns.indexOf(Collections.min(listaComuns));
		int posMax = listaComuns.indexOf(Collections.max(listaComuns));
		Collections.swap(listaComuns, posMin, posMax);
		System.out.println("Lista Comuns Intercambiada"+" "+listaComuns);
	}

}
