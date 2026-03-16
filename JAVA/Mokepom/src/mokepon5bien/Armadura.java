package mokepon5bien;

public class Armadura extends Objeto implements Equipamiento {

	int defensaExtra;

	public Armadura(String nombre, int defensaExtra) {
		super(nombre);
		this.defensaExtra = defensaExtra;
	}

	@Override
	public void equipar(mokCaptura mokC) {
		mokC.objetoEquipado = this;
		mokC.setDef(mokC.getDef() + this.defensaExtra);
	}

	@Override
	public void desequipar(mokCaptura mokC) {
		mokC.objetoEquipado = null;
		mokC.setDef(mokC.getDef() - this.defensaExtra);
	}

	@Override
	public void utilizar(mokCaptura mok) {
		equipar(mok);
	}

}
