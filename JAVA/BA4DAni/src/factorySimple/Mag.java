package factorySimple;

/**
 * Classe concreta que representa un Mag.
 */
public class Mag implements Personatge {

	/**
	 * Implementació del mètode atacar per al Mag.
	 */
	@Override
	public void atacar() {
		System.out.println("El Mag ataca amb un encanteri");
	}
}