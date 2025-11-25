package noValgoParaEsto;

import java.util.Scanner;

public class UnLalafelSeBalanceabaSobreLaTelaDeUnaAranya {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int casos = sc.nextInt();
		
		for (int i = 0; i < casos; i++) {
			
			int Telaranya = 0;
			
			int Lalafel = 0;
			
			boolean Aranya = false;
			
			String Bicho = sc.nextLine();
			
			int capacidad = sc.nextInt();
			
			String[] bichicoSplit = Bicho.split(", ");
			
			for (int j = 0; j < bichicoSplit.length; j++) {
				
				if(bichicoSplit.equals("Lalafel") && Aranya == false && Telaranya <= capacidad) {
					Lalafel++;
				}
				
			}			
		}
		
	}

}
