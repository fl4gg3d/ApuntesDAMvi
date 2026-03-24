package examenPOO;

public abstract class Personatge {

	String nom;
	Hortalissa preferida;
	boolean casat;

	public Personatge(String nom, Hortalissa preferida) {
		this.nom = nom;
		this.preferida = preferida;
	}

	@Override
	public String toString() {
		return nom;
	}

}
