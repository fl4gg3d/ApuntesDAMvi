package dungeonSolucio;

public class Mag extends Heroi {
	public Mag(String nom, int hp, int atac, String facció) {
		super(nom, hp, atac, facció);
	}

	@Override
	public String toString() {
		return "Mag [" + super.toString() + "]";
	}
}
