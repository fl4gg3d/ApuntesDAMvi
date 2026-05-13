package mokepon;

import java.io.Serializable;

/**
 * Classe MokeponCapturat
 *
 * Representa un Mokepon que ja ha estat capturat.
 *
 * Hereta de Mokepon i afegeix informació pròpia de captura.
 * En Mokepon 5 també redefineix equals() i hashCode().
 */

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe MokeponCapturat
 *
 * Representa un Mokepon que ja ha estat capturat per un entrenador.
 *
 * Hereta de Mokepon, així que reutilitza tots els atributs i mètodes del pare,
 * però hi afegeix informació nova:
 * - nomPosat
 * - nomEntrenador
 * - felicitat
 *
 * A Mokepon4 s'afegeixen també atributs relacionats amb els objectes:
 * - objecte → objecte que té a l'inventari
 * - objecteEquipat → equipament que porta posat actualment
 *
 * També sobreescriu atacar() perquè el dany depengui de la felicitat.
 */
public class MokeponCapturat extends Mokepon implements Serializable {

	/**
	 * Comptador global de Mokepons capturats.
	 *
	 * En ser static, pertany a la classe i no a cada objecte per separat.
	 */
	static int NombreMokeponsCapturats;

	// =========================================================
	// ATRIBUTS NOUS
	// =========================================================

	// Nom que li ha posat l'entrenador
	String nomPosat;

	// Nom de l'entrenador propietari
	private String nomEntrenador;

	// Nivell de felicitat del mokepon capturat
	private int felicitat;

	// Objecte que el Mokepon té guardat
	private Objecte objecte;

	// Equipament que porta posat actualment
	private Equipament objecteEquipat;

	// =========================================================
	// CONSTRUCTORS
	// =========================================================

	/**
	 * Constructor buit.
	 *
	 * super() crida el constructor buit del pare.
	 */
	public MokeponCapturat() {
		super();
		this.nomPosat = this.nom;
		this.nomEntrenador = "Dani";
		this.felicitat = 50;
		NombreMokeponsCapturats++;
	}

	/**
	 * Constructor amb nom.
	 *
	 * Nota: reutilitza el constructor del pare amb super(nom).
	 */
	public MokeponCapturat(String nom) {
		super(nom);
		this.nomPosat = this.nom;
		this.nomEntrenador = "Dani";
		this.felicitat = 50;
		NombreMokeponsCapturats++;
	}

	/**
	 * Constructor amb nom i nivell.
	 */
	public MokeponCapturat(String nom, int nivell) {
		super(nom, nivell);
		this.nomPosat = this.nom;
		this.nomEntrenador = "Dani";
		this.felicitat = 50;
		NombreMokeponsCapturats++;
	}

	/**
	 * Constructor complet.
	 *
	 * Pot ser útil per fer proves o crear objectes ja configurats.
	 */
	public MokeponCapturat(String nom, int nivell, int hp_max, int atk, int def, int vel) {
		super(nom, nivell, hp_max, atk, def, vel);
		this.nomPosat = this.nom;
		this.nomEntrenador = "Dani";
		this.felicitat = 50;
		NombreMokeponsCapturats++;
	}

	/**
	 * Constructor amb nom i tipus.
	 *
	 * Reutilitza el constructor equivalent del pare i després afegeix la informació
	 * pròpia de MokeponCapturat.
	 */
	public MokeponCapturat(String nom, Tipus tipus) {
		// cridem al constructor idèntic del pare
		super(nom, tipus);

		// la resta de variables les posem nosaltres
		this.nomPosat = nom;
		this.nomEntrenador = "Dani";
		this.felicitat = 50;
		NombreMokeponsCapturats++;
	}

	/**
	 * Constructor a partir d'un Mokepon existent.
	 *
	 * Crea un nou MokeponCapturat copiant l'estat rellevant d'un Mokepon base i
	 * afegint el nom posat i el nom de l'entrenador.
	 *
	 * Nota:
	 * - super(...) copia part de l'estat bàsic
	 * - després copiem manualment alguns atributs que el constructor del pare no manté exactament igual
	 * - la llista d'atacs es copia en una llista nova per no compartir referències
	 */
	public MokeponCapturat(Mokepon mok, String nomPosat, String nomEntrenador) {
		super(mok.nom, mok.getNivell(), mok.getHp_max(), mok.getAtk(), mok.getDef(), mok.getVel());

		NombreMokeponsCapturats++;
		this.nomPosat = nomPosat;
		this.nomEntrenador = nomEntrenador;
		this.felicitat = 50;

		// afegim també els atributs que super(...) no copia exactament
		this.setHp_actual(mok.getHp_actual());
		this.setExp(mok.getExp());
		this.setDebilitat(mok.isDebilitat());
		this.setTipus(mok.getTipus());

		// còpia de la llista d'atacs
		// Nota: fem una ArrayList nova perquè el capturat no comparteixi la mateixa
		// llista amb el mokepon original
		this.setLlista_atacs(new ArrayList<>());

		for (Atac atacOriginal : mok.getLlista_atacs()) {
			Atac atacCopia = new Atac(atacOriginal.nom, atacOriginal.poder, atacOriginal.tipus,
					atacOriginal.moviments_maxims);

			// mantenim també els PP actuals
			atacCopia.moviments_actuals = atacOriginal.moviments_actuals;

			this.getLlista_atacs().add(atacCopia);
		}
	}

	/**
	 * Retorna l'objecte que té guardat.
	 */
	public Objecte getObjecte() {
		return objecte;
	}

	/**
	 * Modifica l'objecte que té guardat.
	 */
	public void setObjecte(Objecte objecte) {
		this.objecte = objecte;
	}

	/**
	 * Retorna l'equipament actualment equipat.
	 */
	public Equipament getObjecteEquipat() {
		return objecteEquipat;
	}

	/**
	 * Modifica l'equipament actualment equipat.
	 */
	public void setObjecteEquipat(Equipament objecteEquipat) {
		this.objecteEquipat = objecteEquipat;
	}
	
	public String getNomEntrenador() {
		return nomEntrenador;
	}
	

	public void setNomEntrenador(String nomEntrenador) {
		this.nomEntrenador = nomEntrenador;
	}
	
	public String getNomPosat() {
		return nomPosat;
	}


	// =========================================================
	// MÈTODES PROPIS / SOBREESCRITS
	// =========================================================



	/**
	 * Augmenta la felicitat en 10 punts fins a un màxim de 100.
	 *
	 * Nota: aquest mètode només existeix a MokeponCapturat.
	 * Un Mokepon normal no el pot fer servir.
	 */
	public void acariciar() {
		if (this.felicitat < 100) {
			this.felicitat += 10;
		}

		// per seguretat, controlem que no pugui superar 100
		if (this.felicitat > 100) {
			this.felicitat = 100;
		}
	}

	/**
	 * Sobreescriptura del mètode atacar().
	 *
	 * Funciona de manera semblant al del pare, però el dany final depèn també de la
	 * felicitat:
	 * - si felicitat >= 50, el dany es multiplica per 1.2
	 * - si felicitat < 50, el dany es multiplica per 0.8
	 *
	 * Nota:
	 * - es reutilitza super.efectivitat(...) per no duplicar aquest càlcul
	 * - això és un exemple clar d'override + herència + polimorfisme
	 */
	@Override
	public void atacar(Mokepon atacat, int num_atac) {

		// Condició per poder atacar:
		// - no estar debilitat
		// - l'atac triat té PP
		if (!isDebilitat() && this.getLlista_atacs().get(num_atac).moviments_actuals > 0) {

			// Fórmula de dany base
			int damage = (int) (((2 * this.getNivell() / 5 + 2)
					* this.getLlista_atacs().get(num_atac).poder
					* this.getAtk()
					/ atacat.getDef()
					/ 50 + 2)
					* super.efectivitat(this.getLlista_atacs().get(num_atac).tipus, atacat.getTipus()));

			// Modificador extra segons la felicitat
			if (this.felicitat >= 50) {
				damage *= 1.2;
			} else {
				damage *= 0.8;
			}

			// Consumim 1 PP
			this.getLlista_atacs().get(num_atac).moviments_actuals--;

			// Restem vida a l'objecte atacat
			atacat.setHp_actual(atacat.getHp_actual()-damage);

			// Si cau a 0 o menys, queda debilitat
			if (atacat.getHp_actual() <= 0) {
				atacat.debilitarse();
			}
		}
	}
	
	/**
	 * Utilitza l'objecte que el Mokepon té guardat.
	 *
	 * A Mokepon4 això permet aplicar polimòrficament el comportament de:
	 * - una Pocio
	 * - un Reviure
	 * - una Arma
	 * - una Armadura
	 */
	public void utilitzarObjecte() {
		this.objecte.utilitzar(this);
	}

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(nomEntrenador, nomPosat);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MokeponCapturat other = (MokeponCapturat) obj;
		return super.equals(obj) && Objects.equals(nomEntrenador, other.nomEntrenador)
				&& Objects.equals(nomPosat, other.nomPosat);
	}

	/**
	 * Retorna una representació textual del capturat.
	 */
	
	@Override
	public String toString() {
	    return "MokeponCapturat {" +
	            super.toString() +
	            ", nomPosat=" + nomPosat +
	            ", nomEntrenador=" + nomEntrenador +
	            ", felicitat=" + felicitat +
	            "}";
	}
	
		
}
