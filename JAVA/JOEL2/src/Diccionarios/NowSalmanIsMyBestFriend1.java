package Diccionarios;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class NowSalmanIsMyBestFriend1 {

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
			String buscar = sc.nextLine();
			System.out.println(dicc.get(buscar));
		}
		
	}

}
