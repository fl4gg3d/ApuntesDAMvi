package mokepon;

public class Arma extends Objecte implements Equipament {

	private int atacExtra;

	Arma(String nom, int atacExtra) {
		super(nom);
		this.atacExtra = atacExtra;
	}

	public void Equipar(MokeponCapturat mokCapturat) {
		
		if(potEquipar(mokCapturat)) {
			mokCapturat.setObjecteEquipat(this);
			mokCapturat.setAtk(mokCapturat.getAtk() + atacExtra);
		}else {
			System.out.println("No pots equipar ara mateix");
		}
		
	}

	public void Desequipar(MokeponCapturat mokCapturat) {

		mokCapturat.setObjecteEquipat(null);
		mokCapturat.setAtk(mokCapturat.getAtk() - atacExtra);
	}

	@Override
	public void utilitzar(Mokepon mok) {
		this.Equipar((MokeponCapturat) mok);
	}
}
