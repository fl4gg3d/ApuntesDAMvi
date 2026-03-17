package minecraft;

public class Comerciant extends NoJugable{

	int quantitat;
	int preuVenda;
	Item objecte;

	public Comerciant(String nom, int preuVenda, Item objecte) {
		super(nom, 1);
		this.preuVenda = preuVenda;
		this.objecte = objecte;
		// TODO Auto-generated constructor stub
	}
}
