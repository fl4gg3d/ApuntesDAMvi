package dungeonSolucio;

public abstract class Heroi {
	String nom;
	int hp;
	int atac;
	String facció;

	public Heroi(String nom, int hp, int atac, String facció) {
		this.nom = nom;
		this.hp = hp;
		this.atac = atac;
		this.facció = facció;
	}

	@Override
	public String toString() {
		return "nom=" + nom + ", hp=" + hp + ", atac=" + atac + ", facció=" + facció;
	}
}
