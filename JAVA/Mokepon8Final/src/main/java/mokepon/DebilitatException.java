package mokepon;

/**
 * Excepció pròpia DebilitatException.
 *
 * Es fa servir quan una acció no és vàlida perquè algun Mokepon està debilitat.
 */

public class DebilitatException extends Exception {
	
	public DebilitatException(String message) {
	
		super(message);
	}
}
