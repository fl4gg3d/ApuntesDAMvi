package isaacSolucio;

import java.util.ArrayList;
import java.util.List;

public abstract class Enemic implements Subject {
    int hp;
    int punts;

    private List<Observer> observers = new ArrayList<>();

    public Enemic(int hp, int punts) {
        super();
        this.hp = hp;
        this.punts = punts;
    }

    public abstract void danyar(int dany);

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(this.punts);
        }
    }

    @Override
    public String toString() {
        return "[hp=" + hp + ", punts=" + punts + "]";
    }
}
