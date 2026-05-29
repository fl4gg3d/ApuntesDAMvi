package pilesCues;

import java.util.ArrayDeque;
import java.util.Stack;

public class Piles {

	public static void main(String[] args) {
		
		ArrayDeque<String> pila = new ArrayDeque<String>();
		
		//Les piles són LIFO (Last In First Out) l'últim en entrar és el primer en sortir
		//actua com un pot de Pringles o una pila de plats bruts que s'han de rentar
		
		pila.push("Biel");  //en un ArrayDeque push afegeix al principi de la pila, en la posició 0
		pila.push("Carles");
		pila.push("MAKSY");
		pila.push("CadyCrush☺");
		pila.push("Cocodril");
		pila.push("Poor Dani");
	
		System.out.println(pila + " l'últim apareix al principi"); //

		System.out.println(pila.pop()); //mostra i elimina l'element que ha entrat últim a la pila
		System.out.println(pila);
		
		System.out.println(pila.peek());  //peek mostra, però no elimina l'element que ha entrat últim a la pila
		System.out.println(pila);

		
		Stack<String> pila2 = new Stack<String>();
		
		//Stack és un pila i a diferència de l'ArrayDeque afegeix al final, també visualment.
		
		pila2.push("pareti");
		pila2.push("piketin");
		pila2.push("Ruby");
		pila2.push("Wolv");
		pila2.push("Little Birle");
		
		System.out.println(pila2); //
		System.out.println(pila2.pop()); // al fer el pop el comportament és igual, perquè mostra i eliminia l'últim element afegit 
		System.out.println(pila2); 
		
		String ultima = pila2.pop();
		System.out.println(ultima);
		System.out.println(pila2.search("pareti")); //search ens retorna la posició d'un element a la cua si existeix
		System.out.println(pila2.search("Little Birle"));
		System.out.println(pila2.search("No ta")); // torna -1 si no el troba
			
		Stack<String> pilaClon = (Stack<String>) pila2.clone(); // clonem i creem una pila igual i independent
		System.out.println(pilaClon);
		
		
		MeuaPilita<String> pila3 = new MeuaPilita<String>();
		
		pila3.push("Mar");
		pila3.push("Cel");
		pila3.push("Veles");
		pila3.push("Vera");
		pila3.push("Candyman");
		
		System.out.println(pila3); 
		System.out.println(pila3.pop());
		
	}

}
