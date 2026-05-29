package factoryMethod;

public abstract class Joc {

	public abstract Personatge factoryMethod();
	
	public void jugar() {
		Personatge p = factoryMethod();
		p.atacar();
	}
}
