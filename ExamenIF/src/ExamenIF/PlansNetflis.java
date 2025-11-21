package ExamenIF;

import java.util.Random;

public class PlansNetflis {

	public static void main(String[] args) {

		Random gamble = new Random();

		int gambleNum = gamble.nextInt(0, 20);

		System.out.println(gambleNum);
		if (gambleNum > 0) {
			if (gambleNum >= 1) {
				if (gambleNum >= 6) {
					if (gambleNum >= 9) {
						if (gambleNum > 14) {
						}
					}
					else {
						System.out.println("ESTANDARD");
					}
				}
				else {
					System.out.println("BASIC");
				}
			} else {
				System.out.println("ESTANDARD AMB ANUNCIS");
			}

		}
		else {
			System.out.println("NOTHING");
		}
	}
}
