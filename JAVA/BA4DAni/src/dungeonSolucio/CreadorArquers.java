package dungeonSolucio;

public class CreadorArquers extends CreadorHerois {
	@Override
	public Heroi factoryMethod(Nivell nivell) {
		switch (nivell) {
		case NOVELL:
			return new Arquer("Tirador", 25, 6, "Lliure");
		case VETERÀ:
			return new Arquer("Caçador", 45, 14, "Lliure");
		case LLEGENDARI:
			return new Arquer("Sagitari", 70, 25, "Lliure");
		default:
			throw new IllegalArgumentException("Nivell no reconegut: " + nivell);
		}
	}
}
