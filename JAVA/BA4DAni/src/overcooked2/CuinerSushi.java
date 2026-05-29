package overcooked2;

public class CuinerSushi extends Cuiner {
    public CuinerSushi(String nom, int sexe) {
        super(nom, sexe);
    }

    @Override
    public void cuinar(String nomRestaurant) {
    	Plat plat = Restaurant.getInstance(nomRestaurant).servirComanda();
       	if(plat == null) {
       		System.out.println("No hi ha comandes");
       		return;
       	}
    	if(plat.getNom().contains("Sashimi")) {
    		if (getSexe() == 0) {
                System.out.println("El cuiner de sushi " + getNom() + " està cuinant: " + plat);
            } else {
                System.out.println("La cuinera de sushi " + getNom() + " està cuinant: " + plat);
            }
            System.out.println(plat+" cuinat i consumit.");
    		Restaurant.getInstance(nomRestaurant).afegirPlatBrut(plat);
    	} else {
    		System.out.println("ERROR -- " + getNom() + " no pot cuinar "+plat);
    		Restaurant.getInstance(nomRestaurant).afegirComanda(plat);
    	}
        
    }
}

