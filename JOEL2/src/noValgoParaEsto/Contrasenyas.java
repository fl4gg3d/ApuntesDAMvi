package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Contrasenyas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int entrada = sc.nextInt();
		sc.nextLine();
		
		//tecnicamene inicializa la lista y va haciendo un Add
		ArrayList<String> users = new ArrayList<>();
		for (int i = 0; i < entrada; i++) {
			users.add(sc.next());
		}
		ArrayList<String> contras = new ArrayList<>();
		for (int h = 0; h < entrada; h++) {
			contras.add(sc.next());
		}
		
		int casos = sc.nextInt();
		for (int i = 0; i < casos; i++) {
			String usuari = sc.next();
			String contra = sc.next();
			
			//if(users.indexOf(usuari)>=0) {
				//if(users.indexOf(contra))
			//}
		}
	}
}
