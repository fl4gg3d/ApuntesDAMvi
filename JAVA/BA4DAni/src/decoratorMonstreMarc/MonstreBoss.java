package decoratorMonstreMarc;

public class MonstreBoss extends MonstreDecorador {

	boolean raid = false; 
	
	public MonstreBoss(Monstre mon, boolean raid) {
		super(mon);
		this.raid = raid;
	}
	
	@Override
	public void atacar() {
		super.atacar();
		if(raid) {
			System.out.println("Compte, el monstre és un boss de raid");
		}else {
			System.out.println("El monstre és un boss de masmorra!");
		}
	}

}
