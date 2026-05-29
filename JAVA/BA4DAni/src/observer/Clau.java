package observer;

import java.util.ArrayList;

public class Clau {

	ArrayList<EventObserver> observers = new ArrayList<EventObserver>();

	public void subscribe(EventObserver o) {

		observers.add(o);
	}

	public void unsubscribe(EventObserver o) {

		observers.remove(o);
	}
	
	public void activate() {
		
		for (EventObserver o : observers) {
			
			o.activarEvent();
		}
	}
	
	public void agafarClau() {
		activate();
	}
}
