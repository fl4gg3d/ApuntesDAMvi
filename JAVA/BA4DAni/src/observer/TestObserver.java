package observer;

public class TestObserver {

	public static void main(String[] args) {
		
		Clau c = new Clau();
		//Clau c2 = new Clau();
		Porta p = new Porta();
		Enemic e = new Enemic();
		So s = new So();
		
		c.subscribe(p);
		c.subscribe(e);
		//c.subscribe(p);
		//c.unsubscribe(e);
		c.subscribe(s);
		c.agafarClau();
		
	}
	

	
}
