package overcooked2;

import java.util.ArrayDeque;

public class Comandes extends ArrayDeque<Plat>{
	@Override
	public boolean add(Plat plat) {
		System.out.println(plat+" s'afegeix a la cua de comandes");
		addLast(plat);
		return true;
	}
	
	public Plat use() {
		if(isEmpty()) {
			System.out.println("Cua de comandes buida");
			return null;
		} else {
			return poll();
		}
	}

}
