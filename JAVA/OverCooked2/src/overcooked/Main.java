package overcooked;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		Restaurant restaurant = Restaurant.getInstance("El bistreau de DAMvi");
		restaurant.obrirRestaurant();
		
		RestaurantFactory italiaFactory = new ItaliaFactory();
		RestaurantFactory japoFactory = new JapoFactory();
		PizzaFactory pizzaFactory = new PizzaFactory();
		SushiFactory sushiFactory = new SushiFactory();
		
		Cuiner dani = italiaFactory.creaCuiner("Dani", 0);
		Cuiner marc = japoFactory.creaCuiner("Marc", 0);
		Ingredient tomate = italiaFactory.creaIngredient();
		Ingredient arros = japoFactory.creaIngredient();
		
		Plat pizza = pizzaFactory.crearPlat(tomate);
		Plat sushi = sushiFactory.crearPlat(arros);
		
		dani.cuinar(restaurant.getNom());
		
	}
}
