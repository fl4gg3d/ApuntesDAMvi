package ExamenIF;

import java.util.Random;

public class PlansNetflis {

	public static void main(String[] args) {

		Random gamble = new Random();

		int gambleNum = gamble.nextInt(0, 20);

		System.out.println(gambleNum);
		if (gambleNum > 0) {
			if (gambleNum >= 1) {
				System.out.println("ESTANDARD AMB ANUNCIS");
				if (gambleNum >= 6) {
					System.out.println("BASIC");
					if (gambleNum >= 9) {
						System.out.println("ESTANDARD");
						if (gambleNum > 14) {
							System.out.println("PREMIUM");
						}
					}
					else if (gambleNum <= 14) {
						System.out.println("ESTANDARD");
					}
				}
				else if (gambleNum <= 8) {
					System.out.println("BASIC");
				}
			} else if (gambleNum <= 5) {
				System.out.println("ESTANDARD AMB ANUNCIS");
			}

		}
		else if (gambleNum == 0) {
			System.out.println("NOTHING");
		}
	}
}
