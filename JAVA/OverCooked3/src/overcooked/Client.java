package overcooked;

public class Client {
	private String nom;
	private int tempsPaciencia;
	private String preferenciaCuina;
	private boolean marxa;
	private String alegria;
	
	
	
	public Client(String nom, String preferenciaCuina) {
		super();
		this.nom = nom;
		this.tempsPaciencia = 20;
		this.preferenciaCuina = preferenciaCuina;
		this.marxa = false;
		this.alegria = null;
	}

	public Client(String alegria) {
		super();
		this.tempsPaciencia = 18;
		this.alegria = alegria;
	}
	
	
}
