package overcooked;

public interface OrderSubject {
	void registerOrderObserver(OrderObserver observer);
	void removeOrderObserver(OrderObserver observer);
	void notifyOrderObservers(Plat plat);
}
