package overcooked;

public class SushiFactory implements PlatFactory{

	@Override
	public Plat crearPlat(Ingredient ingredient) {
		// TODO Auto-generated method stub
		return new PlatBasic("Sashimi amb" + ingredient.getNom());
	}
	
	
}
