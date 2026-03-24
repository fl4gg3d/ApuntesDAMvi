package examenPOO;

public class Granger extends Personatge {

	Personatge parella;

	public Granger(String nom, Hortalissa preferida) {
		super(nom, preferida);
		this.casat = false;
		this.parella = null;
	}

	// METODES

	public int regalar(NoJugable altrePersonatge, Objecte regal) {
		if (!(regal instanceof Llavor)) {
			altrePersonatge.setApreci(altrePersonatge.getApreci() + 1); // RECUERDA HACER EL LIMITE EN EL SETTER
		} else {
			altrePersonatge.setApreci(altrePersonatge.getApreci() - 1);
		}
		return altrePersonatge.getApreci();
	}

	public void plantar(Conreu c, Llavor l) {
		c.conreat = l;
	}

	public void regar(Conreu c) {
		if (c != null) {
			c.conreat.setTornsRegada(c.conreat.getTornsRegada() + 1); // RECUERDA HACER EL LIMITE EN EL SETTER
		}
	}

	public Hortalissa collir(Conreu c) {
		if (c.conreat != null && c.conreat.getTornsRegada() >= c.conreat.getTornsPerACreixer()) {
			Hortalissa recollida = c.conreat.hortalissa;
			c.conreat = null;
			return recollida;
		} else {
			return null;
		}
	}

}
