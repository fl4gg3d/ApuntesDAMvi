package factoryMethod;

/**
 * Interfície comuna per a tots els personatges del joc.
 */
public interface Personatge {

	/**
	 * Mètode que defineix l'acció d'atacar.
	 * Cada tipus de personatge el farà diferent.
	 */
	void atacar();
}