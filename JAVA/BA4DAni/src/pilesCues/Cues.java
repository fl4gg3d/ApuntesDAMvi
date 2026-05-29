package pilesCues;

import java.util.ArrayDeque;

public class Cues {

	public static void main(String[] args) {


		ArrayDeque<String> cua = new ArrayDeque<String>();
		
		//Deque Double Ended Queue. Funciona con una cua i una pila simultaneament
		
		
		cua.add("puedo preguntar una cosa"); // amb add afegim a la cua en últim lloc
		cua.add("Alvaro no responde");
		cua.add("Examen XML");
		cua.add("MaKsy va suspendre");
		cua.add("Me llama Enrique");
		cua.add("Mokepon forever");
	
		// Les cues són FIFO (First In First Out) primer que entra primer que surt
		
		System.out.println(cua);
		
		System.out.println(cua.size()); //size ens diu la mida de la cua
		System.out.println(cua.poll()); // poll retorna el primer element de la cua i l'elimina d'aquesta
		System.out.println(cua);
		
		System.out.println(cua.peek()); // peek retorna el primer element de la cua, per no l'elimina
		System.out.println(cua);
		
		System.out.println(cua.isEmpty()); // isEmpty ens diu si la cua és buida (true/false)
		
		System.out.println(cua.contains("Enrique"));  // contains ens diu se trobem l'element a la cua (true/false)
		System.out.println(cua.contains("Me llama Enrique"));
		
		MeuaCueta<Integer> cua2 = new MeuaCueta<Integer>(); 
		
		//cua2.add(0, 5); // llança excepció perquè hem modificat el comportament del add al definir el mètode de la nostra classe
		cua2.push(5); //aquí push actua com un add, afegeix al final de la cua
		System.out.println(cua2);
		cua2.push(5);
		cua2.push(6);
		cua2.push(7);
		cua2.push(67);
		System.out.println(cua2);
		System.out.println(cua2.pop());
		
	}

}
