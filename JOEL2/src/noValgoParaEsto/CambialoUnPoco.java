package noValgoParaEsto;

import java.util.Scanner;

public class CambialoUnPoco {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			int arrayNum = sc.nextInt();

			int[] arrayInt = new int[arrayNum];

			for (int j = 0; j < arrayInt.length; j++) {

				arrayInt[j] = sc.nextInt();
			}

			int numRenplanzado = sc.nextInt();
			int numNuevo = sc.nextInt();

			for (int h = 0; h < arrayInt.length; h++) {

				if (arrayInt[h] == numRenplanzado) {
					arrayInt[h] = numNuevo;
				}

			}
			
			for(int k = 0; k < arrayInt.length; k++) {
				
				System.out.print(arrayInt[k] + " ");
				
			}

		}

	}

}
