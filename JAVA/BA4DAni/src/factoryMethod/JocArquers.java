package factoryMethod;

public class JocArquers extends Joc {

	@Override
	public Personatge factoryMethod() {
		
		return new Arquer();
	}

}
