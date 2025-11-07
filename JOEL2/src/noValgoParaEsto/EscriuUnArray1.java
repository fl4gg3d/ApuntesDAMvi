package noValgoParaEsto;

import java.util.Scanner;

public class EscriuUnArray1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int larguraArray = sc.nextInt();
		
		int [] arrayInt = new int[larguraArray];
		
		for(int i = 0; i < arrayInt.length; i++) {
			
			arrayInt[i] = sc.nextInt();
			
		}
		
		int ArrayWhere = sc.nextInt();
		
		for(int j = 0; j < arrayInt.length; j++) {
			System.out.print(arrayInt[j] + " ");
			
		}
		System.out.println();
		System.out.println(arrayInt[ArrayWhere]);
		
		
	}

}
