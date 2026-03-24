package examenPOO;

public class Llavor extends Objecte {

	private int tornsRegada;
	private int tornsPerACreixer;
	Hortalissa hortalissa;

	public Llavor(String nom, int tornsPerCreixer, Hortalissa hortalissa) {
		super(nom);
		this.setTornsRegada(0);
		this.hortalissa = hortalissa;
		this.tornsPerACreixer = tornsPerCreixer;
	}

	public int getTornsRegada() {
		return tornsRegada;
	}

	public void setTornsRegada(int tornsRegada) {
		this.tornsRegada = tornsRegada;
		if(this.tornsRegada > tornsPerACreixer) {
			this.tornsRegada = this.tornsPerACreixer;
		}
	}

	public int getTornsPerACreixer() {
		return tornsPerACreixer;
	}

	@Override
	public int vendre() {
		System.out.println("No es un objecte que es pugui vendre");
		return 0;
	}

}
