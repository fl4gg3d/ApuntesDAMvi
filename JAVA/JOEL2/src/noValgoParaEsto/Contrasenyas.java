package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Contrasenyas {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		
		int entrada = sc.nextInt();
		sc.nextLine();
		
		//Registro contraseñas y usuarios
		ArrayList<String> users = new ArrayList<>();
		Collections.sort(users);
		for (int i = 0; i < entrada; i++) {
			users.add(sc.next());
		}
		ArrayList<String> contras = new ArrayList<>();
		for (int h = 0; h < entrada; h++) {
			contras.add(sc.next());
		}
		
		boolean noUsuario = false;
		boolean contrasenyaIncorrecta = false;
		boolean Ok = false;
		String usuari = null;
		String contra = null;
		
		int casos = sc.nextInt();
		for (int i = 0; i < casos; i++) {
			usuari = sc.next();
			contra = sc.next();	
			for (int d = 0; d < users.size(); d++) {
				for (int j = 0; j < contras.size(); j++) {
					if(!users.contains(usuari)) {
						noUsuario = true;
					}
					else if(!contra.contains(contra)) {
						contrasenyaIncorrecta = true;
					}
					else if(users.indexOf(d) == contra.indexOf(j)) {
						Ok = true;
					}
					
				}
				
			}
		}
		//inicio sesion
		
		
		if(Ok) {
			System.out.println("OK");
		}
		else if(contrasenyaIncorrecta) {
			System.out.println("contraseña incorrecta");
		}
		else if(noUsuario) {
			System.out.println("usuari no trobat");
		}
		for (String string : users) {
			System.out.print(string + " ") ;
		}
	}
}
