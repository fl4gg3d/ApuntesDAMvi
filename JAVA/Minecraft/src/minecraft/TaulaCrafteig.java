package minecraft;

public class TaulaCrafteig {

	private Item comp1;
	private Item comp2;
	private Item comp3;
	private Item resultat;
	
	
	public TaulaCrafteig() {
		this.comp1 = null;
		this.comp2 = null;
		this.comp3 = null;
	}
	
	
	//Metodos
	
	public boolean afegirComponent(Item c1, Item c2, Item resultat) {
		if(comp1 instanceof Component && comp2 instanceof Component && resultat instanceof Pocio) {
			
			this.comp1 = c1;
			this.comp2 = c2;
			this.resultat = resultat;
			return true;
			
		}
		
		return false;
	}
	public Item craftejar() {
		
		if(this.comp1 != null && this.comp2 != null && this.comp3 != null) {
			return this.resultat;
		}
		return null;
		
		return null;
	}
}
