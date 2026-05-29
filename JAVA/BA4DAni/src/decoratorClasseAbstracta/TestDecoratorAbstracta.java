package decoratorClasseAbstracta;

public class TestDecoratorAbstracta {

	public static void main(String[] args) {
		
		ComponentConcret cc = new ComponentConcret();
		DecoradorConcretA d1 = new DecoradorConcretA(cc);
		DecoradorConcretB d2 = new DecoradorConcretB(d1);
		
		d2.operacio();

	}

}
