package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class TotsDiferents2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			boolean sonDiferentes = false;
			ArrayList<Integer> nums1 = new ArrayList<Integer>();
			int llargsLlista = sc.nextInt();
			ArrayList<Integer> nums2 = new ArrayList<Integer>();
			for (int j = 0; j < llargsLlista; j++) {
				nums2.add(sc.nextInt());
			}
			for (int j = 0; j < llargsLlista; j++) {
				nums1.add(sc.nextInt());
			}
			//Forma 1 de recorrer las listas y compararlas 
			//for(int j = 0; j < llargsLlista; j++) {
				//if(nums1.contains(nums2.get(j))) {
					//sonDiferentes = true;
				//}
			//}
			//Forma 2
			nums1.retainAll(nums2);
			
			if(nums1.isEmpty()) {
				System.out.println("NO");
			} else {
				System.out.println("SI");
			}
		}
	}
}
