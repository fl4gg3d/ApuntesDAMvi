package abstractFactory;

public class MainJocAbstract {

	public static void main(String[] args) {
		
		jugarAmbFactory(new JocMedievalFactory());
		jugarAmbFactory(new JocArquerFactory());

	}

	private static void jugarAmbFactory(JocFactory factory) {
		
		Personatge p = factory.crearPersonatge();
		Arma a = factory.crearArma();
		
		p.atacar();
		a.usar();
		
	}

}
