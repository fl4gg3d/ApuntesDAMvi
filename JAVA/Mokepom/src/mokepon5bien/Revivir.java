package mokepon5bien;

public class Revivir extends Objeto {

	public Revivir(String nombre) {
		super(nombre);
	}

	@Override
	public void utilizar(mokCaptura mok) {
		if (this.cantidad > 1) {
			if (mok.isDebilitado()) {
				mok.setDebilitado(false);
				mok.setHpAct(1);
				this.cantidad--;
				System.out.println("Mokepon revivido");
			} else {
				System.out.println("El mokepon esta vivo, no puedes administrar este tipo objeto a un mokepon vivo");
			}
		} else {
			System.out.println("No te quedan revivires");
		}

	}

}
