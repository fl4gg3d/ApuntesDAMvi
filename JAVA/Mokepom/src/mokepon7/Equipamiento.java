package mokepon7;

public interface Equipamiento {

	public abstract void equipar(mokCaptura mokC);

	public abstract void desequipar(mokCaptura mokC);

	public default boolean puedeEquipar(mokCaptura mokC) {
		if (mokC.isDebilitado()) {
			System.out.println("El pokemon esta debilitado no se puede equipar");
			return false;
		} else if (mokC.objetoEquipado != null) {
			System.out.println("El pokemon ya teiene un objeto equipado");
			return false;
		} else {
			System.out.println("El pokemon puede equiparse un objeto");
			return true;
		}

	}

	public default boolean equipoMalPuesto(mokCaptura mokC) {
		if (mokC.objetoP instanceof Equipamiento) {
			System.out.println("El objeto esta mal equipado");
			return true;
		} else {
			System.out.println("Equipo bien puesto");
			return false;
		}
	}
}
