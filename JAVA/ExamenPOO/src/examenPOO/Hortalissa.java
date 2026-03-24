package examenPOO;

public class Hortalissa extends Objecte{

	Tipus tipus;
	int preuVenda;
	
	public Hortalissa(String nom, Tipus tipus, int preuVenda) {
		super(nom);
		this.tipus = tipus;
		this.preuVenda = preuVenda;
	}

	@Override
	public String toString() {
		return super.toString() + " ("+tipus+")";
	}

	@Override
	public int vendre() {
		System.out.println("S'ha venut " + this.nom + " per " + this.preuVenda);
		return this.preuVenda;
	}

}
