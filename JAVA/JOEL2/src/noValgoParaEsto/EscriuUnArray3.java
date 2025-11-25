package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Scanner;

public class EscriuUnArray3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> listaInt = new ArrayList<Integer>();
		boolean minus1 = false;
		
		while(!minus1) {
			
			int nums = sc.nextInt();
			
			if(nums != -1) {
				listaInt.add(nums);
			} else {
				minus1 = true;
			}
			
		}
		int posicion = sc.nextInt();
		
		System.out.println(listaInt);
		System.out.println(listaInt.get(posicion));
	}

}
