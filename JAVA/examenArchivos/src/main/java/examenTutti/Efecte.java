package examenTutti;

public class Efecte {

	String nom;
	int potencia;
	
	public Efecte(String nom, int potencia) {
		super();
		this.nom = nom;
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Efecte [nom=" + nom + ", potencia=" + potencia + "]";
	}
}
