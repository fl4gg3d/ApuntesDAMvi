package dungeonSolucio;

public class Dungeon {
	private static Dungeon instance;
	private static String nom;
	private int nivellPerill;
	private int tresor = 0;
	private int heroisDins = 0;
	private static final int CAPACITAT = 3;

	private Dungeon(String nom, int nivellPerill) {
		Dungeon.nom = nom;
		this.nivellPerill = nivellPerill;
	}

	public static Dungeon getInstance(String nom, int nivellPerill) {
		if (instance == null) {
			instance = new Dungeon(nom, nivellPerill);
		}
		return instance;
	}

	public static String getNom() {
		return nom;
	}

	public int getNivellPerill() {
		return nivellPerill;
	}

	public void entrar(Heroi heroi) {
		if (heroisDins >= CAPACITAT) {
			System.out.println("La dungeon està plena!");
			return;
		}
		heroisDins++;
		tresor += heroi.atac;
		System.out.println("Entrant a la dungeon: " + nom + " (perill: " + nivellPerill + ")" + ". Tresor: " + tresor
				+ ". Herois dins: " + heroisDins + "/" + CAPACITAT);
	}

	@Override
	public String toString() {
		return "Dungeon [nom=" + nom + ", nivellPerill=" + nivellPerill + ", tresor=" + tresor + ", heroisDins="
				+ heroisDins + "]";
	}
}
