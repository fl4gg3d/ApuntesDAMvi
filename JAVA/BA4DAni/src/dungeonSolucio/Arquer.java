package dungeonSolucio;

public class Arquer extends Heroi {
	public Arquer(String nom, int hp, int atac, String facció) {
		super(nom, hp, atac, facció);
	}

	@Override
	public String toString() {
		return "Arquer [" + super.toString() + "]";
	}
}
