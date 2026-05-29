package dungeonSolucio;

public abstract class Arma {
	String nom;
	int dany;

	public Arma(String nom, int dany) {
		this.nom = nom;
		this.dany = dany;
	}

	@Override
	public String toString() {
		return "nom=" + nom + ", dany=" + dany;
	}
}
