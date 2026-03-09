package mokepon2bien;

public class TEST {

	public static void main(String[] args) {
		
		mokepon meow = new mokepon("Meow", Tipos.planta);
		mokepon chaca = new mokepon("Chaca", Tipos.fuego);
		
		Ataque chascarrido = new Ataque("Chascarrido", Tipos.fuego);
		Ataque colaFuego = new Ataque("Cola Fuego", Tipos.fuego);
		Ataque latigoPlanta = new Ataque("Latigo Planta", Tipos.planta);
		Ataque semillas = new Ataque("Semillas", Tipos.planta);
		
		meow.registroAtaqueVarios(latigoPlanta, semillas);
		chaca.registroAtaqueVarios(chascarrido, colaFuego);
		
		boolean combate = true;
		
		while(combate) {
			meow.Atacar(chaca, 0);
			chaca.Atacar(meow, 1);
			if(chaca. || meow.debilitado) {
				combate = false;
			}
		}
		
		meow = meow.capturar("Ruby", "Meow");
		meow.capturar("Ruby", "Meow");
		meow.capturar("Ruby", "Meow");
	}

}
