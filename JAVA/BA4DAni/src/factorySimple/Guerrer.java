package factorySimple;

/**
 * Classe concreta que representa un Guerrer.
 * Implementa la interfície Personatge.
 */
public class Guerrer implements Personatge {

	/**
	 * Implementació específica del mètode atacar.
	 * Mostra un missatge propi del Guerrer.
	 */
	@Override
	public void atacar() {
		System.out.println("El Guerrer ataca amb l'espasa");
	}
}