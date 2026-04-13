package mokepon8;

import java.util.Random;

public class Huevo {

	private String especie;
	private Tipos tipo;
	private int pasosRestantes;

	public Huevo(String especie, Tipos tipo) {

		Random rand = new Random();
		this.pasosRestantes = rand.nextInt(5, 10);
	}

	public void Caminar() {

		this.pasosRestantes -= 1;
		if (this.pasosRestantes == 0) {
			eclosionar();
		}

	}

	public mokepon eclosionar() {
		mokepon moke = new mokepon(this.especie, this.tipo);
		return moke;
	}

}
