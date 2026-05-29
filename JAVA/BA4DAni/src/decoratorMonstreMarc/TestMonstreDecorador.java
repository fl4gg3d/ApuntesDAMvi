package decoratorMonstreMarc;

public class TestMonstreDecorador {

	public static void main(String[] args) {

		MonstreBase m = new MonstreBase();
		
		MonstreAmbElement me = new MonstreAmbElement(m, Element.FOC);
		me.atacar();
		
		System.out.println("...................................");
		
		MonstreAmbArees ma = new MonstreAmbArees(m, "Patata");
		ma.atacar();
		
		System.out.println("...................................");
		
		MonstreAmbArees ma2 = new MonstreAmbArees(me, "PatatasArdiente"); 
		ma2.atacar();
		
		System.out.println();
		
		
		MonstreBoss mb = new MonstreBoss(ma2, true);
		mb.atacar();
		
		
	}

}
