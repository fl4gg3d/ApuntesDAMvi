package mokepon4bien;

public abstract class Objeto {
	
	private String nombre;
	protected int cantidad;
	
	public Objeto(String nombre) {
		
		this.nombre = nombre;
		this.cantidad = 1;
		
	}
	
	//Metodos
	
	public void Obtener(int numObjetos) {
		this.cantidad = numObjetos;
	}
	public void dar(mokCaptura mokC) {
		mokC.objetoP = this;
	}
	public abstract void utilizar(mokepon mok);
	//Fin metodos
	
	//Getters
	public String getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	
}
