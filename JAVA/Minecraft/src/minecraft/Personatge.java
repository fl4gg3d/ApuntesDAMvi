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

	public void setHp(int hp) {
		this.hp = hp;
		if(this.hp > this.maxHp) {
			this.hp = this.maxHp;
		}
		if(this.hp <= 0) {
			this.viu = false;
		}
	}

	@Override
	public String toString() {
		return "Personatge [nom=" + nom + ", maxHp=" + maxHp + ", hp=" + hp + "]";
	}

	public int getHp() {
		return hp;
	}	
}
