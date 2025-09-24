	package DIA4;
	
	import java.util.Scanner;
	
	public class JOEL2 {
	
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int resultado = 0;
			
			int a = sc.nextInt();
			
			int b = sc.nextInt();
			
			int c = sc.nextInt();
			
			int grande = 0;
			
			if (a > b && a > c) {
				grande = a;
			}
			else if (b > a && b > c) {
				grande = b;
			}
			else if (c > a && c > b) {
				grande = c;
			}
				
			int pequetin = 0;
			
			if (a < b && a <c) {
				pequetin = a;
			}
			else if (b < a && b < c) {
				pequetin = b;
			}
			else if (c < a && c < b) {
				pequetin = c;
			}
			
			
			
			System.out.println(resultado);
		}
	
	}
