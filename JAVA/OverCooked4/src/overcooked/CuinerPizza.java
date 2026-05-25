package overcooked;

public class CuinerPizza extends Cuiner {

	public CuinerPizza(String name, int sexe) {
		super(name, sexe);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cuinar(String nomRestaurant) {
		Plat plat = Restaurant.getInstance(nomRestaurant, null).servirComanda();
		if (plat.toString().contains("Pizza")) {
			if (getSexe() == 0) {
				System.out.println("El cuiner de sushi " + getName() + " està cuinant: " + plat);
			} else {
				System.out.println("La cuinera de sushi " + getName() + " està cuinant: " + plat);
			}
			System.out.println(plat + " cuinat i consumit.");
			Restaurant.getInstance(nomRestaurant, null).afegirPlatBrut(plat);
		}else {
			System.out.println("El cuiner no esta especialitzat en aquest plat");
		}
	}

}
