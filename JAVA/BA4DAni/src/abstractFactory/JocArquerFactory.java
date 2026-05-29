package abstractFactory;

public class JocArquerFactory implements JocFactory {

	@Override
	public Personatge crearPersonatge() {	
		return new Arquer();
	}
	@Override
	public Arma crearArma() {
		return new Arc();
	}
}
