package mokepon2;

public class MokeponCapturao extends Mokepon {

	String nomPosat;
	String nomEntrenador;
	int felicitat;

	public MokeponCapturao(String nom, TipusMokepon tipus) {

		super(nom, tipus);

		this.nomPosat = nom;
		this.nomEntrenador = "Ruby";
		this.felicitat = 50;

	}

	public MokeponCapturao(Mokepon mok, String nomPuesto, String nomEntreneador) {

		super(mok.nom, mok.hp_max, mok.lvl, mok.atk, mok.def, mok.vel, mok.tipo);
		this.felicitat = 50;
		this.nomEntrenador = nomEntreneador;
		this.nomPosat = nomPuesto;

	}

	public void acaririar() {

		if (this.felicitat < 100) {
			this.felicitat += 10;
		}

	}

	public void Combate(Mokepon atacado, int num_atac) {
		if (!atacado.debilitado) {
			if (this.listaAtaques.get(num_atac).usos_act > 0) {
				double dany = ((((((2 * this.lvl) / 5) + 2) * this.listaAtaques.get(num_atac).poder * ((double) this.atk / atacado.def)) / 50) + 2) * super.efectivitat(this.tipo, atacado.tipo);
				this.listaAtaques.get(num_atac).usos_act--;
				if(this.felicitat >= 50) {
					dany *= 1.2;
				}else {
					dany *= 0.8;
				}
				atacado.hp_act -= (int) dany;
				debilitadoSIoNO(atacado);
				System.out.println();
				System.out.println("Ataca: " + this.nom);
				System.out.println("DAÑO: " + (int) dany);
				System.out.println("Vida contringante = " + atacado.nom + " " + atacado.hp_act);
				if (super.efectivitat(this.tipo, atacado.tipo) == 2) {
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

}
