package overcooked;

public class CuinerSushi extends Cuiner{

	public CuinerSushi(String name, int sexe) {
		super(name, sexe);
		// TODO Auto-generated constructor stub
	}
	 @Override
	   public void cuinar(String nomRestaurant) {
	   	Plat plat = Restaurant.getInstance(nomRestaurant).servirComanda();
	       if (getSexe() == 0) {
	           System.out.println("El cuiner de sushi " + getName() + " està cuinant: " + plat);
	       } else {
	           System.out.println("La cuinera de sushi " + getName() + " està cuinant: " + plat);
	       }
	       System.out.println(plat+" cuinat i consumit.");
			Restaurant.getInstance(nomRestaurant).afegirPlatBrut(plat);
	   }
} 