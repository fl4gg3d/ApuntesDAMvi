package mokepon2;

import java.util.Scanner;

public class Test {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		//nombre, vidaMax, Nivel, Ataque, Defensa, Velocidad, Tipo
		Mokepon meowscarada = new Mokepon("Meowscarada", 10, 10, 1, 1, 1, TipusMokepon.planta);
		Mokepon charmander = new Mokepon("Charmander", 10, 10, 1, 1, 1, TipusMokepon.fuego);
		meowscarada.printNom();
		meowscarada.mostrarStats();
		
		Ataques LatigoCepa = new Ataques("Latigo Cepa", TipusMokepon.planta);
		Ataques Drenadoras = new Ataques("Drenadoras", TipusMokepon.planta);
		Ataques FuegoPrimigeneo = new Ataques("Fuego Primigeneo", TipusMokepon.fuego);
		Ataques CarcelDeFuego = new Ataques("Carcel de Fuego", TipusMokepon.fuego);
		
		charmander.ataquePaLaLista(CarcelDeFuego);
		charmander.ataquePaLaLista(FuegoPrimigeneo);
		meowscarada.ataquePaLaLista(LatigoCepa);
		meowscarada.ataquePaLaLista(Drenadoras);
		
		for (Ataques listaAtk: meowscarada.listaAtaques) {
				System.out.println(listaAtk.nombre);
		}
		boolean combate = true;
		
		while(combate) {
			meowscarada.Combate(charmander, 0);
			charmander.Combate(meowscarada, 0);
			if(charmander.debilitado || meowscarada.debilitado) {
				combate = false;
			}
		}
		System.out.println();
		MokeponCapturao meow = new MokeponCapturao("meow", TipusMokepon.normal);
		for (int i = 0; i < 60; i++) {
			System.out.print(i);
			meow.acaririar();
		}
		System.out.println();
		System.out.println(meow.felicitat);
		
	}

}
