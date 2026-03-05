package mokepon;

public class Ataques {
	
	String nombre;
	Double poder;
	TipusMokepon tipo;
	int usos_max;
	int usos_act;

	public Ataques(String nombre, Double poder, int usos_max, TipusMokepon tipo) {
		this.nombre = nombre;
		this.poder = poder;
		this.usos_max = usos_max;
		this.usos_act = usos_max;
		this.tipo = tipo;
		
		if(this.poder < 10) {
			this.poder = 10.0;
		}else if(this.poder > 100) {
			this.poder = 100.0;
		}
	}
	
	public Ataques(String nombre, TipusMokepon tipo) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.poder = 10.0;
		this.usos_max = 10;
		this.usos_act = 10;
	}
	
}