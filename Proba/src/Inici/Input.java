package Inici;
//Esto es un input vaya locura, recuerda siempre importar el scanner bobo
import java.util.Scanner;

public class Input {
//Input Texto
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriu una frase: ");
		
		String frase = sc.nextLine();
		
		System.out.println(frase);
		
		sc.close();//Esto hace que el scanner cierre
		
	}

}
