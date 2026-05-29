package singleton;

public class MainSingleton {

	public static void main(String[] args) {
		
		GameManager gm = GameManager.getInstance();

		gm.addScore(25);
		gm.pauseGame();
		
		GameManager gm2 = GameManager.getInstance();
		
		
		gm2.addScore(100);
		gm2.nextLevel();
		gm2.resumeGame();
		
		System.out.println("La Partida està pausada " + gm.isPaused());
		System.out.println("Tinc " + gm.getScore() + " punts");
		System.out.println("Estic al nivell " + gm.getLevel());
		
		System.out.println(gm == gm2);
	}

}
