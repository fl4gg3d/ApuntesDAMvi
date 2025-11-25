package noValgoParaEsto;

import java.util.Scanner;

public class MacarrismeAl100PerCent {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int arrayNum = sc.nextInt();

		double[] arrayDouble = new double[arrayNum];

		for (int i = 0; i < arrayDouble.length; i++) {

			arrayDouble[i] = sc.nextDouble();
		
		}
		for (int j = 0; j < arrayDouble.length; j++) {
			System.out.println(arrayDouble[j] * 100 + "% ");
		}
	}
	
}

