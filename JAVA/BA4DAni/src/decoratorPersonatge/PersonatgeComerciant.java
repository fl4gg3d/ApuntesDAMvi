package decoratorPersonatge;

public class PersonatgeComerciant implements PersonatgeJoc {

	@Override
	public void crearPersonatge(Personatge p) {
		System.out.println("Comerciant " + p.getNom() + " creat");
		
	}

}
