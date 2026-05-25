package overcooked;

public class Main {

	public static void main(String[] args) throws InterruptedException {

        DecoradorAmbient ambient = new AmbTempesta(new SobreLava(new AmbientBase()));

        Restaurant restaurant = Restaurant.getInstance("DAMvi", ambient);

        restaurant.obrirRestaurant();

        Client client1 = new Client("Marc", "italia");
        Client client2 = new Client("Anna", "japo");

        Cuiner cuiner1 = new CuinerPizza("Dani", 0);
        Cuiner cuiner2 = new CuinerSushi("Laura", 1);

        Plat pizza = new FormatgeExtra(new Pepperoni(new PlatBasic("Pizza")));

        Plat sushi = new SalsaExtra(new PlatBasic("Sushi"));

        restaurant.afegirComanda(pizza);
        restaurant.afegirComanda(sushi);

        cuiner1.cuinar(restaurant.getNom());
        cuiner2.cuinar(restaurant.getNom());

        client1.consumirPlat(pizza, restaurant);
        client2.consumirPlat(sushi, restaurant);

        restaurant.iniciarRentatAutomatic();
		
	}
}
