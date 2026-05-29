package decoratorMonstreMarc;

public class MonstreAmbElement extends MonstreDecorador {

	Element el;
	
	public MonstreAmbElement(Monstre mon, Element el) {
		super(mon);
		this.el = el;
		
	}
	
	@Override
	public void atacar() {
		super.atacar();
		System.out.println("El monstre ataca amb element " + el.name());
	}

}
