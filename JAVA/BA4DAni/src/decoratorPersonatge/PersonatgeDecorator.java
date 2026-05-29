package decoratorPersonatge;

public class PersonatgeDecorator implements PersonatgeJoc {
	public PersonatgeJoc personatgeDecorat;

	public PersonatgeDecorator(PersonatgeJoc personatgeDecorat) {
		this.personatgeDecorat = personatgeDecorat;
	}

	@Override
	public void crearPersonatge(Personatge p) {
		this.personatgeDecorat.crearPersonatge(p);
	}

}
