package overcooked2;

public class JapoFactory implements RestaurantFactory{

	@Override
	public Cuiner crearCuiner(String nom, int sexe) {
		return new CuinerSushi(nom, sexe);
	}

	@Override
	public Ingredient crearIngredient() {
		return new Arros();
	}

}
