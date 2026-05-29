package decoratorPersonatge;

public class PersonatgeGuerrer implements PersonatgeJoc{

	@Override
	public void crearPersonatge(Personatge p) {
		System.out.println("Guerrer " + p.getNom() + " creat");
		
	}

}
