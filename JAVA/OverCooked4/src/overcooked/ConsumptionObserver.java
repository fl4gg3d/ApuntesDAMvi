package overcooked;

public interface ConsumptionObserver {
	void updateConsumption(Plat plat, String clientName, boolean paid, double amount);
}
