package pilesCues;

import java.util.ArrayList;

public class MeuaCueta<T> extends ArrayList<T> {

	public void push(T a) {
		super.add(a); //push posa l'element al final de la cua
	}
	
	public T pop () {
		return super.remove(0);	 // el pop fa el remove del primer element de la cua	
	}
	//impedim que es pugui afegir elements en qualsevol posició, fem override del add(posicio, element)
	public void add (int a, T b) {
		throw new UnsupportedOperationException();
	}
	
}
