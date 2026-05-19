package mokepon;

import java.io.Serializable;

//Una classe abstracta no pot instanciar-se (és a dir, no pots fer un new). 
//Només les classes abstractes poden tenir mètodes abstractes

public abstract class Objecte implements Serializable {

	private String nom;
	protected int Quantitat;

	public Objecte(String nom) {

		this.nom = nom;
		Quantitat = 1;
	}

	public String getNom() {
		return nom;
	}

	public int getQuantitat() {
		return Quantitat;
	}

	public void obtenir(int numObjectes) {

		this.Quantitat += numObjectes;

	}

	public void donar(MokeponCapturat mokCapturat) {

		mokCapturat.setObjecte(this);
	}

	// Un mètode abstracte significa que és un mètode que no existeix però els seus
	// fills estan obligats a implementar-lo. Fixa’t que es tanca amb punt i coma
	// sense obrir i definir el mètode
	public abstract void utilitzar(Mokepon mok);

	@Override
	public String toString() {
		return "Objecte [nom=" + nom + ", Quantitat=" + Quantitat + "]";
	}
	
	
}
