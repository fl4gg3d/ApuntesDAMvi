package minecraft;

public abstract class Personatge {

	String nom;
	boolean viu;
	private int maxHp;
	private int hp;
	
	public Personatge(String nom, int maxHp) {
		
		this.maxHp = maxHp;
		this.nom = nom;
		this.viu = true;
		
	}
	
}
