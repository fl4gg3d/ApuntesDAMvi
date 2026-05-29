package overcooked1;

public class Main {
	public static void main(String[] args) {
		Restaurant restaurant = Restaurant.getInstance("El bistreau de DAMvi");
        restaurant.obrirRestaurant();

        Cuiner dani = new Cuiner("Dani",0);
        Cuiner claudia = new Cuiner("Claudia",1);
        Plat pizza = new Plat("Pizza");
        Plat sushi = new Plat("Sushi");
        //cuiner.cuinar(plat);
        
        // Afegim comandes
        restaurant.afegirComanda(pizza);
        restaurant.afegirComanda(sushi);
        
        // Cuinem
        dani.cuinar(restaurant.getNom());
        claudia.cuinar(restaurant.getNom());
        
        // Iniciem rentaplats
        restaurant.iniciarRentatAutomatic();
        
	}
}
