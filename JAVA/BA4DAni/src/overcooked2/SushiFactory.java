package overcooked2;

public class SushiFactory extends PlatFactory{

	@Override
	public Plat crearPlat(Ingredient ingredient) {
		return new Plat("Sashimi amb "+ingredient.getNom());
	}

}
