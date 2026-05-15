package overcooked;

public class JapoFactory implements RestaurantFactory{

	@Override
	public Cuiner creaCuiner(String nom, int sexe) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ingredient creaIngredient() {
		// TODO Auto-generated method stub
		return new Arros();
	}

}
