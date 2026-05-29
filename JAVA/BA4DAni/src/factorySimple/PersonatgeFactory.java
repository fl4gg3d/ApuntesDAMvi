package factorySimple;

/**
 * Classe Factory que s'encarrega de crear objectes Personatge.
 * Centralitza la creació i evita que el main conegui les classes concretes.
 */
public class PersonatgeFactory {

	/**
	 * Mètode estàtic que crea un Personatge segons el tipus indicat.
	 * 
	 * @param tipus String que indica el tipus de personatge ("guerrer", "arquer", "mag")
	 * @return un objecte que implementa Personatge
	 */
	public static Personatge crearPersonatge(String tipus) {

		// Decidim quin objecte crear segons el tipus
		switch (tipus) {
		case "guerrer":
			return new Guerrer();
		case "arquer":
			return new Arquer();
		case "mag":
			return new Mag();
		default:
			// Si el tipus no existeix, llancem una excepció
			throw new IllegalArgumentException("Tipus no trobat " + tipus);
		}
	}
}