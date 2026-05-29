package decoratorPersonatge;

public class Personatge {

	private String nom;
	private int vida;
	private int atac;
	

	public Personatge(String nom, int vida, int atac) {
		this.nom = nom;
		this.vida = vida;
		this.atac = atac;
	}
	
	public Personatge() {
		
		this.nom = "Dani";
		this.vida = 5;
		this.atac = 10;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida += vida;
	}

	public int getAtac() {
		return atac;
	}

	public void setAtac(int atac) {
		this.atac += atac;
	}

	@Override
	public String toString() {
		return "Personatge [nom=" + nom + ", vida=" + vida + ", atac=" + atac + "]";
	}
}

