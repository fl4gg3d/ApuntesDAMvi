package noValgoParaEsto;

import java.util.ArrayList;
import java.util.Scanner;

public class Frequencia {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			ArrayList<Integer> llistaInts = new ArrayList<>();
			int comp0 = 0;
			int comp1 = 0;
			int comp2 = 0;
			int comp3 = 0;
			int comp4 = 0;
			int comp5 = 0;
			int comp6 = 0;
			int comp7 = 0;
			int comp8 = 0;
			int comp9 = 0;
			int llistaT = sc.nextInt();
			for (int j = 0; j < llistaT; j++) {
				int nums = sc.nextInt();
				llistaInts.add(nums);
			} 
			
			for (int k = 0; k < llistaInts.size(); k++) {
				if(llistaInts.get(k) == 0) {
					comp0++;
				}
				if(llistaInts.get(k) == 1) {
					comp1++;
				}
				if(llistaInts.get(k) == 2) {
					comp2++;
				}
				if(llistaInts.get(k) == 3) {
					comp3++;
				}
				if(llistaInts.get(k) == 4) {
					comp4++;
				}
				if(llistaInts.get(k) == 5) {
					comp5++;
				}
				if(llistaInts.get(k) == 6) {
					comp6++;
				}
				if(llistaInts.get(k) == 7) {
					comp7++;
				}
				if(llistaInts.get(k) == 8) {
					comp8++;
				}
				if(llistaInts.get(k) == 9) {
					comp9++;
				}
			}
		
			System.out.println(comp0 +" "+ comp1 +" "+ comp2 +" "+ comp3 +" "+ comp4 +" "+ comp5 +" "+ comp6 +" "+ comp7 +" "+ comp8 +" "+comp9);
		}

	}

}
