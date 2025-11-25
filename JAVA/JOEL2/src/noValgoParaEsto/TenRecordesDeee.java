package noValgoParaEsto;

import java.util.Scanner;

public class TenRecordesDeee {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i ++) {
			
			int numArray = sc.nextInt();
				
			int[] arrayInt = new int[numArray];
			
			for(int j = 0; j < arrayInt.length; j++) {
				
				arrayInt[j] = sc.nextInt();
			}
			
			int posicion = sc.nextInt();
			
			System.out.println(arrayInt[posicion]);
		
			
		}
		
	}

}
