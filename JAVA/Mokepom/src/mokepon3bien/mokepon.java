package mokepon3bien;

import java.util.ArrayList;
import java.util.Random;

public class mokepon {

	private String nombre;
	
	// SALUD
	private int hpMax;
	private int hpAct;

	// ESTADO
	private boolean debilitado;

	// ESTADISTICAS
	private int atk;
	private int def;
	private int vel;

	// NIVEL
	private int level;
	private int exp;

	// TIPO
	private Tipos tipo;

	// SET ATAQUES
	private ArrayList<Ataque> setAtks = new ArrayList<Ataque>();
	
	
	//CONSTRUCCIONES
	// MOKE PRED SIMPLE
	public mokepon() {

		this.nombre = "Ratatita";
		// SALUD
		this.hpMax = 10;
		this.hpAct = hpMax;
		// ESTADO
		this.debilitado = false;
		// STATS
		this.atk = 1;
		this.def = 1;
		this.vel = 1;
		// NIVEL
		this.level = 1;
		// TIPO
		this.tipo = Tipos.normal;

	}
	// MOKE PRED SIMPLE 2
	public mokepon(String nom, Tipos tipo) {

		this.nombre = nom;
		// SALUD
		this.hpMax = 10;
		this.hpAct = hpMax;
		// ESTADO
		this.debilitado = false;
		// STATS
		this.atk = 1;
		this.def = 1;
		this.vel = 1;
		// NIVEL
		this.level = 1;
		// TIPO
		this.tipo = tipo;

	}
	// MOKE PRED COMPLEJO
	public mokepon(String nom, int hp_max, int level, int atk, int def, int vel, Tipos tipo) {

		this.nombre = nom;
		//STATS
		this.atk = atk;
		this.def = def;
		this.vel = vel;
		//SALUD
		this.hpMax = hp_max;
		this.hpAct = hp_max;
		//TIPO
		this.tipo = tipo;
		//ESTADO
		this.debilitado = false;
		//SUBIR DE NIVEL (SI HACE FALTA)
		if(level > 1) {
			for (int i = 0; i < level; i++) {
				subirLevel();
			}
		}
	}
	//FIN CONSTRUCCIONES
	
	//METODOS
	//XP otorgada
	public void xpMokepon(int xp) {
		this.exp += xp;
		while(this.exp > 100) {
			this.exp -= 100;
			subirLevel();
		}
	}
	//Sube de nivel
	private void subirLevel() {
		Random rand = new Random();
		this.level++;
		this.hpMax += rand.nextInt(1, 6);
		this.hpAct = this.hpMax;
		this.atk += rand.nextInt(1, 3);
		this.def += rand.nextInt(1, 3);
		this.vel += rand.nextInt(1, 3);
	}
	//Registra los ataques al Mokepon
	public void registroAtaque(Ataque ataque) {
		if(this.setAtks.size() < 2) {
			this.setAtks.add(ataque);
		}
	}
	//Registra 2 ataques a la vez, en caso de que se haya asignado algun ataque asigna el ultimo;
	public void registroAtaqueVarios(Ataque ataque1, Ataque ataque2) {
		if(this.setAtks.size() == 0 || this.setAtks.size() < 2) {
			this.setAtks.add(ataque1);
			this.setAtks.add(ataque2);
		}
		else if(this.setAtks.size() == 1){
			System.out.println("Se ha detectado un ataque ya registrado, asignando el 2 ataque");
			this.setAtks.add(ataque2);
		}
	}
	//EFECTIVIDAD 
	public double efectivitat(Tipos atac, Tipos defensa) {
		if (atac == Tipos.fuego && defensa == Tipos.agua
				|| atac == Tipos.agua && defensa == Tipos.planta
				|| atac == Tipos.planta && defensa == Tipos.fuego) {
			return 0.5;
		} else if (atac == Tipos.agua && defensa == Tipos.fuego
				|| atac == Tipos.fuego && defensa == Tipos.planta
				|| atac == Tipos.planta && defensa == Tipos.agua) {
			return 2;
		} else {
			return 1;
		}
	}
	//CURA
	public void cura() {
		this.hpAct = this.hpMax;
		this.debilitado = false;
	}
	//COMBATE
	public void Atacar(mokepon atacado, int numAtak) {
		debilitadoEnCombate();
		if(!this.debilitado) {
			if(!atacado.debilitado) {
				if(this.setAtks.get(numAtak).useAct > 0) {
					double damage = (((((2 * this.level) / 5) + 2) * (this.setAtks.get(numAtak).power) * (this.atk / atacado.def)/ 50 + 2) * (efectivitat(this.setAtks.get(numAtak).tipo, atacado.tipo)));
					this.setAtks.get(numAtak).useAct--;
					atacado.hpAct -= (int) damage;
					displayCombate(atacado, damage, numAtak);	
				}
				else {
					System.out.println("No quedan movimientos");
				}
			}
		}else {
			System.out.println();
			System.out.println("Enemigo Debilitado");
		}
	}
	//DEBILITADO
	public void debilitadoEnCombate() {
		if(this.hpAct <= 0) {
			this.hpAct = 0;
			this.debilitado = true;
		}
	}
	public void displayCombate(mokepon atacado, double damage, int numAtak) {
		System.out.println();
		System.out.println(this.nombre + " a usado: " + this.setAtks.get(numAtak).nombre);
		if(efectivitat(this.tipo, atacado.tipo) == 2) {
			System.out.println("ES SUPEREFECTIVO!");
		}
		else if(efectivitat(this.tipo, atacado.tipo) == 0.5) {
			System.out.println("No es muy efectivo");
		}
		System.out.println("El daño realizado a " + atacado.nombre + " es de: " + (int) damage);
		System.out.println("Vida Enemigo: " + atacado.hpAct);
	}
	
	//CAPTURA
    public mokCaptura capturar(String nomEntrenador, String nomDonat) {
        if(!(this instanceof mokCaptura)) {
        	System.out.println("Captura realizada");
        	mokCaptura poke = new mokCaptura(this, nomDonat, nomEntrenador);
            return poke;
        }else{
            System.out.println("No pots capturar un Mokepon que ja esta capturat");
            return (mokCaptura) this;
        }
    }
	//FIN METODOS
    //GETTERS
	public String getNombre() {
		return nombre;
	}
	public int getHpMax() {
		return hpMax;
	}
	public int getHpAct() {
		return hpAct;
	}
	public boolean isDebilitado() {
		return debilitado;
	}
	public int getAtk() {
		return atk;
	}
	public int getDef() {
		return def;
	}
	public int getVel() {
		return vel;
	}
	public int getLevel() {
		return level;
	}
	public int getExp() {
		return exp;
	}
	public Tipos getTipo() {
		return tipo;
	}
	public ArrayList<Ataque> getSetAtks() {
		return setAtks;
	}
	//FIN GETTERS
	//SETTERS
	public void setHpAct(int hpAct) {
		if(hpAct < 0) {
			this.hpAct = 0;
		}
		else if(hpAct > this.hpMax) {
			this.hpAct = this.hpMax;
		}
	}
	public void setDebilitado(boolean debilitado) {
		this.debilitado = debilitado;
	}
	//FIN SETTERS
}
