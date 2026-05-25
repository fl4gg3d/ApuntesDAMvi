package overcooked;

public class Restaurant {
	
	//atributs del restaurant
    private static Restaurant instance;
    private static String nom;
    private static Comandes cm = new Comandes();
    private static PlatsBruts pb = new PlatsBruts();
    private DecoradorAmbient ambient;
    
    //constructor privat de restaurant
    private Restaurant(String nom, DecoradorAmbient ambient) {
		Restaurant.nom=nom;
		this.ambient = ambient;
	}
    //mètode getInstance que es cridarà des de fora i que accedirà al constructor privat
    public static Restaurant getInstance(String nom, DecoradorAmbient ambient) {
		if(instance==null) {
			instance = new Restaurant(nom, ambient);
		}
		return instance;
	}
    public DecoradorAmbient getAmbient() {
		return ambient;
	}
	// mètodes 
	public void obrirRestaurant() {
		System.out.println("El restaurant "+nom+" està obert!");
	}
	public static String getNom() {
		return nom;
	}
	public void afegirComanda(Plat p) {
		cm.add(p);
	}
	public Plat servirComanda() {
		return cm.poll();
	}
	public void afegirPlatBrut(Plat p) {
		pb.add(p);
	}
	public void iniciarRentatAutomatic() throws InterruptedException {
		while(pb.size() != 0) {
			System.out.println();
			System.out.println(pb.poll());
			Thread.sleep(3000);
			System.out.println("Plato limpio!");
		}
		System.out.println();
		System.out.println("Tots els plats rentats");
	}
}
