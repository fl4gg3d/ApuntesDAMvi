package overcooked;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Restaurant restaurant = Restaurant.getInstance("El bistreau de DAMvi");
		restaurant.obrirRestaurant();
		Cuiner cuiner = new Cuiner("Dani", 0);
		Plat plat = new Plat("Pizza");
		Plat plat2 = new Plat("Pepe");
		Plat plat3 = new Plat("Sassa");
		Plat plat4 = new Plat("Peperoni");
		Plat plat5 = new Plat("Salsa de la casa");
		
		restaurant.afegirPlatBrut(plat5);
		restaurant.afegirPlatBrut(plat2);
		restaurant.afegirPlatBrut(plat3);
		restaurant.afegirPlatBrut(plat4);
		
		cuiner.cuinarPlat("El bistreau de DAMvi");
		
		restaurant.iniciarRentatAutomatic();
		
		
	}

}
