package dungeonSolucio;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Main {

	public static void main(String[] args) {

		// EX. 1
		System.out.println("EX. 1 - FACTORY METHOD:");
		List<Heroi> herois = new ArrayList<>();

		CreadorHerois cg = new CreadorGuerrers();
		CreadorHerois cm = new CreadorMags();
		CreadorHerois ca = new CreadorArquers();

		herois.add(cg.factoryMethod(Nivell.NOVELL));
		herois.add(cg.factoryMethod(Nivell.LLEGENDARI));
		herois.add(cm.factoryMethod(Nivell.VETERÀ));
		herois.add(cm.factoryMethod(Nivell.VETERÀ));
		herois.add(ca.factoryMethod(Nivell.LLEGENDARI));
		herois.add(ca.factoryMethod(Nivell.NOVELL));
		herois.add(cg.factoryMethod(Nivell.VETERÀ));
		System.out.println(herois);
		System.out.println();

		// EX. 2
		System.out.println("EX. 2 - LISTITERATOR:");
		netejaConsecutius(herois);
		System.out.println(herois);
		System.out.println();

		// EX. 3
		System.out.println("EX. 3 - ABSTRACT FACTORY:");
		DungeonFactory ordreFactory = new OrdreFactory();
		System.out.println(ordreFactory.crearHeroi());
		System.out.println(ordreFactory.crearArma());
		DungeonFactory clanFactory = new ClanFactory();
		System.out.println(clanFactory.crearHeroi());
		System.out.println(clanFactory.crearArma());
		System.out.println();

		// EX. 4
		System.out.println("EX. 4 - MOTXILLA:");
		Motxilla motxilla = new Motxilla();
		motxilla.afegir("Poció normal");
		motxilla.afegir("Escut normal");
		motxilla.afegir("Amulet màgic");
		motxilla.afegir("Runa màgica");
		System.out.println(motxilla);
		motxilla.usar();
		motxilla.usar();
		System.out.println(motxilla);
		motxilla.afegir("Torxa normal");
		System.out.println(motxilla);
		motxilla.usar();
		System.out.println(motxilla);
		System.out.println();

		// EX. 5
		System.out.println("EX. 5 - SINGLETON:");
		Dungeon d1 = Dungeon.getInstance("Cripta del Dimoni", 8);
		d1.entrar(cg.factoryMethod(Nivell.LLEGENDARI));
		d1.entrar(cm.factoryMethod(Nivell.VETERÀ));
		Dungeon d2 = Dungeon.getInstance("Castell Fosc", 10);
		d2.entrar(ca.factoryMethod(Nivell.NOVELL));
		d2.entrar(cg.factoryMethod(Nivell.NOVELL));
		System.out.println(d1 == d2);
		System.out.println(d1);
	}

	public static void netejaConsecutius(List<Heroi> herois) {
		ListIterator<Heroi> it = herois.listIterator();
		Heroi anterior = null;
		while (it.hasNext()) {
			Heroi actual = it.next();
			if (anterior != null && anterior.getClass() == actual.getClass()) {
				if (actual.atac > anterior.atac) {
					it.previous();
					it.previous();
					it.remove();
					anterior = it.next();
				} else {
					it.remove();
				}
			} else {
				anterior = actual;
			}
		}
	}
}
