package mokepon;

import java.util.ArrayList;
import java.util.Random;

public class Mokepon {

	String nom;

	// vida Max
	int hp_max;
	// vida actual
	int hp_act;
	// debilitado
	boolean debilitado;

	// nivel
	int lvl;
	// experiencia
	int exp;

	// Ataques
	ArrayList<Ataques> listaAtaques = new ArrayList<Ataques>();

	// ataque
	int atk;
	// defensa
	int def;
	// velocidad
	int vel;
	// tipo
	TipusMokepon tipo;

	public void ataquePaLaLista(Ataques atak) {
		if (this.listaAtaques.size() < 2) {
			this.listaAtaques.add(atak);
		}
	}

	public Mokepon(String nom, int hp_max, int lvl, int atk, int def, int vel, TipusMokepon tipo) {

		this.nom = nom;
		this.atk = atk;
		this.def = def;
		this.vel = vel;
		this.hp_max = hp_max;
		this.hp_act = hp_max;
		this.tipo = tipo;
		this.debilitado = false;
		for (int i = 0; i < lvl; i++) {
			this.pujarLvl();
		}
	}

	// suma la experiencia otorgada con la experiencia actual
	public void expOtorgada(int exp_otorgada) {
		this.exp += exp_otorgada;

		while (this.exp > 100) {
			this.exp -= 100;
			pujarLvl();
		}
	}

	// sube de nivel
	public void pujarLvl() {
		Random rand = new Random();
		this.lvl++;
		this.hp_max += rand.nextInt(1, 6);
		this.hp_act = this.hp_max;
		this.atk += rand.nextInt(1, 3);
		this.def += rand.nextInt(1, 3);
		this.vel += rand.nextInt(1, 3);
	}

	// muestra en pantalla el nombre
	public void printNom() {
		System.out.println(this.nom);
	}

	// muestraStats
	public void mostrarStats() {
		System.out.println();
		System.out.println(this.hp_act);
		System.out.println(this.hp_max);
		System.out.println(this.atk);
		System.out.println(this.def);
		System.out.println(this.vel);
		System.out.println(this.exp);
		System.out.println(this.lvl);
		System.out.println(this.tipo);
		System.out.println();
	}

	// Efectivo
	public double efectivitat(TipusMokepon atac, TipusMokepon defensa) {
		if (atac == TipusMokepon.fuego && defensa == TipusMokepon.agua
				|| atac == TipusMokepon.agua && defensa == TipusMokepon.planta
				|| atac == TipusMokepon.planta && defensa == TipusMokepon.fuego) {
			return 0.5;
		} else if (atac == TipusMokepon.agua && defensa == TipusMokepon.fuego
				|| atac == TipusMokepon.fuego && defensa == TipusMokepon.planta
				|| atac == TipusMokepon.planta && defensa == TipusMokepon.agua) {
			return 2;
		} else {
			return 1;
		}
	}

	// Combate
	public void Combate(Mokepon atacado, int num_atac) {
		if (!atacado.debilitado) {
			if (this.listaAtaques.get(num_atac).usos_act > 0) {
				double dany = ((((((2 * this.lvl) / 5) + 2) * this.listaAtaques.get(num_atac).poder
						* ((double) this.atk / atacado.def)) / 50) + 2) * efectivitat(this.tipo, atacado.tipo);
				this.listaAtaques.get(num_atac).usos_act--;
				atacado.hp_act -= (int) dany;
				debilitadoSIoNO(atacado);
				System.out.println();
				System.out.println("Ataca: " + this.nom);
				System.out.println("DAÑO: " + (int) dany);
				System.out.println("Vida contringante = " + atacado.nom + " " + atacado.hp_act);
				if (efectivitat(this.tipo, atacado.tipo) == 2) {
					System.out.println("Es superefectivo!");
				}
				if (atacado.debilitado) {
					System.out.println("Pokemon enemigo debilitado");
				}
			} else {
				System.out.println("No quedan movimientos");
			}
		}
	}

	public void debilitadoSIoNO(Mokepon atacado) {
		if (atacado.hp_act <= 0) {
			atacado.hp_act = 0;
			atacado.debilitado = true;
		}
	}

}
