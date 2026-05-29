package overcooked2;

public class PizzaFactory extends PlatFactory{

	@Override
	public Plat crearPlat(Ingredient ingredient) {
		return new Plat("Pizza amb "+ingredient.getNom());
	}

}
