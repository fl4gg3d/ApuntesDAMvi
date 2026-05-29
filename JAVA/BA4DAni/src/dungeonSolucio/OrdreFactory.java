package dungeonSolucio;

public class OrdreFactory extends DungeonFactory {
	@Override
	public Heroi crearHeroi() {
		return new Guerrer("Cavaller de la Llum", 60, 12, "Ordre de la Llum");
	}

	@Override
	public Arma crearArma() {
		return new Espasa("Espasa Sagrada", 15);
	}
}
