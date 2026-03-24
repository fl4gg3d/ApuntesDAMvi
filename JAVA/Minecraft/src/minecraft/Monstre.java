package minecraft;

public class Monstre extends NoJugable{

	int atac;
	
	public Monstre(String nom, int maxHp, int atac) {
		super(nom, maxHp);
		this.atac = atac;
	}
	
	
	//Metodos
	public boolean atacar(Personatge P) {
		P.setHp(P.getHp() - this.atac);
		return viu;
	}
	
}
