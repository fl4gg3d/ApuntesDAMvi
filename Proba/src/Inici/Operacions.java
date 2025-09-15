package Inici;

public class Operacions {

	public static void main(String[] args) {
		
		int a = 50;
		
		int b = 25;
		
		int suma = a + b;
		
		double c = 2.3;
		
		System.out.println("La suma de a + b es: " + suma);

		//suma = a + c; // No se puede porque es decimal más entero
		
		int sumadecimal = (int) (a + c); //Transforma el resultado de Double y nos lo devuelve en Int 
		System.out.println(sumadecimal);
		
		int resta = a - b;
		System.out.println(resta);
		
		int multi = a * b;
		System.out.println(multi);
		
		int div = a / b;
		System.out.println(div);
		
		a++; //Sumas 1
		
		int y =20;
		int x =3;
		
		int modul = y % x; //Residuo de una division
		System.out.println(modul);
		
		double potencia = Math.pow(y, x); //Potencia
		System.out.println(potencia);
		
		}

}
