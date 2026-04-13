package mokepon8;

import mokepon8bien.objetos.Objeto;

public class Arma extends Objeto implements Equipamiento {

	public Arma(String nombre, int ataqueExtra) {
		super(nombre);
		this.ataqueExtra = ataqueExtra;
	}

	int ataqueExtra;

	@Override
	public void utilizar(mokCaptura mok) {
		equipar(mok);
	}

	@Override
	public void equipar(mokCaptura mokC) {
		mokC.objetoEquipado = this;
		mokC.setAtk(mokC.getAtk() + this.ataqueExtra);
	}

	@Override
	public void desequipar(mokCaptura mokC) {
		mokC.objetoEquipado = null;
		mokC.setAtk(mokC.getAtk() - ataqueExtra);
	}
}
