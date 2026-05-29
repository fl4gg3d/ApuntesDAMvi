package dungeonSolucio;

public class CreadorMags extends CreadorHerois {
	@Override
	public Heroi factoryMethod(Nivell nivell) {
		switch (nivell) {
		case NOVELL:
			return new Mag("Aprenent", 20, 8, "Lliure");
		case VETERÀ:
			return new Mag("Hechicero", 35, 18, "Lliure");
		case LLEGENDARI:
			return new Mag("Arcimag", 50, 30, "Lliure");
		default:
			throw new IllegalArgumentException("Nivell no reconegut: " + nivell);
		}
	}
}
