package Diccionarios;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class NowSalmanIsMyBestFriend2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			LinkedHashMap<String, String> dicc = new LinkedHashMap<String, String>();

			int numPersonas = sc.nextInt();

			sc.nextLine();

			for (int j = 0; j < numPersonas - 1; j++) {

				dicc.put(sc.next(), sc.nextLine());
			}
			String nom = "";
			String buscar = sc.nextLine();
			
			
		}

	}

}
