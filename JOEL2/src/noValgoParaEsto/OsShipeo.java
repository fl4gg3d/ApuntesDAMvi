package noValgoParaEsto;

import java.util.Scanner;

public class OsShipeo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int casos = sc.nextInt();

		for (int i = 0; i < casos; i++) {

			int numArray = sc.nextInt();

			int[] arrayInt = new int[numArray];

			for (int h = 0; h < arrayInt.length; h++) {

				arrayInt[h] = sc.nextInt();

			}

			int min = arrayInt[0];

			int max = arrayInt[0];

			for (int j = 0; j < arrayInt.length; j++) {

				if (arrayInt[j] < min) {

					min = arrayInt[j];

				}

				if (arrayInt[j] > max) {

					max = arrayInt[j];
				}
			}
			System.out.println(max - min);
		}

	}
}
