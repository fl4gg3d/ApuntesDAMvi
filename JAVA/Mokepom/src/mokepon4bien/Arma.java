package mokepon4bien;

public class Arma extends Objeto implements Equipamiento{
	
	public Arma(String nombre, int ataqueExtra) {
		super(nombre);
		this.ataqueExtra = ataqueExtra;
	}

	int ataqueExtra;

	@Override
	public void utilizar(mokepon mok) {
		// TODO Auto-generated method stub
	}

	@Override
	public void equipar(mokCaptura mokC) {
		mokC.objetoEquipado = this;
		mokC.setAtk(mokC.getAtk() + ataqueExtra);
	}

	@Override
	public void desequipar(mokCaptura mokC) {
		mokC.objetoEquipado = null;
		mokC.setAtk(mokC.getAtk() - ataqueExtra);
	}
}
