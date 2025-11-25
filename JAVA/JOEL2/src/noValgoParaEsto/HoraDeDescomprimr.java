package noValgoParaEsto;

import java.util.Scanner;

public class HoraDeDescomprimr {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		sc.nextLine();
		
		for(int i = 0; i < casos; i++) {
			
			String mensajeEncry = sc.nextLine();
			String[] arrayMensaje = mensajeEncry.split(" ");
			
			int numero = Integer.parseInt(arrayMensaje[0]);
			String simbolo = arrayMensaje[1];
			
			for(int h = 0; h < numero; h++) {
				
				System.out.print(simbolo);
				
			}
			
		}

	}

}
