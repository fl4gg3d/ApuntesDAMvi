	package DIA4;
	
	import java.util.Scanner;
	
	public class JOEL2 {
	
		public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int resultado = 0;
			
			int A = sc.nextInt();
			
			int B = sc.nextInt();
			
			int C = sc.nextInt();
			
			if (A > B) {
				resultado = A - B;
			}
			else if(A > C) {
				resultado = A - C;
			}
			else if(B > A) {
				resultado = B - A;
			}
			else if(B > C) {
				resultado = B - C;
			}
			else if(C > A) {
				resultado = C - A;
			}
			else if(C > B) {
				resultado = B - C;
			}
			System.out.println(resultado);
		}
	
	}
