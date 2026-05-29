package overcooked1;

public class Restaurant {
	private static Restaurant instance ;
	private static String nom;
	private Comandes comandes;
	private PlatsBruts platsbruts;
	
	private Restaurant(String nom) {
		Restaurant.nom=nom;
		this.comandes=new Comandes();
		this.platsbruts=new PlatsBruts();
	}

	public static Restaurant getInstance(String nom) {
		if(instance==null) {
			instance = new Restaurant(nom); 
		}
		return instance;
	}
	
	public void obrirRestaurant() {
		System.out.println("El restaurant "+nom+" està obert!");
	}

	public String getNom() {
		return nom;
	}

	public void afegirComanda(Plat p) {
        comandes.add(p);
    }
	
	public Plat servirComanda() {
		return comandes.use();
	}
	
	public void afegirPlatBrut(Plat p) {
		platsbruts.add(p);
	}
	
	public void iniciarRentatAutomatic() {
		while(!platsbruts.isEmpty()) {
			try {
				platsbruts.use();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				System.out.println("ERROR 4L: Rentaplats espatllat. Trucar al servei tècnic.");
			}
		}
		System.out.println("Tots els plats rentats!");
	}

}
