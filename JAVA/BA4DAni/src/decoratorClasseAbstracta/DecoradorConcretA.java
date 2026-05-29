package decoratorClasseAbstracta;

public class DecoradorConcretA extends Decorador {
	
	private String propietatAfegida;

	public DecoradorConcretA(Component component) {
		super(component);
		
	}
	
	@Override
	public void operacio() {
		super.operacio();
		this.propietatAfegida = "nova patata A afegida";
		System.out.println("Afegida patata A ");
	}

}
