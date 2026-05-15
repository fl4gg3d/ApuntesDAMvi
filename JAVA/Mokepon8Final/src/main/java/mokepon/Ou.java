package mokepon;

/**
 * Classe Ou
 *
 * Representa el resultat de la reproducció entre dos Mokepons.
 *
 * Conté l'espècie, el tipus i les passes restants fins a l'eclosió.
 */

import java.util.Random;

public class Ou {

	static Random rand = new Random();
	
	private String especie;
	private Tipus tipus;
	private int passesRestants;
	
	
	public Ou (String especie, Tipus tipus) {
		
		this.especie = especie;
		this.tipus = tipus;
		this.passesRestants = rand.nextInt(5,11);
	}
	
	public void caminar(){
		
		this.passesRestants--;
		if(this.passesRestants<1) {
			eclosionar();
		}
	}

	public Mokepon eclosionar() {
		
		return new Mokepon(this.especie, this.tipus);		
	}
}
