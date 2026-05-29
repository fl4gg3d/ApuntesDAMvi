package decoratorPersonatge;

public class TestPersonatgeDeocrator {

	public static void main(String[] args) {

		Personatge p = new Personatge("Dani2", 50, 10);

		PersonatgeGuerrer pjoc = new PersonatgeGuerrer();
		ArmaduraDecorator pblindat = new ArmaduraDecorator(pjoc);
		ArmaDecorator pArmat = new ArmaDecorator(pblindat, "espasa");

		pArmat.crearPersonatge(p);
		System.out.println(p.getAtac());
		System.out.println(p.getVida());


	}

}
