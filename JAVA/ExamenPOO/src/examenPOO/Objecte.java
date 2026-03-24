package examenPOO;

public abstract class Objecte {

	String nom;

	public Objecte(String nom) {
		this.nom = nom;
	}

	public abstract int vendre();

	@Override
	public String toString() {
		return nom;
	}
}
