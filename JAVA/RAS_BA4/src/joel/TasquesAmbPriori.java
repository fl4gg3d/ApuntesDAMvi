package joel;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TasquesAmbPriori {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			int tareas = sc.nextInt();
			int posTarea = sc.nextInt(); 
			sc.nextLine();
			PriorityQueue<Integer> cua = new PriorityQueue<Integer>();
			HashMap<Integer, String> elementos = new HashMap<Integer, String>();
			for (int j = 0; j < tareas; j++) {
				int num = sc.nextInt();
				String tarea = sc.nextLine().trim();
				elementos.put(num, tarea);
				cua.add(num);
			}
			for (int j = 0; j < posTarea - 1; j++) {
				cua.poll();
			}
			System.out.println(elementos.get(cua.poll()));
		}
		
	}
}
