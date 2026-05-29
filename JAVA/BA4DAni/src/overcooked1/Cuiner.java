package overcooked1;

public class Cuiner {
	private String nom;
	private int sexe; //0-masculí, 1-femení
	
	
	public Cuiner(String nom, int sexe) {
		this.nom = nom;
		this.setSexe(sexe); 
	}
	
	public void cuinar(String nomRestaurant) {
		Plat plat = Restaurant.getInstance(nomRestaurant).servirComanda();
		if(plat == null) {
       		System.out.println("No hi ha comandes");
       		return;
       	}
		if (this.sexe==0) {
			System.out.println("El cuiner "+nom+" està cuinant "+plat);
		} else {
			System.out.println("La cuinera "+nom+" està cuinant "+plat);
		}
		
		System.out.println(plat+" cuinat i consumit.");
		Restaurant.getInstance(nomRestaurant).afegirPlatBrut(plat);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}
	
	

}
