package iterator;

import java.util.ArrayList;
import java.util.ListIterator;

public class EstimatIterator {

	public static void main(String[] args) {

		ArrayList<String> llista = new ArrayList<String>();

		llista.add("Enrique");
		llista.add("Lovo listen to me");
		llista.add("Lovo no ta");
		llista.add("Marxo a Lleida");
		llista.add("Marxaré a Alemanya");
		llista.add("Pii dentista");
		llista.add("Eustaquio, el de las trompas");

//		for (String s : llista) {
//			
//			if(s.endsWith("a")) {
//				llista.remove(s);
//			}
//		}
		
//		for (Iterator iterator = llista.iterator(); iterator.hasNext();) {
//			String string = (String) iterator.next();
//			if (string.endsWith("a")) {
//				iterator.remove();
//			}
//		}
//		System.out.println(llista);
		
		for (ListIterator<String> iterator = llista.listIterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			System.out.println("Element actual: "+ string);
			iterator.previous();
			if(iterator.hasPrevious()) {
				iterator.previous();
				string = (String) iterator.next();
				System.out.println("Ellement previ: " + string);
			}else {
				System.out.println("No hi ha elememt anterior");
			}
			iterator.next();
			if(iterator.hasNext()) {
				string = (String) iterator.next();
				System.out.println("Element següent: " + string);
				iterator.previous();
			}else {
				System.out.println("No hi ha element següent");
			}
		}

	}
	
		

}
