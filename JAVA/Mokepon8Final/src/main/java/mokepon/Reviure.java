package mokepon;

public class Reviure extends Objecte {

	public Reviure(String nom) {
		super(nom);
	}

	public void utilitzar(Mokepon mok) {

		if (this.getQuantitat() < 1) {
			System.out.println("No tens elixir per reviure");
		} else {

			if (mok.isDebilitat()) {
				this.Quantitat--;
				mok.setDebilitat(false);

				mok.setHp_actual(1);
			} else {
				System.out.println("Aquest Mokepon no està pas debilitat");
			}
		}
	}

	@Override
	public String toString() {
		return "Reviure [Quantitat=" + Quantitat + ", Nom=" + getNom() + "]";
	}

}
