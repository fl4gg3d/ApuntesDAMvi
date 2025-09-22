package DIA4;

import java.util.Scanner;

public class JOEL1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int day = sc.nextInt();
		
		if(day == 366) {
			System.out.println("Correcte per un any bixest!");
		}
		else if(day >= 1 && day <= 365) {
			System.out.println("Correcte per un any no bixest!");
		}
		else {
			System.out.println("Incorrecte!");
		}
		
		
	}

}

