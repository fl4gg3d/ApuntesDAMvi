package overcooked;

public class ItaliaFactory implements RestaurantFactory{

	@Override
	public Cuiner creaCuiner(String nom, int sexe) {
		// TODO Auto-generated method stub
		return new CuinerPizza(nom, sexe);
	}

	@Override
	public Ingredient creaIngredient() {
		// TODO Auto-generated method stub
		return new Tomaquet();
	}

}
