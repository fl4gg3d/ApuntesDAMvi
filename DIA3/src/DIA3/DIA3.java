package DIA3;

import java.util.Scanner;
 
public class DIA3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		double torre1 = sc.nextDouble();
		
		sc.nextLine();
		
		double torre2 = sc.nextDouble();
		
		double entre;
		
		if(torre1 > torre2){
			entre = torre1 - torre2;
		}
		else {
			entre = torre2 - torre1;
		}
		if(entre <= 5){
			System.out.println("SI");
		}
		else {
			System.out.println("NO");
		}
	}

}
