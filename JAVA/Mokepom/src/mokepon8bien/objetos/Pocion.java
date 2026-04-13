package mokepon8bien.objetos;

import mokepon8.mokCaptura;

public class Pocion extends Objeto {

	Pocion(int hpCurada) {
		super("Pocion");
		this.hpCurado = hpCurada;
	}

	private int hpCurado;

	@Override
	public void utilizar(mokCaptura mok) {
		if (this.cantidad >= 1) {
			if (mok.isDebilitado()) {
				System.out.println(
						"El mokepon esta debilitado, no puedes administrar este tipo objeto a un mokepon debilitado");
			} else {
				mok.setHpAct(mok.getHpAct() + hpCurado);
				if (mok.getHpAct() + hpCurado > mok.getHpMax()) {
					mok.setHpAct(mok.getHpMax());
				}
				System.out.println("Mokepon curado");
				this.cantidad--;
			}
		} else {
			System.out.println("No te quedan pociones");
		}
	}

}
