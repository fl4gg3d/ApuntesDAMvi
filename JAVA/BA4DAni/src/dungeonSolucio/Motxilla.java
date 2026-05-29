package dungeonSolucio;

import java.util.ArrayDeque;

public class Motxilla extends ArrayDeque<String> {

	private static final int MAX = 3;

	// Afegeix un objecte al cim de la pila.
	// Si ja hi ha MAX, descarta el més antic (fons) i afegeix el nou al cim.
	public void afegir(String objecte) {
		if (this.size() == MAX) {
			this.pollLast(); // elimina el més antic (fons de la pila)
		}
		this.push(objecte); // afegeix al cim
	}

	// Usa l'objecte del cim:
	// - "màgic" -> imprimeix i NO elimina
	// - "normal" -> imprimeix i elimina
	// - buida -> no fa res
	public void usar() {
		if (this.isEmpty())
			return;
		String obj = this.peek();
		System.out.println("L'heroi utilitza " + obj);
		if (obj.contains("normal")) {
			this.pop();
		}
	}
}
