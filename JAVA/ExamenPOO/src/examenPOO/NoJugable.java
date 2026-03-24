package examenPOO;

public abstract class NoJugable extends Personatge {

	private int apreci;
	private int apreciMaxim;

	public NoJugable(String nom, Hortalissa preferida, boolean casat) {
		super(nom, preferida);
		this.apreci = 0;
		this.apreciMaxim = 10;

	}

	public int getApreci() {
		return apreci;
	}

	public void setApreci(int apreci) {
		this.apreci = apreci;
		if (this.apreci > apreciMaxim) {
			this.apreci = apreciMaxim;
		} else if (this.apreci < 0) {
			this.apreci = 0;
		}
	}

	public abstract boolean propostaParella(Granger g);

	public int getApreciMaxim() {
		return apreciMaxim;
	}
}
