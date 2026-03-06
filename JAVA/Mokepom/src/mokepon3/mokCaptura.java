package mokepon3;

public class mokCaptura extends mokepon{

	String nombreP;
	String nombreEntrenador;
	int felicidad;
	
	
	//CONSTRUCTORES
	public mokCaptura(String nom, Tipos tipo) {
		
		super(nom, tipo);
		
		this.nombreP = nom;
		this.nombreEntrenador = "Red";
		this.felicidad = 50;
		
		
	}
	public mokCaptura(mokepon mok, String nomP, String nomEntrenador) {
		
		super(mok.nombre, mok.hpMax, mok.level, mok.atk, mok.def, mok.vel, mok.tipo);
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
		if(!this.debilitado) {
			if(this.setAtks.get(numAtak).useAct > 0) {
				double damage = (((((2 * this.level) / 5) + 2) * (this.setAtks.get(numAtak).power) * (this.atk / atacado.def)/ 50 + 2) * (super.efectivitat(this.setAtks.get(numAtak).tipo, atacado.tipo)));
				this.setAtks.get(numAtak).useAct--;
				atacado.hpAct -= (int) damage;
				debilitadoEnCombate();
				super.displayCombate(atacado, damage, numAtak);
			}
			else {
				System.out.println("No quedan movimientos");
			}
		}
		
	}
	
	
	//FIN METODOS
}
