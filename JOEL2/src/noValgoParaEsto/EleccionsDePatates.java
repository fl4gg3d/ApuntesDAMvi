package noValgoParaEsto;

import java.util.Scanner;

public class EleccionsDePatates {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			int opcionesVotos = sc.nextInt();

			int[] arrayInt = new int[opcionesVotos];

			for (int h = 0; h < arrayInt.length; h++) {

				arrayInt[h] = sc.nextInt();

			}

			int max = arrayInt[0];

			for (int j = 0; j < arrayInt.length; j++) {

				if (arrayInt[j] > max) {
					max = arrayInt[j];
				}

			}

			for (int k = 0; k < arrayInt.length; k++) {

				if (arrayInt[k] == max) {
					System.out.println(k + 1);
				}

			}

		}

	}

}
