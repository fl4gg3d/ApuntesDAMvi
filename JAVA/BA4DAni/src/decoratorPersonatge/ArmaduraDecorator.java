package decoratorPersonatge;

public class ArmaduraDecorator extends PersonatgeDecorator{

	public ArmaduraDecorator(PersonatgeJoc personatgeDecorat) {
		super(personatgeDecorat);

	}
	@Override
	public void crearPersonatge(Personatge p) {
		this.personatgeDecorat.crearPersonatge(p);
		afegirArmadura(p);
	}

	private void afegirArmadura(Personatge p) {
		System.out.println("Afegida armadura a " + p.getNom());
		p.setVida(10);
	}

}
