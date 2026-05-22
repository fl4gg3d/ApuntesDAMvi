package overcooked;

public class PlatBasic implements Plat{
	
	private String nom;
	private double tempsPreparacio = 5.0;
	private double cost = 10.0;
	
	public PlatBasic(String nom) {
		this.nom = nom;
	}
	
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return nom;
	}

	@Override
	public double getTempsPreparacio() {
		// TODO Auto-generated method stub
		return tempsPreparacio;
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return cost;
	}

}
