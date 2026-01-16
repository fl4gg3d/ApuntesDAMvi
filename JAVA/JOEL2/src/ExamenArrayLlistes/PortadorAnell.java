package ExamenArrayLlistes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PortadorAnell {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int Candidatos = sc.nextInt();
		sc.nextLine();
		ArrayList<String> ListaCandidatos = new ArrayList<String>();
		ArrayList<String> ListaDescartados = new ArrayList<String>();
		for (int i = 0; i < Candidatos; i++) {
			String NombreCandidatos = sc.nextLine();
			ListaCandidatos.add(NombreCandidatos);
		}
		System.out.println(ListaCandidatos.size());
		
		for(int i = 0; i < ListaCandidatos.size()-1; i++) {
			int numeros = sc.nextInt();
			Collections.rotate(ListaCandidatos, numeros);
			ListaCandidatos.add(ListaCandidatos.get(Candidatos));
		}
		for (String string : ListaDescartados) {
			System.out.println(string);
		}
		
	}

}
