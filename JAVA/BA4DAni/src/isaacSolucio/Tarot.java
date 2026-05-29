package isaacSolucio;

import java.util.ArrayDeque;

public class Tarot extends ArrayDeque<String>{

	private static final long serialVersionUID = 1L;
	private static int mida=3;
	
	@Override
	public boolean add(String tarot) {
		if(size()>=mida) {
			System.out.println("Pila plena, canviem "+pop()+" per "+tarot);
		}
		push(tarot);
		return true;
	}
	
	public void use() {
		if(!isEmpty()) {
			String carta=peek();
			if(carta.endsWith("?")) {
				System.out.println("Isaac Utilitza "+pop());
			}
			if(carta.contains("-")) {
				System.out.println("Isaac Utilitza "+carta);
			}
		}
		
	}

}
