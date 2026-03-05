package mokepon2bien;

import java.util.ArrayList;
import java.util.Random;

import mokepon2.TipusMokepon;

public class mokepon {

	String nombre;
	
	// SALUD
	int hpMax;
	int hpAct;

	// ESTADO
	boolean debilitado;

	// ESTADISTICAS
	int atk;
	int def;
	int vel;

	// NIVEL
	int level;
	int exp;

	// TIPO
	Tipos tipo;

	// SET ATAQUES
	ArrayList<Ataque> setAtks = new ArrayList<Ataque>();
	
	
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
	
	//Sube de nivel
	public void subirLevel() {
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
	
	//FIN METODOS
}
