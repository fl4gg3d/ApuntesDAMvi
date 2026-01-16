package ExamenProbaMatDicc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ClassesPlenesDeTerroristes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<String, Integer> Classes = new HashMap<String, Integer>();
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			String clase = sc.next();
			int Numero = sc.nextInt();
			
			Classes.put(clase, 0);
			
		}
		
		System.out.println(Classes);
		
	}

}
