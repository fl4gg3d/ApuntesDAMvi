package overcooked2;

abstract class Cuiner {
	private String nom;
	private int sexe; //0-masculí, 1-femení
	
	
	public Cuiner(String nom, int sexe) {
		this.nom = nom;
		this.setSexe(sexe); 
	}
	
	public abstract void cuinar(String nomRestaurant);
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
}
