package decoratorMonstreMarc;

public class MonstreDecorador extends Monstre {

	protected Monstre mon; 
	
	public MonstreDecorador(Monstre mon) {
		this.mon = mon;
	}
	
	@Override
	public void atacar() {
		mon.atacar();

	}

}
