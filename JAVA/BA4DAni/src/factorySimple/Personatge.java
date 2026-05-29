package factorySimple;

/**
 * Interfície que defineix el contracte comú de tots els personatges.
 * Qualsevol personatge haurà de saber atacar.
 */
public interface Personatge {

	/**
	 * Mètode que defineix l'acció d'atacar.
	 * Cada classe concreta implementarà el seu comportament.
	 */
	void atacar();
}