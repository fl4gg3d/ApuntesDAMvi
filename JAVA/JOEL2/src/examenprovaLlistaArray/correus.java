package examenprovaLlistaArray;

import java.util.ArrayList;
import java.util.Scanner;

public class correus {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> llistaName = new ArrayList<String>();
		ArrayList<String> llistaLastName = new ArrayList<String>();
		ArrayList<String> llistaBirthdate = new ArrayList<String>();
		ArrayList<String> correus = new ArrayList<String>();
		int llargLista = sc.nextInt();
		
		for (int i = 0; i < llargLista; i++) {
			llistaName.add(sc.next().toLowerCase());
		}
		for (int i = 0; i < llargLista; i++) {
			llistaLastName.add(sc.next().toLowerCase());
		}
		for (int i = 0; i < llargLista; i++) {
			llistaBirthdate.add(sc.next());
		}
		
		for(int i = 0; i < llargLista; i++) {
			
			String inicial = llistaName.get(i).substring(0,1);
			String apellido = llistaLastName.get(i);
			System.out.println(inicial + apellido + "@ies-sabadell.cat");
			
			
			
			
		}
		
		System.out.println(llistaName);
		System.out.println(llistaLastName);
		System.out.println(llistaBirthdate);
	}
}
