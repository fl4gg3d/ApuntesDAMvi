package mokepon;

/**
 * Classe Atac
 *
 * Representa un atac que un Mokepon pot utilitzar en combat.
 *
 * En Mokepon 5 aquesta classe treballa també:
 * - equals()
 * - compareTo()
 *
 * Això permet comparar atacs i ordenar-los.
 */

/**
 * Classe Atac
 *
 * Representa un atac que un Mokepon pot utilitzar en combat. Conté: - nom
 * (String) - poder (double): força base de l'atac - tipus (Tipus):
 * FOC/AIGUA/PLANTA - moviments_maxims (int): "PP" màxims - moviments_actuals
 * (int): "PP" actuals
 *
 * Idea important: Cada objecte Atac té el seu estat (PP, poder...), i canvia
 * durant el combat.
 */
public class Atac implements Comparable {

	// Atributs (de moment package-private per simplicitat en Mokepon 1)
	String nom;
	double poder;
	Tipus tipus;
	int moviments_maxims;
	int moviments_actuals;

	/**
	 * Constructor complet.
	 *
	 * Inicialitza l'atac amb tots els valors. També aplica una validació bàsica: el
	 * poder queda acotat entre 10 i 100.
	 *
	 * Nota: Aquesta validació és un primer pas cap a encapsulació (Mokepon 3):
	 * l'objecte s'assegura de no néixer en un estat "absurd".
	 */
	public Atac(String nom, double poder, Tipus tipus, int moviments_maxims) {
		this.nom = nom;
		this.poder = poder;
		this.tipus = tipus;
		this.moviments_maxims = moviments_maxims;

		// Inicialment, els PP actuals són els màxims.
		this.moviments_actuals = this.moviments_maxims;

		// Comprovem que poder no sigui <10 o >100
		// (això evita atacs massa febles o massa forts)
		if (this.poder < 10 || this.poder > 100) {
			if (this.poder < 10) {
				this.poder = 10;
			} else {
				this.poder = 100;
			}
		}
	}

	/**
	 * Constructor "curt".
	 *
	 * Quan no volem especificar-ho tot, fixem valors per defecte: - poder = 10 -
	 * moviments_maxims = 10
	 *
	 * Això és sobrecàrrega de constructors: mateix nom, paràmetres diferents.
	 */
	public Atac(String nom, Tipus tipus) {
		this.nom = nom;
		this.poder = 10;
		this.tipus = tipus;
		this.moviments_maxims = 10;
		this.moviments_actuals = this.moviments_maxims;
	}

	@Override
	public boolean equals(Object obj) {
		// si els dos objectes son el mateix objecte torna true
		if (this == obj)
			return true;
		// si l'objecte passat es null torna false
		if (obj == null)
			return false;
		// si l'objecte passat es d'una classe diferent a atac torna false
		if (getClass() != obj.getClass())
			return false;
		// casteja l'objecte a atac
		Atac other = (Atac) obj;
		// compara tots els atributs d'aquest objecte amb els de l'altre objecte
		if (tipus == other.tipus && nom.equals(other.nom) && poder == other.poder
				&& moviments_actuals == other.moviments_actuals && moviments_maxims == other.moviments_maxims) {
			return true;
		} else {
			return false;
		}
	}

	public int compareTo(Object arg0) {
//castejo l'altre objecte a Atac
		Atac altre = (Atac) arg0;
//comparo per poder. si l'altre té més poder, soc mes petit
		if (altre.poder > this.poder) {
			return -1;
		} else if (this.poder > altre.poder) {
			return 1;
		} // si tenen el mateix poder comparem per nom
		else {// com que nom es una string i string te el seu propi compareTo, el podem fer
				// servir
			return this.nom.compareTo(altre.nom);
		}
	}

	@Override
	public String toString() {
		return "Atac [nom=" + nom + ", poder=" + poder + ", tipus=" + tipus + ", moviments_maxims=" + moviments_maxims
				+ ", moviments_actuals=" + moviments_actuals + "]";
	}

}