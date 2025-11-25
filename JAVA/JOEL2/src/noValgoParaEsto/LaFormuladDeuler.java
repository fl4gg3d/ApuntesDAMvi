package noValgoParaEsto;

import java.util.Scanner;

public class LaFormuladDeuler {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			int tamanyArray = sc.nextInt();

			int[] arrayInt = new int[tamanyArray];

			for (int h = 0; h < arrayInt.length; h++) {

				arrayInt[h] = sc.nextInt();

			}
			int change = 1;
			while (change != 0) {
				change = 0;
				for(int j = 0; j < arrayInt.length; j++) {
					if (j != 0) {
						if (arrayInt[j] < arrayInt[j - 1] && arrayInt[j]!=0) {
							int tmp = arrayInt[j -1];
							arrayInt[j -1] = arrayInt[j];
							arrayInt[j] = tmp;
							change++;
						}
					}
				}
			}
			
			for(int k = 0; k < arrayInt.length / 2; k++) {
				
				int suma = arrayInt[k] + arrayInt[tamanyArray - 1 - k];
				System.out.print(suma);
                if (k < arrayInt.length / 2 - 1) System.out.print(" ");
			}
			
			System.out.println();
			
		}
	}
}