package dungeonSolucio;

public class CreadorGuerrers extends CreadorHerois {
	@Override
	public Heroi factoryMethod(Nivell nivell) {
		switch (nivell) {
		case NOVELL:
			return new Guerrer("Escuder", 30, 5, "Lliure");
		case VETERÀ:
			return new Guerrer("Cavaller", 60, 12, "Lliure");
		case LLEGENDARI:
			return new Guerrer("Paladin", 100, 20, "Lliure");
		default:
			throw new IllegalArgumentException("Nivell no reconegut: " + nivell);
		}
	}
}
