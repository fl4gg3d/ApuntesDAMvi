package decoratorMonstreMarc;

public class MonstreAmbArees extends MonstreDecorador {

	String area = "";

	public MonstreAmbArees(Monstre mon, String area) {
		super(mon);
		this.area = area;
	}

	
	@Override
	public void atacar() {
		super.atacar();
		System.out.println("El monstre té un atac d'area " + area);
	}

}
