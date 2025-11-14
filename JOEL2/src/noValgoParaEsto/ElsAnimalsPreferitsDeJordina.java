package noValgoParaEsto;

import java.util.*;

public class ElsAnimalsPreferitsDeJordina {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int casos = sc.nextInt();
        sc.nextLine(); //
        for (int i = 0; i < casos; i++) {
            int k = sc.nextInt();
            sc.nextLine();

            String[] animals = new String[k - 1];
            for (int j = 0; j < k - 1; j++) {
                animals[j] = sc.nextLine();
            }

            String buscar = sc.nextLine();
            boolean encontrado = false;

            for (int j = 0; j < animals.length; j++) {
                if (animals[j].equals(buscar)) {
                    encontrado = true;
                }
            }

            if (encontrado) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}

