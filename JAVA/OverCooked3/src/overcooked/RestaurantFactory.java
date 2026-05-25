package overcooked;

public interface RestaurantFactory {
	Cuiner creaCuiner(String nom, int sexe);
	
	Ingredient creaIngredient();
}
