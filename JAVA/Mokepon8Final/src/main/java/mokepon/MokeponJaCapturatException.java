package mokepon;

/**
 * Excepció pròpia MokeponJaCapturatException.
 *
 * Es llança quan s'intenta capturar un Mokepon que ja estava capturat.
 */

public class MokeponJaCapturatException extends Exception {

	MokeponJaCapturatException(String message){
		
		super(message);
	}
}
