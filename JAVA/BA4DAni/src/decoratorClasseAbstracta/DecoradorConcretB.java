package decoratorClasseAbstracta;

public class DecoradorConcretB extends Decorador {

	public DecoradorConcretB(Component component) {
		super(component);
	}
	@Override
	public void operacio() {
		super.operacio();
		comportamentAfegit();
		System.out.println("Afegint patata B ");
	}
	private void comportamentAfegit() {
		System.out.println("patata b afegida");
		
	}

}
