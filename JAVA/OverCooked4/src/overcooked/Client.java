package overcooked;

import java.awt.List;
import java.util.ArrayList;

public class Client implements OrderSubject, ConsumptionSubject{
	private String nom;
	private int tempsPaciencia;
	private String preferenciaCuina;
	private boolean marxa;
	private String alergia;
	private List<OrderObserver> orderObservers = new ArrayList<>();
	private ConsumptionObserver consumptionObserver;
	
	public Client(String nom, String preferenciaCuina) {
		super();
		this.nom = nom;
		this.tempsPaciencia = 20;
		this.preferenciaCuina = preferenciaCuina;
		this.marxa = false;
		this.alergia = null;
	}

	public Client(String alergia) {
		super();
		this.tempsPaciencia = 18;
		this.alergia = alergia;
	}
	
	public void ferComanda(Restaurant restaurant) {
		
		PlatFactory factory;
		Ingredient ingredient;
		
		if(this.preferenciaCuina.equals("italia")) {
			factory = new PizzaFactory();
			ingredient = new Tomaquet();
		}else {
			factory = new SushiFactory();
			ingredient = new Arros();
		}
		
		Plat plat = factory.crearPlat(ingredient);
		
		restaurant.afegirComanda(plat);
	
		System.out.println(this.nom + "ha demanat" + plat);
		
	}
	
	public void consumirPlat(Plat plat, Restaurant restaurant) {
		
		boolean marxa = false;
		
		if(plat.getTempsPreparacio() > this.tempsPaciencia) {
			marxa = true;
		}
		if(this.alergia != null && plat.getNom().contains(alergia)) {
			marxa = true;
		}
		if(!marxa) {
			System.out.println("paga" + plat.getCost());
		}
		
		restaurant.afegirPlatBrut(plat);
	}

	@Override
	public void registerConsumptionObserver(ConsumptionObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeConsumptionObserver(ConsumptionObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyConsumptionObservers(Plat plat, boolean paid, double amount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerOrderObserver(OrderObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrderObserver(OrderObserver observer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notifyOrderObservers(Plat plat) {
		// TODO Auto-generated method stub
		
	}
}
