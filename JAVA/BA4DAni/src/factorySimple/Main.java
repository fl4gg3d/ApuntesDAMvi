package factorySimple;

/**
 * Classe principal que prova el funcionament del patró Factory Simple.
 */
public class Main {

	public static void main(String[] args) {

		// Creació de personatges mitjançant la Factory
		// El main NO fa servir 'new', delega la creació
		Personatge p1 = PersonatgeFactory.crearPersonatge("guerrer");
		Personatge p2 = PersonatgeFactory.crearPersonatge("arquer");
		Personatge p3 = PersonatgeFactory.crearPersonatge("mag");

		// Cridem el mateix mètode sobre diferents objectes
		// -> Exemple de polimorfisme
		p1.atacar();
		p2.atacar();
		p3.atacar();
	}
}