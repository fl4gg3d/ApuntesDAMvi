package pilesCues;

import java.util.ArrayList;

public class MeuaPilita<T> extends ArrayList<T>{
	
	public void push(T a) {
		super.add(0, a); //fem que el push afegeixi al principi de la cua
 	}

	public T pop() {
		return super.remove(0); //pop treu el primer element, per tant, l'últim afegit			
	}
	
	public void add (int a, T b) { // impedim que add ens permeti afegir allà on vulguem
		
		throw new UnsupportedOperationException();
		
	}
}
