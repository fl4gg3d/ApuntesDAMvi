package decoratorPersonatge;

public class ArmaDecorator extends PersonatgeDecorator {

	String tipusArma;

	public ArmaDecorator(PersonatgeJoc personatgeDecorat, String tipusArma) {
		super(personatgeDecorat);
		this.tipusArma = tipusArma;
	}

	@Override
	public void crearPersonatge(Personatge p) {
		this.personatgeDecorat.crearPersonatge(p);
		afegirArma(p, this.tipusArma);
	}

	private void afegirArma(Personatge p, String tipusArma) {
		System.out.println("Afegida " + tipusArma + "a " + p.getNom());
		if (tipusArma.equals("espasa")) {
			p.setAtac(100);
		}
	}

}
