package mokepon;

import java.io.Serializable;

/**
 * Classe Mokepon
 *
 * Representa un Mokepon base del joc.
 *
 * En aquesta versió s'afegeixen especialment:
 * - sexe
 * - reproduccio()
 * - capturar() amb excepció pròpia
 * - equals(), hashCode() i compareTo()
 */

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

/**
 * Classe Mokepon
 *
 * Representa un Mokepon personatge jugable del joc.
 *
 * Conté atributs d'estat (nom, nivell, stats, vida...) i mètodes (accions): -
 * pujar de nivell - afegir atacs - atacar - curar / debilitar-se - capturar
 *
 * En aquesta tercera i quarta part del projecte apareix la idea d'encapsulació:
 * molts atributs són private i s'hi accedeix mitjançant getters i setters.
 *
 * A Mokepon4 s'han afegit setters d'atac i defensa per permetre que
 * l'equipament modifiqui temporalment aquestes estadístiques.
 */

public class Mokepon implements Comparable, Serializable {

	static Random rand = new Random();

	/**
	 * Exemple d'atribut estàtic.
	 *
	 * Un atribut static pertany a la classe i no a cada objecte concret.
	 */
	static String estatic;

	// =========================================================
	// ATRIBUTS D'ESTAT
	// =========================================================

	// Nom del mokepon
	String nom;

	// Nivell actual
	private int nivell;

	// Estadístiques bàsiques
	private int atk;
	private int def;
	private int vel;

	// Experiència acumulada
	private int exp;

	// Vida màxima i vida actual
	private int hp_max;
	private int hp_actual;

	// Tipus elemental (FOC / AIGUA / PLANTA)
	private Tipus tipus;

	// Llista d'atacs del mokepon
	// Relació de composició: un Mokepon "té" atacs
	private ArrayList<Atac> llista_atacs = new ArrayList<>();

	// Si està debilitat, no pot atacar fins que es curi
	private boolean debilitat = false;

	private Sexe sexe;

	// =========================================================
	// CONSTRUCTORS
	// =========================================================

	/**
	 * Constructor per defecte.
	 *
	 * Nota: Un constructor NO té tipus de retorn. Quan fem new Mokepon(), aquest
	 * codi inicialitza l'objecte.
	 */
	public Mokepon() {
		this.nom = "Sense definir";
		this.nivell = 1;
		this.atk = 1;
		this.def = 1;
		this.vel = 1;

		this.hp_max = 10;
		this.hp_actual = this.hp_max;
		this.sexe = determinarSexe();
	}

	/**
	 * Constructor amb nom.
	 *
	 * Nota: "this.nom" és l'atribut de l'objecte. "nom" és el paràmetre local
	 * rebut.
	 */
	public Mokepon(String nom) {
		this.nom = nom;
		this.nivell = 1;
		this.atk = 1;
		this.def = 1;
		this.vel = 1;

		this.hp_max = 10;
		this.hp_actual = this.hp_max;
		this.sexe = Sexe.FEMENI;
//		this.sexe = determinarSexe();

	}

	/**
	 * Constructor amb nom i nivell inicial.
	 *
	 * Crida primer al constructor Mokepon(String nom) amb this(nom) i després puja
	 * nivells fins arribar al nivell demanat.
	 *
	 * Nota: - this(...) només es pot cridar com a primera línia del constructor -
	 * és una manera de reutilitzar codi d'inicialització
	 */
	public Mokepon(String nom, int nivell) {
		this(nom);

		// pugem de nivell tants cops com calgui
		for (int i = 1; i < nivell; i++) {
			this.pujarNivell();
		}
	}

	/**
	 * Constructor complet (manual).
	 *
	 * Permet crear objectes ja configurats amb nivell, vida i estadístiques.
	 *
	 * Nota: Pot ser útil en tests o per crear mokepons especials.
	 */
	public Mokepon(String nom, int nivell, int hp_max, int atk, int def, int vel) {
		this.nom = nom;
		this.nivell = nivell;

		this.hp_max = hp_max;
		this.hp_actual = this.hp_max;

		this.atk = atk;
		this.def = def;
		this.vel = vel;
		this.sexe = determinarSexe();
	}

	/**
	 * Constructor amb nom i tipus.
	 *
	 * Inicialitza un mokepon amb un tipus elemental concret.
	 *
	 * Nota: independentment del constructor, l'objecte hauria de començar sempre en
	 * un estat coherent.
	 */
	public Mokepon(String nom, Tipus tipus) {
		this.nom = nom;
		this.nivell = 1;
		this.atk = 1;
		this.def = 1;
		this.vel = 1;
		this.tipus = tipus;

		this.hp_max = 10;
		this.hp_actual = this.hp_max;
		this.sexe = determinarSexe();
	}

	// =========================================================
	// GETTERS I SETTERS
	// =========================================================

	/**
	 * Retorna l'experiència acumulada.
	 */
	public int getExp() {
		return exp;
	}

	/**
	 * Modifica l'experiència acumulada.
	 */
	public void setExp(int exp) {
		this.exp = exp;
	}

	/**
	 * Retorna la vida actual.
	 */
	public int getHp_actual() {
		return hp_actual;
	}

	/**
	 * Modifica la vida actual.
	 *
	 * Validació: - si és menor que 0, queda a 0 - si supera hp_max, queda a hp_max
	 */
	public void setHp_actual(int hp_actual) {
		this.hp_actual = hp_actual;
		if (this.hp_actual < 0) {
			this.hp_actual = 0;
		}
		if (this.hp_actual > this.hp_max) {
			this.hp_actual = this.hp_max;
		}
	}

	/**
	 * Retorna el tipus elemental.
	 */
	public Tipus getTipus() {
		return tipus;
	}

	/**
	 * Modifica el tipus elemental.
	 */
	public void setTipus(Tipus tipus) {
		this.tipus = tipus;
	}

	/**
	 * Retorna la llista d'atacs del Mokepon.
	 */
	public ArrayList<Atac> getLlista_atacs() {
		return llista_atacs;
	}

	/**
	 * Substitueix la llista d'atacs per una altra.
	 */
	public void setLlista_atacs(ArrayList<Atac> llista_atacs) {
		this.llista_atacs = llista_atacs;
	}

	/**
	 * Retorna el nom del Mokepon.
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retorna el nivell actual.
	 */
	public int getNivell() {
		return nivell;
	}

	/**
	 * Retorna l'atac actual.
	 */
	public int getAtk() {
		return atk;
	}

	/**
	 * Modifica l'atac actual.
	 *
	 * Aquest setter és especialment útil a Mokepon4, perquè les armes poden
	 * augmentar o reduir temporalment l'atac.
	 */
	public void setAtk(int atk) {
		this.atk = atk;
	}

	/**
	 * Retorna la defensa actual.
	 */
	public int getDef() {
		return def;
	}

	/**
	 * Modifica la defensa actual.
	 *
	 * Aquest setter és necessari perquè les armadures puguin modificar temporalment
	 * la defensa.
	 */
	public void setDef(int def) {
		this.def = def;
	}

	/**
	 * Retorna la velocitat actual.
	 */
	public int getVel() {
		return vel;
	}

	/**
	 * Retorna la vida màxima.
	 */
	public int getHp_max() {
		return hp_max;
	}

	/**
	 * Indica si el Mokepon està debilitat.
	 */
	public boolean isDebilitat() {
		return debilitat;
	}

	/**
	 * Modifica manualment l'estat de debilitat.
	 */
	public void setDebilitat(boolean debilitat) {
		this.debilitat = debilitat;
	}

	// =========================================================
	// MÈTODES BÀSICS
	// =========================================================

	/**
	 * Mostra el nom del mokepon per pantalla.
	 */
	public void diguesNom() {
		System.out.println(this.nom);
	}

	/**
	 * Afegeix experiència al mokepon.
	 *
	 * Si arriba a 100 o més, puja un nivell i conserva la resta d'experiència.
	 *
	 * Nota: En aquesta versió, una sola crida només pot provocar una pujada de
	 * nivell.
	 */
	public void atorgarExperiencia(int exp_atorgada) {
		this.exp += exp_atorgada;

		if (this.exp >= 100) {
			this.exp -= 100;
			this.pujarNivell();
		}
	}

	/**
	 * Incrementa el nivell i millora les estadístiques amb valors aleatoris.
	 *
	 * Nota: - Random dona una mica de variabilitat a la pujada - r.nextInt(0, 6)
	 * retorna valors entre 0 i 5
	 */
	private void pujarNivell() {
		Random r = new Random();

		this.nivell++;
		this.hp_max += r.nextInt(0, 6);
		this.atk += r.nextInt(0, 3);
		this.def += r.nextInt(0, 3);
		this.vel += r.nextInt(0, 3);
	}

	/**
	 * Afegeix un atac a la llista si encara no té el màxim permès.
	 *
	 * Nota: La restricció de "màxim 2 atacs" es controla dins de la classe. Això fa
	 * que la regla del joc formi part del model i no depengui d'un control extern.
	 */
	public void afegirAtac(Atac at) {
		if (this.llista_atacs.size() < 2) {
			this.llista_atacs.add(at);
		}
	}

	/**
	 * Marca el mokepon com a debilitat.
	 *
	 * Quan està debilitat, no pot atacar fins que es curi.
	 */
	public void debilitarse() {
		this.debilitat = true;
	}

	/**
	 * Cura el mokepon si està debilitat.
	 *
	 * Recupera tota la vida i elimina l'estat de debilitat.
	 */
	public void curar() {
		if (this.debilitat) {
			this.debilitat = false;
			this.hp_actual = this.hp_max;
		}
	}

	/**
	 * Calcula l'efectivitat d'un atac segons el tipus de l'atac i el del defensor.
	 *
	 * Retorna: - 0.5 si és poc efectiu - 2.0 si és molt efectiu - 1.0 si és neutre
	 *
	 * Nota: És un mètode static perquè representa una regla general del joc i no
	 * depèn d'un objecte concret.
	 */
	public static double efectivitat(Tipus atac, Tipus defensa) {
		if (atac == Tipus.FOC && defensa == Tipus.AIGUA || atac == Tipus.AIGUA && defensa == Tipus.PLANTA
				|| atac == Tipus.PLANTA && defensa == Tipus.FOC) {
			return 0.5;
		} else if (atac == Tipus.AIGUA && defensa == Tipus.FOC || atac == Tipus.FOC && defensa == Tipus.PLANTA
				|| atac == Tipus.PLANTA && defensa == Tipus.AIGUA) {
			return 2;
		} else {
			return 1;
		}
	}

	/**
	 * Realitza un atac sobre un altre Mokepon.
	 *
	 * Per poder atacar: - el mokepon no ha d'estar debilitat - l'atac seleccionat
	 * ha de tenir PP disponibles
	 *
	 * Efectes del mètode: - l'atacant gasta 1 PP - el defensor perd HP - si el
	 * defensor cau a 0 o menys, queda debilitat
	 *
	 * Nota: Aquest és un bon exemple d'interacció entre objectes. El mètode
	 * modifica tant l'atacant com l'atacat.
	 */
	public void atacar(Mokepon atacat, int num_atac) {

		// Condició per poder atacar:
		// - no estar debilitat
		// - l'atac triat té PP
		if (!debilitat && this.llista_atacs.get(num_atac).moviments_actuals > 0) {

			// Fórmula de dany:
			// depèn del nivell, poder de l'atac, atac de l'atacant,
			// defensa del defensor i efectivitat del tipus
			int damage = (int) (((2 * this.nivell / 5 + 2) * this.llista_atacs.get(num_atac).poder * this.atk
					/ atacat.def / 50 + 2) * efectivitat(this.llista_atacs.get(num_atac).tipus, atacat.tipus));

			// Consumim 1 PP
			this.llista_atacs.get(num_atac).moviments_actuals--;

			// Restem vida a l'objecte atacat
			atacat.hp_actual -= damage;

			// Si cau a 0 o menys, queda debilitat
			if (atacat.hp_actual <= 0) {
				atacat.debilitarse();
			}
		}
	}

	/**
	 * Captura aquest mokepon i retorna un MokeponCapturat.
	 *
	 * Si l'objecte actual NO és ja un MokeponCapturat, es crea un nou objecte
	 * capturat a partir del propi Mokepon.
	 *
	 * Si ja està capturat, no es pot tornar a capturar i es retorna el mateix
	 * objecte, fent cast.
	 *
	 * Nota: - instanceof comprova el tipus real de l'objecte - el cast és segur a
	 * l'else perquè abans ja hem comprovat el tipus
	 */
	public MokeponCapturat capturar(String nomEntrenador, String nomDonat) throws MokeponJaCapturatException {

		// si nosaltres mateixos no som de classe MokeponCapturat
		if (!(this instanceof MokeponCapturat)) {
			// creem un nou MokeponCapturat a partir del propi objecte
			return new MokeponCapturat(this, nomDonat, nomEntrenador);
		} else {
			// El mokepon ja està capturat. No el pots tornar.
			System.out.println("No pots capturar un Mokepon que ja esta capturat");

			// podem castejar perquè estem segurs que és un MokeponCapturat
			// gràcies al instanceof
			throw new MokeponJaCapturatException("Aquest Mokepon ja l'has capturat abans");
		}
	}

	private Sexe determinarSexe() {
		int num = rand.nextInt(0, 2);
		if (num == 1) {
			return Sexe.FEMENI;
		} else {
			return Sexe.MASCULI;
		}
	}

//	public Ou reproduccio(Mokepon altreMokepon) throws Exception {
//
//		if (this.tipus != altreMokepon.tipus) {
//
//			// hauria de tornar un error perquè són de diferent tipus
//			throw new TipusDiferentException("Error, son de diferent tipus");
//		} else if (this.sexe == altreMokepon.sexe) {
//			throw new MateixSexeException("Error, son del mateix sexe");
//		} else if (this.isDebilitat() || altreMokepon.isDebilitat()) {
//			throw new DebilitatException("Error, cap dels dos Mokepon pot estar debilitat");
//		} else {
//
//			if (rand.nextInt(0, 2) == 1) {
//				return new Ou(this.nom, this.tipus);
//			} else {
//				return new Ou(altreMokepon.nom, this.tipus);
//			}
//		}
//	}
	
	public Ou reproduccio(Mokepon altreMokepon) throws Exception {

		assert this.tipus == altreMokepon.tipus : "Error, son de diferent tipus";
		assert this.sexe != altreMokepon.sexe : "Error, son del mateix sexe";
		assert !this.isDebilitat() && !altreMokepon.isDebilitat() : "Error, cap dels dos Mokepon pot estar debilitat";
		
		if (rand.nextInt(0, 2) == 1) {
			return new Ou(this.nom, this.tipus);
		} else {
			return new Ou(altreMokepon.nom, this.tipus);
		}
		
	}

//	@Override
//	public int hashCode() {
//		return Objects.hash(atk, def, exp, hp_max, llista_atacs, nivell, nom, sexe, tipus, vel);
//	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Mokepon other = (Mokepon) obj;
//		return atk == other.atk && def == other.def && exp == other.exp && hp_max == other.hp_max
//				&& Objects.equals(llista_atacs, other.llista_atacs) && nivell == other.nivell
//				&& Objects.equals(nom, other.nom) && sexe == other.sexe && tipus == other.tipus && vel == other.vel;
//	}
//	
	

	
	
	@Override
	public int compareTo(Object o) {
		// castejo l'altre objecte a Mokepon
		Mokepon altre = (Mokepon) o;

		// comparo per tipus. Si l'altre té un tipus anterior a la llista sóc més petit
		if (altre.tipus.ordinal() > (this.tipus.ordinal())) {
			return -1;

		} else if (this.tipus.ordinal() > (altre.tipus.ordinal())) {

			return 1;

		} // si tenen el mateix tipus comparem per nom
		else if (this.nom.compareTo(altre.nom) < 0) { // Retorna Negatiu si és més petit, 0 si són iguals

			return -1;
		} else if (this.nom.compareTo(altre.nom) > 0) { // Retorna Positiu si és més gran, 0 si són iguals

			return 1;
		}

		else if (this.nivell < altre.nivell) {

			return -1;
		} else if (this.nivell > altre.nivell) {
			return 1;
		}
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(atk, def, exp, hp_max, nivell, nom, sexe, tipus, vel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mokepon other = (Mokepon) obj;
		return atk == other.atk && def == other.def && exp == other.exp && hp_max == other.hp_max
				&& nivell == other.nivell && Objects.equals(nom, other.nom) && sexe == other.sexe
				&& tipus == other.tipus && vel == other.vel;
	}

	/**
	 * Retorna una representació textual de l'objecte.
	 */
	@Override
	public String toString() {
		return "Mokepon [nom=" + nom + ", nivell=" + nivell + ", atk=" + atk + ", def=" + def + ", vel=" + vel
				+ ", exp=" + exp + ", hp_max=" + hp_max + ", hp_actual=" + hp_actual + ", tipus=" + tipus
				+ ", llista_atacs=" + llista_atacs + ", debilitat=" + debilitat + "]";
	}

}
