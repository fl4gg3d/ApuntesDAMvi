package minecraft;

public class Pocio extends Item{

	int poder;
	Tipo tipo;

	public Pocio(String nom, int valor, int poder, Tipo Enum) {
		super(nom, valor);
		this.poder = poder;
		this.tipo = Enum;
	}

	@Override
	public void avaluar() {
		System.out.println("Nom: "+this.nom + " Tipo: "+this.tipo);
		if(this.valor > 50) {
			System.out.println("Es molt valuosa!");
		}
	}
}
