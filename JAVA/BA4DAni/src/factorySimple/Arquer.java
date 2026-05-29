package factorySimple;

/**
 * Classe concreta que representa un Arquer.
 */
public class Arquer implements Personatge {

	/**
	 * Implementació del mètode atacar per l'Arquer.
	 */
	@Override
	public void atacar() {
		System.out.println("El Arquer ataca amb una fletxa");
	}
}