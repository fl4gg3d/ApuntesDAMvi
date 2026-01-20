package Diccionarios;

import java.util.Scanner;
import java.util.TreeMap;

public class CercaPerValorEnDiccionari {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			TreeMap<String, String> dicc = new TreeMap<String, String>();

			int numPaisos = sc.nextInt();

			sc.nextLine();

			for (int j = 0; j < numPaisos - 1; j++) {
				String[] paisos = sc.nextLine().split("-");
				dicc.put(paisos[0], paisos[1]);
			}
			String pais = "";
			String capitalSeleccionado = sc.nextLine();
			for (String v : dicc.keySet()) {
				if(dicc.get(v).equals(capitalSeleccionado)) {
					pais = v;
				}
			}
			System.out.println(dicc);
			System.out.println(pais);
		}
	}
}
