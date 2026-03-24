package examenPOO;

public class PersonatgeCasable extends NoJugable {

	public PersonatgeCasable(String nom, Hortalissa preferida, boolean casat) {
		super(nom, preferida, casat);
	}

	@Override
	public boolean propostaParella(Granger g) {
		if (this.getApreci() == this.getApreciMaxim()) {
			g.parella = this;
			return true;
		} else {
			return false;
		}
	}

}
