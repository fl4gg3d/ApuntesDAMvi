package mokepon;

public class Pocio extends Objecte {

	private int hp_curada;

	public Pocio(String nom, int hp_curada) {
		super(nom);
		this.hp_curada = hp_curada;
	}

	public int getHp_curada() {
		return hp_curada;
	}

	public void utilitzar(Mokepon mok) {

		if (this.getQuantitat() < 1) {
			System.out.println("No tens pocions");
		} else {
			if (!mok.isDebilitat()) {
				this.Quantitat--;
				if (mok.getHp_actual() + hp_curada > mok.getHp_max()) {

					mok.setHp_actual(mok.getHp_max());
				} else {
					mok.setHp_actual(mok.getHp_actual() +hp_curada);
				}

			} else {
				System.out.println(
						"No pots utilitzarla poció perquè aquest Mokepon està debilitat, primer l'hauràs de reviure");
			}

		}
	}

	@Override
	public String toString() {
		return "Pocio [hp_curada=" + hp_curada + ", Nom=" + getNom() + "]";
	}
	

}
