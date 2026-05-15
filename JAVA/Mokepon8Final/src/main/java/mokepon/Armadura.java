package mokepon;

public class Armadura extends Objecte implements Equipament {

	int defensaExtra;

	Armadura(String nom, int defensaExtra) {
		super(nom);
		this.defensaExtra = defensaExtra;
	}

	public void Equipar(MokeponCapturat mokCapturat) {
		if (potEquipar(mokCapturat)) {
			mokCapturat.setObjecteEquipat(this);
			mokCapturat.setDef(mokCapturat.getDef() + defensaExtra);
		} else {
			System.out.println("No pots equipar ara mateix");
		}
	}

	public void Desequipar(MokeponCapturat mokCapturat) {

		mokCapturat.setObjecteEquipat(null);
		mokCapturat.setDef(mokCapturat.getDef() - defensaExtra);
	}

	@Override
	public void utilitzar(Mokepon mok) {
		this.Equipar((MokeponCapturat) mok);
	}
}
