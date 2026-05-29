package isaacSolucio;


public interface Subject {
	public void addObserver(Observer observer);
	public void notifyObservers();
}
