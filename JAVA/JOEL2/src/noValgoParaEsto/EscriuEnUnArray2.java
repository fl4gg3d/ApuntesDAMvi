package noValgoParaEsto;

import java.util.Scanner;

public class EscriuEnUnArray2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int numArray = sc.nextInt();
		
		sc.nextLine();
		
		String [] arrayStr = new String[numArray];
		
		for(int i = 0; i < arrayStr.length; i++) {
			
			arrayStr[i] = sc.nextLine();
		
		}
		int quinaArray = sc.nextInt();
		
		for(int j = 0; j < arrayStr.length; j++) {
			
			System.out.println(arrayStr[j]);
		}
		System.out.println(arrayStr[quinaArray]);
	}

}
