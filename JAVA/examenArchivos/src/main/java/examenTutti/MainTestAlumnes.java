package examenTutti;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class MainTestAlumnes {

	public static void main(String[] args) throws IOException, ClassNotFoundException, JAXBException {

		System.out.println("===== TEST FITXERS DE TEXT =====");

		ArrayList<ItemBotiga> botiga = llegirBotiga();
		checkEquals(7, botiga.size(), "La botiga hauria de tenir 7 ítems");
		checkContains(botiga.toString(), "PocioVida", "La botiga hauria de contenir PocioVida");

		checkEquals(false, comprarItem("EscutFusta"), "EscutFusta no es pot comprar perquè no està disponible");
		checkEquals(true, comprarItem("EspasaRovellada"), "EspasaRovellada s'hauria de poder comprar");

		checkFileExists("botigaMod.txt", "comprarItem hauria de crear botigaMod.txt");
		checkFileContains("botigaMod.txt", "EspasaRovellada;80;Arma;0;false",
				"EspasaRovellada hauria de quedar amb quantitat 0 i disponible false");

		checkEquals(false, comprarItem("ObjecteInventat"), "Un objecte inexistent hauria de retornar false");

		System.out.println("\n===== TEST FITXERS SERIALITZATS =====");

		Efecte efCuracio = new Efecte("Curacio", 30);
		Efecte efMana = new Efecte("Mana", 20);
		Efecte efAtac = new Efecte("Atac", 5);

		ItemInventari inv1 = new ItemInventari("PocioVida", 2, "Consumible", efCuracio);
		ItemInventari inv2 = new ItemInventari("CristallMana", 1, "Consumible", efMana);
		ItemInventari inv3 = new ItemInventari("EspasaRovellada", 1, "Arma", efAtac);

		ArrayList<ItemInventari> inventari = new ArrayList<>();
		inventari.add(inv1);
		inventari.add(inv2);
		inventari.add(inv3);

//		escriureInventari(inventari);
//		checkFileExists("inventari.dat", "escriureInventari hauria de crear inventari.dat");
//
//		ArrayList<ItemInventari> inventariLlegit = llegirInventari();
//		checkEquals(3, inventariLlegit.size(), "llegirInventari hauria de retornar 3 objectes");
//		checkContains(inventariLlegit.toString(), "PocioVida", "L'inventari hauria de contenir PocioVida");
//
//	    checkEquals(5, afegirInventari(new ItemInventari("PocioVida", 3, "Consumible", efCuracio)),
//	            "Afegir 3 PocioVida a les 2 existents hauria de retornar 5");
//
//	    checkEquals(1, afegirInventari(new ItemInventari("ClauAntiga", 1, "Especial", new Efecte("Obrir", 1))),
//	            "Afegir ClauAntiga nova hauria de retornar 1");
//
//	    inventariLlegit = llegirInventari();
//	    checkEquals(4, inventariLlegit.size(), "Ara l'inventari hauria de tenir 4 objectes diferents");
//	    checkContains(inventariLlegit.toString(), "ClauAntiga", "L'inventari hauria de contenir ClauAntiga");
//
//
		System.out.println("\n===== TEST FITXERS XML =====");

		Companyia companyia = llegirPersonatges("companyia.xml");
		checkContains(companyia.toString(), "Arya", "La companyia hauria de contenir Arya");
		checkContains(companyia.toString(), "Guerrera", "La companyia hauria de contenir una Guerrera");

		escriurePersonatges("companyia_test.xml", companyia);
		checkFileExists("companyia_test.xml", "escriurePersonatges hauria de crear companyia_test.xml");

		Companyia companyiaTest = llegirPersonatges("companyia_test.xml");
		checkContains(companyiaTest.toString(), "Nil", "companyia_test.xml hauria de contenir Nil");

	    checkEquals(true, afegirHabilitat("companyia.xml", "Arya", "Crit heroic"),
	            "Afegir habilitat a Arya hauria de retornar true");

	    checkFileExists("companyia_mod.xml", "afegirHabilitat hauria de crear companyia_mod.xml");

	    Companyia companyiaMod = llegirPersonatges("companyia_mod.xml");
	    checkContains(companyiaMod.toString(), "Crit heroic",
	            "companyia_mod.xml hauria de contenir la nova habilitat Crit heroic");

	    checkEquals(false, afegirHabilitat("companyia.xml", "PersonatgeInventat", "HabilitatImpossible"),
	            "Afegir habilitat a un personatge inexistent hauria de retornar false");

//
//	    System.out.println("\n===== TEST FITXERS JSON =====");
//
//	    checkEquals(2, millorarCompanyia("companyia.json", "Guerrera", 10),
//	            "Hi hauria d'haver 2 personatges de classe Guerrera modificats");
//
//	    checkFileExists("companyia_millorada.json",
//	            "millorarCompanyia hauria de crear companyia_millorada.json");
//
//	    checkFileContains("companyia_millorada.json", "\"nom\": \"Arya\"",
//	            "companyia_millorada.json hauria de contenir Arya");
//
//	    checkFileContains("companyia_millorada.json", "\"atac\": 25",
//	            "Arya tenia atac 15 i amb +10 hauria de quedar a 25");
//
//	    checkFileContains("companyia_millorada.json", "\"nom\": \"Brak\"",
//	            "companyia_millorada.json hauria de contenir Brak");
//
//	    checkEquals(0, millorarCompanyia("companyia.json", "ClasseInventada", 10),
//	            "Una classe inexistent hauria de retornar 0");
//
//	    System.out.println("\n===== TEST FINALITZAT =====");
//
//		

	}

	public static void checkEquals(Object esperat, Object obtingut, String missatge) {
		if ((esperat == null && obtingut == null) || (esperat != null && esperat.equals(obtingut))) {
			System.out.println("[OK] " + missatge);
		} else {
			System.out.println("[ERROR] " + missatge);
			System.out.println("       Esperat: " + esperat);
			System.out.println("       Obtingut: " + obtingut);
		}
	}

	public static void checkContains(String text, String fragment, String missatge) {
		if (text != null && text.contains(fragment)) {
			System.out.println("[OK] " + missatge);
		} else {
			System.out.println("[ERROR] " + missatge);
			System.out.println("       No s'ha trobat: " + fragment);
		}
	}

	public static void checkFileExists(String nomFitxer, String missatge) {
		File f = new File(nomFitxer);
		if (f.exists()) {
			System.out.println("[OK] " + missatge);
		} else {
			System.out.println("[ERROR] " + missatge);
			System.out.println("       No existeix el fitxer: " + nomFitxer);
		}
	}

	public static void checkFileContains(String nomFitxer, String fragment, String missatge) throws IOException {
		File f = new File(nomFitxer);

		if (!f.exists()) {
			System.out.println("[ERROR] " + missatge);
			System.out.println("       No existeix el fitxer: " + nomFitxer);
			return;
		}

		BufferedReader br = new BufferedReader(new FileReader(f));
		StringBuilder contingut = new StringBuilder();
		String linia;

		while ((linia = br.readLine()) != null) {
			contingut.append(linia).append("\n");
		}

		br.close();

		if (contingut.toString().contains(fragment)) {
			System.out.println("[OK] " + missatge);
		} else {
			System.out.println("[ERROR] " + missatge);
			System.out.println("       No s'ha trobat: " + fragment);
		}
	}

	// AFEGEIX AQUÍ ELS TEUS MÈTODES

	// TEXT
	private static ArrayList<ItemBotiga> llegirBotiga() {
		ArrayList<ItemBotiga> items = new ArrayList<ItemBotiga>();
		try {
			File f = new File("botiga.txt");
			FileReader fr;
			fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			while (br.ready()) {
				String linia = br.readLine();
				String[] campsBotiga = linia.split(";");
				ItemBotiga Item = new ItemBotiga(campsBotiga[0], Integer.parseInt(campsBotiga[1]), campsBotiga[2],
						Integer.parseInt(campsBotiga[3]), Boolean.parseBoolean(campsBotiga[4]));
				items.add(Item);
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fitxer no existeix");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Excepció general de lectura");
			e.printStackTrace();
		}
		return items;
	}

	private static boolean comprarItem(String nomItem) {
		ArrayList<ItemBotiga> Items = llegirBotiga();
		boolean disponible = false;
		for (ItemBotiga itemBotiga : Items) {
			if (itemBotiga.nom.equals(nomItem) && itemBotiga.disponible && itemBotiga.quantitat > 0) {
				itemBotiga.quantitat -= 1;
				disponible = true;
				if (itemBotiga.quantitat == 0) {
					itemBotiga.disponible = false;
				}
			}
		}
		try {
			File f = new File("botigaMod.txt");
			FileWriter fw = new FileWriter(f);
			BufferedWriter bw = new BufferedWriter(fw);
			for (ItemBotiga item : Items) {
				bw.append(item.nom + ";" + item.preu + ";" + item.tipus + ";" + item.quantitat + ";" + item.disponible
						+ ";\n");
			}
			bw.flush();
			bw.close();
		} catch (FileNotFoundException e) {
			System.out.println("El fitxer no existeix");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Excepció general d'escriptura");
			e.printStackTrace();
		}
		return disponible;
	}

	// SERIALITZATS
	private static void escriureInventari(ArrayList<ItemInventari> inventari) {
		try {
			File f = new File("inventari.dat");
			FileOutputStream fos = new FileOutputStream(f, true);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (ItemInventari item : inventari) {
				oos.writeObject(item);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static ArrayList<ItemInventari> llegirInventari() {
		ArrayList<ItemInventari> items = new ArrayList<ItemInventari>();
		try {
			File f = new File("inventari.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);
			while (true) {
				Object o = ois.readObject();
				if (o instanceof ItemInventari) {
					ItemInventari j = (ItemInventari) o;
					items.add(j);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return items;
	}

	// XML
	private static Companyia llegirPersonatges(String nomFitxer) {
		File fitxerOrigen = new File("companyia.xml");
		try {
			// Es crea el context indicant la classe arrel
			// hauras de posar la classe adient, clar.
			JAXBContext jaxbContext = JAXBContext.newInstance(Companyia.class);
			// Es crea un Unmarshaller amb el context de la classe Entrada
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			// Es fa servir el mètode unmarshal, per a obtenir les dades. Sempre s'ha de fer
			// un casteig. fitxerOrigen es una String amb el path al fitxer
			Companyia p = (Companyia) jaxbUnmarshaller.unmarshal(fitxerOrigen);
			return p;
		} catch (JAXBException je) {
			je.printStackTrace();
		}
		return null;
	}

	private static void escriurePersonatges(String nomFitxer, Companyia com) {
		File fitxerDesti = new File(nomFitxer);

		try {
			// si ja has creat el jaxbContext abans per llegir no cal aquesta línea, clar.
			JAXBContext jaxbContext = JAXBContext.newInstance(Companyia.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// Es grava el fitxer desti amb la sortida formatada (aixo ultim s'indica en la
			// instruccio que segueix)
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// entrada es un objecte de tipus Entrada. fitxerDesti es una String amb el path
			// al fitxer
			jaxbMarshaller.marshal(com, fitxerDesti);

		} catch (JAXBException je) {
			je.printStackTrace();
		}
	}

	private static boolean afegirHabilitat(String nomFitxer, String nomPersonatge, String novaHabilitat) {
		File fitxerOrigen = new File(nomFitxer);
		Companyia com = llegirPersonatges(nomFitxer);
		boolean trobat = false;
		for (Personatge e : com.getPersonatges()) {
			if (e.nom == nomPersonatge) {
				e.getHabilitats().add(novaHabilitat);
				trobat = true;
			}

		}
		escriurePersonatges(nomFitxer, com);
		return false;
	}
}
