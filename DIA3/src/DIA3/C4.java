package DIA3;

import java.util.Scanner;

public class C4 {

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int alumnes = sc.nextInt();
				
		sc.nextLine();
		
		int temperatura = sc.nextInt();
		
		sc.nextLine();
		
		String mandito = sc.nextLine();
		
		if (temperatura > 25 && mandito == "SI") {
			System.out.println("Aire");
		}
		else if (alumnes > 15 && temperatura > 22 && temperatura <=25 && mandito == "SI") {
			System.out.println("Aire");
		}
		else if (alumnes > 15 && temperatura > 22 && temperatura <=25 && mandito == "NO") {
			System.out.println("Obrir Finestra");
		}
		else if (alumnes >15 && temperatura > 18 && mandito == "SI" || mandito == "NO") {
			System.out.println("Obrir Finestra");
		}
		else {
			System.out.println("Res");
		}
	}

}
