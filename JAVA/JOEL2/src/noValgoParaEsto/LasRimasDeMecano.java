package noValgoParaEsto;

import java.util.Scanner;

public class LasRimasDeMecano {

	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			
			String[] rima1 = sc.nextLine().split(" ");
			String[] rima2 = sc.nextLine().split(" ");
			
			if(rima1[rima1.length-1].equals(rima2[rima2.length-1])) {
				System.out.println("SI");
			}else {
				System.out.println("NO");
			}
			
		}
	}
}
