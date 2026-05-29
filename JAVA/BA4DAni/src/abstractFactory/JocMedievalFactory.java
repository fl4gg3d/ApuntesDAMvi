package abstractFactory;

public class JocMedievalFactory implements JocFactory{

	@Override
	public Personatge crearPersonatge() {
		
		return new Guerrer();
	}

	@Override
	public Arma crearArma() {
		// TODO Auto-generated method stub
		return new Espasa();
	}

}
