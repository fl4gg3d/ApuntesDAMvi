package mokepon;

/**
 * Excepció pròpia MateixSexeException.
 *
 * Es llança quan es prova una reproducció entre dos Mokepons del mateix sexe.
 */

public class MateixSexeException extends Exception {

	public MateixSexeException(String message) {
		
		super(message);
	}
}
