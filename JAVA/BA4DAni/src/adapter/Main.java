package adapter;

public class Main {

	public static void main(String[] args) {
		EstadistiquesCombat stats = new EstadistiquesCombat(10.5,TipusArma.MARTELL);
		EstadistiquesAdapter adapter = new EstadistiquesAdapter(stats);
		Guerrer guerrer = new Guerrer(20,adapter);
		System.out.println(guerrer);

	}

}
