package noValgoParaEsto;

import java.util.Scanner;

public class ParchisParchis {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			int posicionIni = sc.nextInt();
			int posicionAct = posicionIni;
			int[] arrayInt = new int[3];
			
			for(int a = 0; a < arrayInt.length; a++) {
				arrayInt[a] = sc.nextInt();
			}
			for(int r = 0; r < arrayInt.length; r++) {
				
				if(posicionAct != 8) {
					posicionAct = posicionAct + arrayInt[r];
					if(posicionAct > 8) {
						int restante = posicionAct - 8;
						posicionAct = 8 - restante;
					}
				}
				
			}
			System.out.println(posicionAct);
		}
	}
}
