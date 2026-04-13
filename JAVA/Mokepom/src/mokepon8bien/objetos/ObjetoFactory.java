package mokepon8bien.objetos;

public class ObjetoFactory {
		
	public static Objeto crearObjecte(String tipus)
    {
        if (tipus == null || tipus.isEmpty())
            return null;
        switch (tipus) {
        case "POCIO":
            return new Pocion(50);  //les pocions per defecte curen 50 de vida
        case "SUPERPOCIO":
            return new Pocion(100);
        case "HIPERPOCIO":
            return new Pocion(200);
            // seguir
        //fer la resta de casos
        default:
            throw new IllegalArgumentException("Tipus d'objecte desconegut "+tipus);
        }
    }

	
}
