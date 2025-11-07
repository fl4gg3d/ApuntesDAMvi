package Ejercicios;

import java.util.Scanner;

public class ElMeuSegonBucle {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		int num = 0;
		
		for(int i = 0; i < casos; i++){
			int casos2 = sc.nextInt();
			for(int j = 0; j < casos2; j++) {
				num = sc.nextInt();
				
				num = num += 1;
				System.out.println(num);
			}
			
		}	
		

	}

}
