package noValgoParaEsto;

import java.util.Scanner;

public class Raid {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int iniciRaid = 22 * 60 + 30;
		int finalRaid = 24 * 60 + 30;

		int casos = sc.nextInt();

		sc.nextLine();

		for (int i = 0; i < casos; i++) {

			String hora = sc.nextLine();
			String[] arraySplit = hora.split(":");

			int horaminuto = Integer.parseInt(arraySplit[0]);
			int minutos = Integer.parseInt(arraySplit[1]);
			int minutosTotal = horaminuto * 60 + minutos;

			if (minutosTotal >= iniciRaid || minutosTotal <= 30) {
				System.out.println("RAID");
			} else {
				System.out.println(iniciRaid - minutosTotal);
			}

		}

	}

}
