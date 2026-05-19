package examenTutti;

public class ItemInventari {

	String nom;
	int quantitat;
	String tipus;
	Efecte efecte;
	
	public ItemInventari(String nom, int quantitat, String tipus, Efecte efecte) {
		super();
		this.nom = nom;
		this.quantitat = quantitat;
		this.tipus = tipus;
		this.efecte = efecte;
	}

	@Override
	public String toString() {
		return "ItemInventari [nom=" + nom + ", quantitat=" + quantitat + ", tipus=" + tipus + ", efecte=" + efecte
				+ "]";
	}

}
