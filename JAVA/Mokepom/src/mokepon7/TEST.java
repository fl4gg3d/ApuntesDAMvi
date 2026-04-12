package mokepon7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import mokepon6bien.objetos.Objeto;
import mokepon6bien.objetos.ObjetoFactory;

public class TEST {

	static Scanner sc = new Scanner(System.in);

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

		System.out.println(chascarrido);

		System.out.println(mokCaptura.numeroPokemonsCapturats);

		System.out.println(meow);

		mokCaptura pok = null;
		try {
			pok = meow.capturar("E", "de");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

		System.out.println(chaca);

		mokepon Umbra = new mokepon("Umbra", 100, 1, 1, 1, 1, Tipos.planta, Sexo.Hembra);

		try {
			Huevo meowWita = pok.reproduccion(pok, chaca);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(pok.getNombre() + " esta muy cansado.");
		}

		ArrayList<mokepon> mokedex = new ArrayList<mokepon>();

		mokedex.add(meow);
		mokedex.add(Umbra);
		mokedex.add(chaca);

		Collections.sort(mokedex);

		for (mokepon m : mokedex) {
			System.out.println(m);
		}

		mokepon Chespin = new mokepon("Chespin", 35, 5, 7, 9, 6, Tipos.planta, Sexo.Macho);
		mokepon Pigi = new mokepon("Piggi", 32, 5, 9, 6, 8, Tipos.fuego, Sexo.Hembra);

		Ataque placaje = new Ataque("Placaje", 40.0, 10, Tipos.normal);
		Ataque hojaAfilada = new Ataque("Hoja Afilada", 50.0, 10, Tipos.planta);
		Ataque ascuas = new Ataque("Ascuas", 50.0, 10, Tipos.fuego);

		Chespin.registroAtaque(placaje);
		Chespin.registroAtaque(hojaAfilada);

		Pigi.registroAtaque(placaje);
		Pigi.registroAtaque(ascuas);

//		Combate(Chespin, Pigi);

		mostraGimnasos();
		System.out.println();
		System.out.println("BuscarGim");
		cercaLider("Isla de Epstein");
	}

	public static void mostraGimnasos() {
		try {
            File f = new File("Gimnasos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);            
            System.out.println("Reader Carregat Correctament");          
            //FUNCIONS IMPORTANTS DEL BUFFEREDREADER
            //READ - LLEGEIX UN CARÀCTER
            //READY - diu si queden coses al fitxer
            while(br.ready()) {
            	System.out.println(br.readLine());   
            }
            //READLINE - llegeix una línia de cop. Exactament igual que al scanner
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general de lectura");
            e.printStackTrace();
        }
	}
	public static void cercaLider(String nomGimnas) {
		try {
            File f = new File("Gimnasos.txt");
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);            
            System.out.println("Reader Carregat Correctament");          
            //FUNCIONS IMPORTANTS DEL BUFFEREDREADER
            //READ - LLEGEIX UN CARÀCTER
            //READY - diu si queden coses al fitxer
            while(br.ready()) {
            	String[] Split = br.readLine().split(";");
            	if(Split[0].equals(nomGimnas)) {
            		System.out.println(Split[2]);
            	}
            }
            //READLINE - llegeix una línia de cop. Exactament igual que al scanner
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("El fitxer no existeix");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepció general de lectura");
            e.printStackTrace();
        }
	}
	public static void invictes(int n) {
		
	}
	public static void afegirGimnas(String nomGimnas, String ciutat, String liderGimnas, int numSuperao) {
		try {
			// path al fitxer
			File f = new File("Gimnasos.txt");
			FileWriter fw;
			fw = new FileWriter(f, true);
			BufferedWriter bw = new BufferedWriter(fw);
			System.out.println("Writer Carregat Correctament");
			// FUNCIONS IMPORTANTS DEL BUFFEREDWRITER
			// append. Escriu al buffer intern. Sense salts de línia. No escriu al fitxer
			// fins que fas un flush
			bw.append(nomGimnas + ";" + ciutat + ";" + liderGimnas + ";" + "\n");
			// Guarda tots els canvis que has fet al buffer intern. Escriu a fitxer
			bw.flush();
			// close. Tanca el bufferedWriter i evita que quedi la memòria penjant
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fitxer no existeix");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Excepció general d'escriptura");
			e.printStackTrace();
		}
	}

	public static void Combate(mokepon m1, mokepon m2) {
		boolean fi = false;

		int torn = MokeponMesRapid(m1, m2);

		while (!fi) {

			int numAtac;

			if (torn == 1) {
				numAtac = triaAtac(m1);
			} else {
				numAtac = triaAtac(m2);
			}

			boolean debilitat = gestionarAtac(m1, m2, torn, numAtac);

			fi = fiCombat(debilitat, torn, m1, m2);

			torn = canviTorn(torn);
		}
	}

	public static int MokeponMesRapid(mokepon m1, mokepon m2) {

		if (m1.getVel() >= m2.getVel()) {
			System.out.println(m1.getNombre() + " es más rápido y empieza!");
			return 1;
		} else {
			System.out.println(m2.getNombre() + " es más rápido y empieza!");
			return 2;
		}

	}

	public static int triaAtac(mokepon atacante) {

		System.out.println("\nTurno de " + atacante.getNombre());
		System.out.println("Elige un ataque:");

		for (int i = 0; i < atacante.getSetAtks().size(); i++) {
			System.out.println(i + 1 + " - " + atacante.getSetAtks().get(i).getNombre());
		}

		int num = sc.nextInt() - 1;

		return num;
	}

	public static boolean gestionarAtac(mokepon m1, mokepon m2, int torn, int numAtac) {

		if (torn == 1) {

			m1.Atacar(m2, numAtac);
			m2.debilitadoEnCombate();
			return m2.isDebilitado();

		} else {

			m2.Atacar(m1, numAtac);
			m1.debilitadoEnCombate();
			return m1.isDebilitado();

		}

	}

	public static boolean fiCombat(boolean debilitat, int torn, mokepon m1, mokepon m2) {

		if (debilitat) {

			if (torn == 1) {
				System.out.println("¡¡" + m1.getNombre() + " gana el combate!!");
			} else {
				System.out.println("¡¡" + m2.getNombre() + " gana el combate!!");
			}

			return true;
		}

		return false;
	}

	public static int canviTorn(int torn) {

		if (torn == 1) {
			return 2;
		} else {
			return 1;
		}

	}

	public static void nomDeTots(ArrayList<? extends mokepon> list) {

		for (mokepon m : list) {
			m.decirNombre();
		}

	}

	public static Objeto generarObjecteAleatori() {

		Random rand = new Random();

		String[] tipusObjectes = { "POCIO", "SUPERPOCIO", "HIPERPOCIO", "REVIVIR" };

		int index = rand.nextInt(tipusObjectes.length);

		return ObjetoFactory.crearObjecte(tipusObjectes[index]);
	}
}
