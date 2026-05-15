package mokepon;

/**
 * Interfície Equipament
 *
 * Defineix el comportament dels objectes que es poden equipar.
 *
 * Classes que la implementen en aquest projecte:
 * - Arma
 * - Armadura
 *
 * Nota:
 * Una interfície no guarda estat com una classe normal, sinó que defineix
 * un "contracte" de mètodes que les classes han de complir.
 */
public interface Equipament {

	/**
	 * Equipa l'objecte a un MokeponCapturat.
	 */
	public abstract void Equipar(MokeponCapturat mok);
	
	/**
	 * Desequipa l'objecte d'un MokeponCapturat.
	 */
	public abstract void Desequipar(MokeponCapturat mok);
	
	/**
	 * Mètode default: comprova si el Mokepon pot equipar un objecte.
	 *
	 * Només el pot equipar si:
	 * - no està debilitat
	 * - no té res equipat actualment
	 *
	 * Nota:
	 * Els mètodes default permeten compartir codi dins una interfície.
	 */
	public default boolean potEquipar(MokeponCapturat mok) {
		
		return(!mok.isDebilitat() && mok.getObjecteEquipat()==null);
	}
	
	/**
	 * Mètode default: comprova si a l'atribut objecte del Mokepon hi ha
	 * un objecte que també és equipament.
	 *
	 * Això pot servir per detectar si li han donat un equipament com a objecte.
	 */
	default boolean equipMalPosat(MokeponCapturat mok) {
		return (mok.getObjecte() instanceof Equipament);
	}
}
