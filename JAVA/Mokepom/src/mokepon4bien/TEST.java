package mokepon4bien;

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

		while (combate) {
			meow.Atacar(chaca, 0);
			chaca.Atacar(meow, 1);
			if (chaca.isDebilitado() || meow.isDebilitado()) {
				combate = false;
			}
		}

		System.out.println(chascarrido);

		System.out.println(mokCaptura.numeroPokemonsCapturats);

		System.out.println(meow);

		mokCaptura pok = meow.capturar("Ruby", "MeowGatito");
		
		Objeto pocion = new Pocion("Pocion", 10);
		Objeto revivir = new Revivir("Revivir");

		revivir.Obtener(10);
		pocion.Obtener(10);

		revivir.utilizar(pok);
		System.out.println(pok.getHpAct());
		pocion.utilizar(pok);
		System.out.println(pok.getHpAct());
		
		
		Arma espada = new Arma("Espada MataDioses", 99);
		
		espada.equipar(pok);
		
		System.out.println(pok);
		
		espada.desequipar(pok);
		
		System.out.println(pok);
		
		Armadura armor = new Armadura("Armadura de Arceus", 999);
		
		armor.equipar(pok);
		
		System.out.println(pok);
		
		armor.desequipar(pok);
		
		System.out.println(pok);
	}
	

}
