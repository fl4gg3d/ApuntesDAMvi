package ExamenIF;

import java.util.Scanner;

public class Butlletins {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		String resposta = sc.nextLine();
		
		switch(resposta) {
			
		case "INFORMATICA":
			System.out.println("GASETA INFORMATICA");
			break;
		case "DIRECCIO":
			System.out.println("BUTLLETI DIRECCIO");
			break;
		case "RECURSOS HUMANS":
			System.out.println("INFORME RECURSOS HUMANS");
			break;
		case "LOGISTICA":
			System.out.println("COMUNICAT LOGISTICA");
			break;
		case "SECRETARIA":
			System.out.println("INFORME SECRETARIA");
			break;
		case "I+D":
			System.out.println("SETMANAL I+D");
			break;
		default:
			System.out.println("Desconec el departament de" + resposta);
		}
		
	}

}
