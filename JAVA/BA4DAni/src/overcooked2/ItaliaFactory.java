package overcooked2;

public class ItaliaFactory implements RestaurantFactory{

	@Override
	public Cuiner crearCuiner(String nom, int sexe) {
		return new CuinerPizza(nom,sexe);
	}

	@Override
	public Ingredient crearIngredient() {
		return new Tomaquet();
	}

}
