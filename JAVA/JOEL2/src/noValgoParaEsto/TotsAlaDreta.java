package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class TotsAlaDreta {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int largoLista = sc.nextInt();
		ArrayList<Integer> listaInt = new ArrayList<Integer>();
		for (int i = 0; i < largoLista; i++) {
			listaInt.add(sc.nextInt());
		}
		Collections.rotate(listaInt, 1);
		for (Integer foreachInt : listaInt) {
			System.out.print(foreachInt + " ");
		}
		
	}

}
