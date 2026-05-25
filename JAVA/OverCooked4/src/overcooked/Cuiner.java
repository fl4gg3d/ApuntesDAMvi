package overcooked;

public abstract class Cuiner {
	
	private String name;
	private int sexe;
	private int estat;
	
	public Cuiner(String name, int sexe) {
		super();
		this.name = name;
		this.sexe = sexe;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}

	public void cuinar(String nomRestaurant) {
		Plat plat = Restaurant.getInstance(nomRestaurant, null).servirComanda();
			
		double modificador = Restaurant.getInstance(nomRestaurant, null).getAmbient().getModificadorDesgastCuiner();
		this.estat -= (1* modificador);
		
		if(this.sexe == 0) {
			System.out.println("El cuiner "+this.name+" esta cuinant "+plat);
		}else{
			System.out.println("La cuinera "+this.name+" esta cuinant "+plat);
		}
		
	}

	@Override
	public String toString() {
		return "Cuiner [name=" + name + ", sexe=" + sexe + "]";
	}
	
	
	
}
