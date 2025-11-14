package noValgoParaEsto;

import java.util.Scanner;

public class escalaReial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int casos = sc.nextInt();

        for (int c = 0; c < casos; c++) {
            int cartes[] = new int[7];
            for (int i = 0; i < 7; i++) {
                cartes[i] = sc.nextInt();
            }

    
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6 - i; j++) {
                    if (cartes[j] > cartes[j + 1]) {
                        int temp = cartes[j];
                        cartes[j] = cartes[j + 1];
                        cartes[j + 1] = temp;
                    }
                }
            }

            int[] unicas = new int[7];
            int count = 0;
            for (int i = 0; i < 7; i++) {
                if (i == 0 || cartes[i] != cartes[i - 1]) {
                    unicas[count] = cartes[i];
                    count++;
                }
            }

           
            boolean escala = false;
            int consecutivas = 1;

            for (int i = 1; i < count; i++) {
                if (unicas[i] == unicas[i - 1] + 1) {
                    consecutivas++;
                    if (consecutivas >= 5) {
                        escala = true;
                    }
                } else {
                    consecutivas = 1;
                }
            }

    
            boolean tiene10 = false, tiene11 = false, tiene12 = false, tiene13 = false, tieneAs = false;

            for (int i = 0; i < count; i++) {
                if (unicas[i] == 10) tiene10 = true;
                if (unicas[i] == 11) tiene11 = true;
                if (unicas[i] == 12) tiene12 = true;
                if (unicas[i] == 13) tiene13 = true;
                if (unicas[i] == 1) tieneAs = true;
            }

            if (tiene10 && tiene11 && tiene12 && tiene13 && tieneAs) {
                System.out.println("ESCALA REIAL");
            } else if (escala) {
                System.out.println("ESCALA");
            } else {
                System.out.println("NO");
            }
        }
    }
}