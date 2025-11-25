package ExamenBucles;

import java.util.Scanner;

public class ParellsSenarsMagia {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int nums = 0;
		int parells = 0;
		int senars = 0;
		boolean magia = false;
		
		
		while(nums >= 0) {
			nums = sc.nextInt();
			
			if(nums != -1) {
				if(nums % 2 == 0) {
					parells += nums;
				}
				else if (nums % 2 != 0) {
					senars += nums;
				}
				
				if(nums == 73) {
					magia = true;
				}
			}	
			
		}
		if(magia == true) {
			System.out.println("MAGIA");
		}
		else if(parells > senars) {
			System.out.println("PARELLS");
		}
		else if(parells < senars) {
			System.out.println("SENARS");
		}
		
	}	
	
	
	

}
