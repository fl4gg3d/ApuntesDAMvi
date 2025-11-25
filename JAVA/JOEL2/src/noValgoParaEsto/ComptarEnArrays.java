package noValgoParaEsto;

import java.util.Scanner;

public class ComptarEnArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			
			int numArrays = sc.nextInt();
			
			int[] arrayInt = new int[numArrays];
			
			for(int h = 0; h < arrayInt.length; h++) {
				
				arrayInt[h] = sc.nextInt();
				
			}
			
			int repeNum = sc.nextInt();
			
			int comptador = 0;
			
			for(int k = 0; k < arrayInt.length; k++) {
				
				if(arrayInt[k] == repeNum) {
					comptador++;
				}
			}
			
			System.out.println(comptador);
			
			
			
		}
		
	}

}
