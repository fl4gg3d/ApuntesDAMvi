package noValgoParaEsto;

import java.lang.reflect.Array;
import java.util.Scanner;

public class EscriuEnUnArray4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numArray = sc.nextInt();
		
		int[] ArrayInt = new int[numArray];
		
		for(int i = 0; i < ArrayInt.length; i++) {
			
			ArrayInt[i] = sc.nextInt();
			
		}
		
		int suma = sc.nextInt();
		
		for(int j = 0; j < ArrayInt.length; j++) {
			
			ArrayInt[j] = ArrayInt[j] + suma;
			
		}
		
		for(int h = 0; h < ArrayInt.length; h++) {
			
			System.out.print(ArrayInt[h] + " ");
			
		}
		
		
		

	}

}
