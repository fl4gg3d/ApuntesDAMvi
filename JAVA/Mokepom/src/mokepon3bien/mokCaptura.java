package mokepon3bien;

public class mokCaptura extends mokepon{

	String nombreP;
	String nombreEntrenador;
	private int felicidad;
	
	
	//CONSTRUCTORES
	public mokCaptura(String nom, Tipos tipo) {
		
		super(nom, tipo);
		
		this.nombreP = nom;
		this.nombreEntrenador = "Red";
		this.felicidad = 50;
		
		
	}
	public mokCaptura(mokepon mok, String nomP, String nomEntrenador) {
		
		super(mok.getNombre(), mok.getHpMax(), mok.getLevel(), mok.getAtk(), mok.getDef(), mok.getVel(), mok.getTipo());
		this.felicidad = 50;
		this.nombreEntrenador = nomEntrenador;
		this.nombreP = nomP;
		
	}
	//FIN CONSTRUCTORES
	
	//INICIO METODOS
	
	//acaricia al pokemon
	public void acariciar() {
		if (this.felicidad < 100) {
			this.felicidad += 10;
		}
	}
	
	//Combate
	public void Atacar(mokepon atacado, int numAtak) {
		if(!this.isDebilitado()) {
			if(this.getSetAtks().get(numAtak).useAct > 0) {
				double damage = (((((2 * this.getLevel()) / 5) + 2) * (this.getSetAtks().get(numAtak).power) * (this.getAtk() / atacado.getDef())/ 50 + 2) * (super.efectivitat(this.getSetAtks().get(numAtak).tipo, atacado.getTipo())));
				this.getSetAtks().get(numAtak).useAct--;
				damage = dañoFeliz(damage);
				atacado.setHpAct(atacado.getHpAct() - (int) damage);
				super.debilitadoEnCombate();
				super.displayCombate(atacado, damage, numAtak);
			}
			else {
				System.out.println("No quedan movimientos");
			}
		}
		
	}
	private double dañoFeliz(double damage) {
		if(this.felicidad >= 50) {
			return damage * 1.2;
		}else {
			return damage * 0.8;
		}
	}
	//FIN METODOS
	//GETTERS
	public int getFelicidad() {
		return felicidad;
	}
	//FIN GETTERS
}
