package noValgoParaEsto;

import java.util.Scanner;

public class MultiplicahoToT {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			
			int arrayNum = sc.nextInt();
			
			int[] arrayInt = new int[arrayNum];
			
			for(int j = 0; j < arrayInt.length; j++) {
				
				arrayInt[j] = sc.nextInt();
				
			}
			
			int numMulti = sc.nextInt();
			
			for(int h = 0; h < arrayInt.length; h++) {
				
				System.out.print(arrayInt[h] * numMulti + " ");
				
			}
		}
		

	}

}
