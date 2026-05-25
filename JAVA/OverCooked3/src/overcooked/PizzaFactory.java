package overcooked;

public class PizzaFactory implements PlatFactory{

	@Override
	public Plat crearPlat(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return new Plat("Pizza amb" + ingredient.getNom());
	}
	
}
