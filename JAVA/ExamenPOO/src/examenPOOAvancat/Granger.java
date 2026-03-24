package examenPOOAvancat;

public class Granger extends Personatge{

	Personatge parella;

	public Granger(String nom, Hortalissa preferida) {
		super(nom, preferida);
		this.casat = false;
		this.parella = null;
	}

	// METODES

	public int regalar(NoJugable altrePersonatge, Objecte regal) {
		if (regal instanceof Hortalissa) {
			if(regal.nom.equals(altrePersonatge.preferida.nom)) {
				altrePersonatge.setApreci(altrePersonatge.getApreci() + 2);
			}else {
				altrePersonatge.setApreci(altrePersonatge.getApreci() + 1); 
			}
			// RECUERDA HACER EL LIMITE EN EL SETTER (HECHO)
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
			c.conreat.setTornsRegada(c.conreat.getTornsRegada() + 1); // RECUERDA HACER EL LIMITE EN EL SETTER (HECHO)
		}
	}

	
	//Solo esta hecho al completo la parte de Exception, lo otro no funciona
	public Hortalissa collir(Conreu c) throws GrangerIncompetentException{
		if (c.conreat != null && c.conreat.getTornsRegada() >= c.conreat.getTornsPerACreixer()) {
			Hortalissa recollida = c.conreat.hortalissa;
			c.conreat = null;
		}else if(c.conreat == null) {
			throw new GrangerIncompetentException("El conreu no te llavor");
		}else if (c.conreat.getTornsRegada() < c.conreat.getTornsPerACreixer()) {
			throw new GrangerIncompetentException("La llavor todavia le falta per a creixer");
		}
		return c.conreat.hortalissa;
	}

	@Override
	public void casar(Fuckable parella) {
		// TODO Auto-generated method stub
		
	}
}
