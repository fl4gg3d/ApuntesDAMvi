package mokepon;

public class MainCombat {

	/**
	 * Decideix quin Mokepon comença segons la velocitat.
	 *
	 * Retorna:
	 * - 1 si comença mokepon1
	 * - 2 si comença mokepon2
	 */
	public static int mokeponMesRapid(Mokepon mokepon1, Mokepon mokepon2) {
		if (mokepon1.getVel() >= mokepon2.getVel()) {
			return 1;
		}
		return 2;
	}

	/**
	 * Gestiona un atac segons de qui sigui el torn.
	 *
	 * Retorna true si el combat acaba perquè el defensor queda debilitat.
	 */
	public static boolean gestionarAtac(Mokepon mokepon1, Mokepon mokepon2, int torn, int numAtac) {
		if (torn == 1) {
			mokepon1.atacar(mokepon2, numAtac);
			return mokepon2.isDebilitat();
		} else {
			mokepon2.atacar(mokepon1, numAtac);
			return mokepon1.isDebilitat();
		}
	}

	/**
	 * Comprova si el combat ha acabat.
	 */
	public static boolean fiCombat(boolean debilitat, int torn) {
		if (debilitat) {
			System.out.println("Combat acabat. Guanya el Mokepon del torn " + torn);
			return true;
		}
		return false;
	}

	/**
	 * Alterna el torn entre 1 i 2.
	 */
	public static int canviTorn(int torn) {
		if (torn == 1) {
			return 2;
		}
		return 1;
	}

	/**
	 * Tria quin atac s'utilitza.
	 *
	 * En aquesta versió es fa amb una seqüència prefixada per facilitar proves.
	 */
	public static int triaAtac(int[] seqAtacs, int index) {
		return seqAtacs[index % seqAtacs.length];
	}

	public static void main(String[] args) {

		// =========================================================
		// CREACIÓ DELS MOKEPONS
		// =========================================================

		Mokepon mokepon1 = new Mokepon("Marmander", Tipus.FOC);
		Mokepon mokepon2 = new Mokepon("Mulmasaur", Tipus.PLANTA);

		// =========================================================
		// ATACS
		// =========================================================

		mokepon1.afegirAtac(new Atac("Flamarada", 90, Tipus.FOC, 10));
		mokepon1.afegirAtac(new Atac("Cops", 30, Tipus.FOC, 10));

		mokepon2.afegirAtac(new Atac("Fulla Tallant", 60, Tipus.PLANTA, 10));
		mokepon2.afegirAtac(new Atac("Placatge", 20, Tipus.PLANTA, 10));

		// =========================================================
		// VARIABLES DE CONTROL DEL COMBAT
		// =========================================================

		boolean fi = false;

		// Seqüència d'atacs per fer proves:
		// 0 = primer atac, 1 = segon atac
		int[] atacsPredeterminats = {0, 0, 1, 0, 1, 0, 0, 1};
		int indexAtac = 0;

		int torn = mokeponMesRapid(mokepon1, mokepon2);

		System.out.println("=== COMENÇA EL COMBAT ===");
		System.out.println("Mokepon 1: " + mokepon1);
		System.out.println("Mokepon 2: " + mokepon2);
		System.out.println("Comença el torn del Mokepon " + torn);

		// =========================================================
		// BUCLE PRINCIPAL DEL COMBAT
		// =========================================================

		while (!fi && indexAtac < atacsPredeterminats.length) {

			int numAtac = triaAtac(atacsPredeterminats, indexAtac);

			System.out.println("\n--- Torn del Mokepon " + torn + " ---");
			System.out.println("Atac triat: " + numAtac);

			boolean debilitat = gestionarAtac(mokepon1, mokepon2, torn, numAtac);

			System.out.println("Estat després de l'atac:");
			System.out.println("Mokepon 1: " + mokepon1);
			System.out.println("Mokepon 2: " + mokepon2);

			fi = fiCombat(debilitat, torn);

			if (!fi) {
				torn = canviTorn(torn);
			}

			indexAtac++;
		}

		if (!fi) {
			System.out.println("\nEl combat s'ha aturat perquè s'ha acabat la seqüència d'atacs de prova.");
		}

		System.out.println("\n=== FI DEL COMBAT ===");
	}
}
