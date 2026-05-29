package dungeonSolucio;

public class ClanFactory extends DungeonFactory {
    @Override
    public Heroi crearHeroi() {
        return new Mag("Bruixot de les Ombres", 35, 18, "Clan de les Ombres");
    }
    @Override
    public Arma crearArma() {
        return new Vareta("Vareta Maleïda", 20);
    }
}
