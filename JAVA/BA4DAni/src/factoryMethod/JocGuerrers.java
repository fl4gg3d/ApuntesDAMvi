package factoryMethod;

public class JocGuerrers extends Joc {

	@Override
	public Personatge factoryMethod() {
		return new Guerrer();
	}

}
