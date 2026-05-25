package overcooked;

public abstract class PlatDecorator implements Plat{

	protected Plat platDecorat;
	
	public PlatDecorator(Plat plat) {
		this.platDecorat = plat;
	}
	
	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return platDecorat.getNom();
	}

	@Override
	public double getTempsPreparacio() {
		// TODO Auto-generated method stub
		return platDecorat.getTempsPreparacio();
	}

	@Override
	public double getCost() {
		// TODO Auto-generated method stub
		return platDecorat.getCost();
	}

}
