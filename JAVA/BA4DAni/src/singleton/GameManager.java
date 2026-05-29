package singleton;

public class GameManager {

	private boolean isPaused;
	private int score;
	private int level;
	
	private static GameManager instance = null;
	
	private GameManager() {
		this.isPaused = false;
		this.score = 0;
		this.level = 1;
	}
	
	public static GameManager getInstance() {
		
		if(instance == null) {
			instance = new GameManager();
		}
		
		return instance;
	}
	
	public void pauseGame () {
		
		this.isPaused = true;
	
	}
	
	public void resumeGame () {
		
		this.isPaused = false;
		
	}
	
	public void addScore (int points) {
		
		this.score += points;
	}
	
	public void nextLevel () {
		this.level++;
	}
	
	public int getScore() {
		
		return score;
	}
	
	public boolean isPaused() {
		return isPaused;
	}
	
	public int getLevel() {
		
		return level;
	}
}
