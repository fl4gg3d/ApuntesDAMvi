package noValgoParaEsto;

import java.util.Scanner;

public class ooBloodbroneArraysVersion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for(int i = 0; i < casos; i++) {
			
			boolean verdad = false;
			
			int tamanyArray = sc.nextInt();
			
			int[] arrayInt = new int[tamanyArray];
			
			for(int h = 0; h < arrayInt.length; h++) {
				
				arrayInt[h] = sc.nextInt();
				
			}
			
			for(int k = 1; k < arrayInt.length; k++) {
				
				if(arrayInt[k - 1] == arrayInt[k]) {
					
					verdad = true;
					
				}
				
			}
			
			if(verdad == true) {
				System.out.println("SI");
			} else {
				System.out.println("NO");
			}
			
		}
		
		
		
	}

}
