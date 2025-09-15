package Inici;

public class operacionLogiques {

	public static void main(String[] args) {
		
		int b = 5;
		int a = 10;
		
		boolean resultat;
		
		resultat = a < b; // A mayor que B lo mismo que menor
		System.out.println(resultat);

		resultat = a == b; // Igual que B
		System.out.println(resultat);
		
		resultat = a >= b;
		System.out.println(resultat);
		
		boolean t = true;
		boolean f = false;
		
		resultat = t || f; // Esto es un OR? Tengo que revisarlo mejor
		System.out.println(resultat);
		
		resultat = t && f; // Esto es un AND.
		System.out.println(resultat);
		
	}

}
