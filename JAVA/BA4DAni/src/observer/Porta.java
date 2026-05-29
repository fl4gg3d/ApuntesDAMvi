package observer;

public class Porta implements EventObserver{

	@Override
	public void activarEvent() {
		System.out.println("La porta està oberta");
		
	}

	
}
