package overcooked;

public class PizzaFactory implements PlatFactory{

	@Override
	public Plat crearPlat(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return new PlatBasic("Pizza amb" + ingredient.getNom());
	}
	
}
