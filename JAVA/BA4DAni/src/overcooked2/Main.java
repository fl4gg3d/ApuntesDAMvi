package overcooked2;


public class Main {

	public static void main(String[] args) {
		Restaurant restaurant = Restaurant.getInstance("El bistreau de DAMvi");
        restaurant.obrirRestaurant();

        // Factories per als plats
        PlatFactory pizzaFactory = new PizzaFactory();
        PlatFactory sushiFactory = new SushiFactory();

        // Fàbrica italiana
        RestaurantFactory italiaFactory = new ItaliaFactory();
        Cuiner cuinerItalia = italiaFactory.crearCuiner("Dani", 0);
        Plat pizza = pizzaFactory.crearPlat(italiaFactory.crearIngredient()); // Usem Factory Method
        // Afegim comandes
        restaurant.afegirComanda(pizza);
        

        // Fàbrica japonesa
        RestaurantFactory japonesFactory = new JapoFactory();
        Cuiner cuinerJapones = japonesFactory.crearCuiner("Claudia", 1);
        Ingredient ingredientJapones = japonesFactory.crearIngredient();
        Plat sushi = sushiFactory.crearPlat(ingredientJapones); // Usem Factory Method
        // Afegim comandes
        restaurant.afegirComanda(sushi);
        
        // Proves de cuina
        cuinerJapones.cuinar(restaurant.getNom());
        cuinerItalia.cuinar(restaurant.getNom());
        cuinerItalia.cuinar(restaurant.getNom());
        cuinerJapones.cuinar(restaurant.getNom());
  
        // Rentar plats
        restaurant.iniciarRentatAutomatic();

        
	}

}
