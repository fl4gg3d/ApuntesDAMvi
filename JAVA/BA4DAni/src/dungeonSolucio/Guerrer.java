package dungeonSolucio;

public class Guerrer extends Heroi {
	public Guerrer(String nom, int hp, int atac, String facció) {
		super(nom, hp, atac, facció);
	}

	@Override
	public String toString() {
		return "Guerrer [" + super.toString() + "]";
	}
}
