package overcooked;

public interface ConsumptionSubject {
	void registerConsumptionObserver(ConsumptionObserver observer);
	void removeConsumptionObserver(ConsumptionObserver observer);
	void notifyConsumptionObservers(Plat plat, boolean paid, double amount);
}
