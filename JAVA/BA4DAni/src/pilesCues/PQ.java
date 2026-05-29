package pilesCues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PQ {

	public static void main(String[] args) {

		// PriorityQueue actua com una cua , però li podem indicar quina és la prioritat
		// a l'hora de treure elements

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		pq.add(4); //afegim element a la cua normalment amb add
		pq.add(33);
		pq.add(369);
		pq.add(1);
		pq.add(49);
		pq.add(88);

		System.out.println(pq); // si printem la cua NO surt ordenada de cap manera
		
		System.out.println("cua ascendent");
		System.out.println(pq.poll()); // però quan fem poll els elements van apareixen en ordre ascendent
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		
		//si volem un ordre descendent podem crear un comparador propi que inverteixi l'ordre (MeuComparador)
		// en aquest cas tenim una altra opció que és fer un reverse al Coomparator directament

		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(new MeuComparador()); // opció 1

//		PriorityQueue<Integer> pq2 = new PriorityQueue<Integer>(Comparator.reverseOrder()); // opció 2
		
		pq2.add(4);
		pq2.add(33);
		pq2.add(369);
		pq2.add(1);
		pq2.add(49);
		pq2.add(88);
		
		System.out.println("cua descendent");
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		System.out.println(pq2.poll());
		
	}

}

class MeuComparador implements Comparator<Integer> {

	// recordem que torna un nombre negatiu si el 1r nombre és més petit que el 2n
	// torna 0 si són iguals
	// torna un nombre positiu si el 1r és més gran que el 2n

	public int compare(Integer o1, Integer o2) {

		return o2 - o1; // canviem l'ordre de la resta del return (en comptes de o1 - o2)
	}
}
