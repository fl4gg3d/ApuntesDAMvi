package mokepon;

public class ObjecteFactory {
	public Objecte crearObjecte(String tipus) {
		if (tipus == null || tipus.isEmpty())
			return null;
		switch (tipus) {
		case "POCIO":
			return new Pocio("Pocio",50); // les pocions per defecte curen 50 de vida
		case "SUPERPOCIO":
			return new Pocio("SuperPocio",100);
		case "HIPERPOCIO":
			return new Pocio("HiperPocio",200);
		case "ELIXIR":
			return new Reviure("Elixir");
		case "ESPASA":
			return new Arma("Espasa",30);
		case "COTAMALLA":
			return new Armadura("CotaMalla",40);
		// seguir
		// fer la resta de casos
		default:
			throw new IllegalArgumentException("Tipus d'objecte desconegut " + tipus);
		}
	}
}
