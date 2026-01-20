package Diccionarios;

import java.util.HashMap;
import java.util.Scanner;

public class DesiertoDelSinaí {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			HashMap<String, Integer> mapas = new HashMap<String, Integer>();
			
			int numMapas = sc.nextInt();
			
			sc.nextLine();
			
			for (int j = 0; j < numMapas; j++) {
				String nameMapa = sc.nextLine();
				
				if (mapas.containsKey(nameMapa)) {
					mapas.put(nameMapa, mapas.get(nameMapa) + 1);
				} else {
					mapas.put(nameMapa, 1);
				}
			}
			
			String ganador = "";
			
			int maxVotos = 0;
			
			for (String mapaGanador : mapas.keySet()) {
				if (mapas.get(mapaGanador) > maxVotos) {
					maxVotos = mapas.get(mapaGanador);
					ganador = mapaGanador;
				}
			}
			
			System.out.println(ganador);
			
		}
		
	}

}
