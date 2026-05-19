package mokepon9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

public class TestMok9 {

	public static void main(String[] args) throws IOException {

		JsonObject entrada = new JsonObject();
//		Entrada entrada = new Entrada(10, "Xarmeleon", "Foc", 34.5, ev, locs);

		entrada.addProperty("id", 907);
		entrada.addProperty("nom", "Floragato");
		entrada.addProperty("tipus", "Planta");
		entrada.addProperty("pes", 34.5);

		JsonObject evolucions = new JsonObject();
		evolucions.addProperty("pre_evolucio", "Sprigatito");
		evolucions.addProperty("post_evolucio", "Meowscarda");

		JsonArray locs = new JsonArray();
		locs.add("Ruta 1");
		locs.add("Ruta 3");
		locs.add("Ruta 5");

		entrada.add("evolucions", evolucions);
		entrada.add("localitzacions", locs);

		ArrayList<String> locs2 = new ArrayList<>();
		locs2.add("Ruta 2");
		locs2.add("Ruta 4");
		locs2.add("Ruta 6");
		Evolucions ev2 = new Evolucions("Pitxu", "Raitxu");
		Entrada entrada2 = new Entrada(25, "Picatxu", "Electric", 15.5, ev2, locs2);
		
		
		afegirMokedex("mokedex.json", entrada);
		modificarPes("mokedex.json", 22, 10);
		afegirLocalitzacio("mokedex.json", 1, "casa");
		postEvolucio("mokedex.json", 1);
		
		afegirMokedex("mokedex.json", entrada2);
		GigantamaxPostEvolució("mokedex.json", 100);
		esborrarLocalitzacio("mokedex.json", 100, "Ruta 1");
		
//		ArrayList<String> locs = new ArrayList<>();
//		locs.add("Ruta 1");
//		locs.add("Ruta 3");
//		locs.add("Ruta 5");
//
//		ArrayList<String> locs2 = new ArrayList<>();
//		locs2.add("Ruta 2");
//		locs2.add("Ruta 4");
//		locs2.add("Ruta 6");
//
//		Evolucions ev = new Evolucions("Xarmander", "Xarizard");
//		Evolucions ev2 = new Evolucions("Pitxu", "Raitxu");
//
//		ArrayList<Entrada> entrades = new ArrayList<Entrada>();
//
//		Entrada entrada = new Entrada(10, "Xarmeleon", "Foc", 34.5, ev, locs);
//		Entrada entrada2 = new Entrada(25, "Picatxu", "Electric", 15.5, ev2, locs2);
//		entrades.add(entrada);
//		entrades.add(entrada2);

//		Mokedex mdex = new Mokedex("Dani", entrades);

//		escriureEntrada();
//		llegirEntrada();
//		escriureMokedex(mdex, "mokedex");
//		Mokedex m = llegirMokedex("mokedex");
//		System.out.println(m);

//		afegirMokedex("mokedex", entrada);
//		modificarPes("mokedex", 25, 10);
//		afegirLocalitzacio("mokedex", 10, "Ruta 66");
//		postEvolucio("mokedex", 10);

	}

	private static void esborrarLocalitzacio(String nomFitxer, int idEntrada, String Loc)
			throws JsonSyntaxException, JsonIOException, IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Mokedex mdex = gson.fromJson(new FileReader(nomFitxer), Mokedex.class);
		boolean trobat = false;
		boolean trobat2 = false;
		int idloc = 0;
		for (Entrada e : mdex.getEntrades()) {
			if (e.getId() == idEntrada) {
				trobat = true;
				for (String loc : e.getLocalitzacions()) {
					if (loc.equals(Loc)) {
						trobat2 = true;
						idloc = e.getLocalitzacions().indexOf(loc);
					}
				}
				if(trobat2) {
					e.getLocalitzacions().remove(idloc);
				}else {
					System.out.println("No s'ha trobat la localitzacio "+ Loc);
				}
			}

		}
		if (!trobat) {
			System.out.println("No hi ha cap entrada amb la id " + idEntrada);
		}

		FileWriter fw = new FileWriter(nomFitxer);
		fw.append(gson.toJson(mdex));
		fw.flush();
		fw.close();
	}

	private static void GigantamaxPostEvolució(String nomFitxer, int idEntrada)
			throws JsonSyntaxException, JsonIOException, IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Mokedex mdex = gson.fromJson(new FileReader(nomFitxer), Mokedex.class);
		boolean trobat = false;
		boolean trobat2 = false;
		String postEvolucio = null;
		for (Entrada e : mdex.getEntrades()) {
			if (e.getId() == idEntrada) {
				postEvolucio = e.getEvolucions().getPost_evolucio();
				trobat = true;
			}

		}
		if (trobat) {
			for (Entrada e : mdex.getEntrades()) {
				if (e.getNom().equals(postEvolucio)) {
					e.setPes(e.getPes() * 10);
					trobat2 = true;
				}
			}
			if (!trobat2) {
				System.out.println("No s'ha trobat cap entrada amb el nom " + postEvolucio);
			}
		} else {
			System.out.println("No hi ha cap entrada amb la id " + idEntrada);
		}

		FileWriter fw = new FileWriter(nomFitxer);
		fw.append(gson.toJson(mdex));
		fw.flush();
		fw.close();
	}

	private static void afegirMokedex(String nomFitxer, Entrada novaEntrada)
			throws JsonSyntaxException, JsonIOException, IOException {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		Mokedex mdex = gson.fromJson(new FileReader(nomFitxer), Mokedex.class);

		mdex.getEntrades().add(novaEntrada);

		FileWriter fw = new FileWriter(nomFitxer);
		fw.append(gson.toJson(mdex));
		fw.flush();
		fw.close();

	}

	private static void postEvolucio(String nomFitxer, int idEntrada)
			throws JsonIOException, JsonSyntaxException, FileNotFoundException {

		boolean trobat = false;

		JsonElement arrel = JsonParser.parseReader(new FileReader(nomFitxer));
		JsonObject mdex = arrel.getAsJsonObject();
		JsonArray entrades = mdex.get("entrades").getAsJsonArray();
		for (JsonElement e : entrades) {

			JsonObject obj = e.getAsJsonObject();

			if (obj.get("id").getAsInt() == idEntrada) {
				trobat = true;
				JsonObject ev = obj.get("evolucions").getAsJsonObject();
				if (ev.get("post_evolucio") != null) {

					System.out.println(ev.get("post_evolucio").getAsString());
				} else {
					System.out.println("No té post_evolucio");
				}

			}
		}
		if (!trobat) {
			System.out.println("Aquest id no correspon a cap de les entrades");
		}
	}

	private static void afegirLocalitzacio(String nomFitxer, int idEntrada, String novaLoc)
			throws JsonIOException, JsonSyntaxException, IOException {

		boolean trobat = false;

		JsonElement arrel = JsonParser.parseReader(new FileReader(nomFitxer));
		JsonObject mdex = arrel.getAsJsonObject();
		JsonArray entrades = mdex.get("entrades").getAsJsonArray();
		for (JsonElement e : entrades) {

			JsonObject obj = e.getAsJsonObject();

			if (obj.get("id").getAsInt() == idEntrada) {

				JsonArray loc = obj.get("localitzacions").getAsJsonArray();
				loc.add(novaLoc);
				trobat = true;

			}
		}
		if (!trobat) {
			System.out.println("Aquest id no correspon a cap de les entrades");
		}

		Gson escriure = new GsonBuilder().setPrettyPrinting().create();
		FileWriter fw = new FileWriter(nomFitxer);

		fw.append(escriure.toJson(mdex));
		fw.flush();
		fw.close();
	}

	private static void modificarPes(String nomFitxer, int idEntrada, double pesExtra) throws IOException {

		boolean trobat = false;

		JsonElement arrel = JsonParser.parseReader(new FileReader(nomFitxer));
		JsonObject mdex = arrel.getAsJsonObject();
		JsonArray entrades = mdex.get("entrades").getAsJsonArray();
		for (JsonElement e : entrades) {

			JsonObject obj = e.getAsJsonObject();

			if (obj.get("id").getAsInt() == idEntrada) {

				double pes = obj.get("pes").getAsDouble();
				pes += pesExtra;
				obj.addProperty("pes", pes);
				trobat = true;

			}
		}
		if (!trobat) {
			System.out.println("Aquest id no correspon a cap de les entrades");
		}

		Gson escriure = new GsonBuilder().setPrettyPrinting().create();
		FileWriter fw = new FileWriter(nomFitxer);

		fw.append(escriure.toJson(mdex));
		fw.flush();
		fw.close();
	}

	private static void afegirMokedex(String nomFitxer, JsonObject novaEntrada)
			throws JsonIOException, JsonSyntaxException, IOException {

		JsonElement arrel = JsonParser.parseReader(new FileReader(nomFitxer));
		JsonObject mdex = arrel.getAsJsonObject();
		JsonArray entrades = mdex.get("entrades").getAsJsonArray();
		entrades.add(novaEntrada);
//		System.out.println(entrades);
		Gson escriure = new GsonBuilder().setPrettyPrinting().create();

		FileWriter fw = new FileWriter(nomFitxer);

		fw.append(escriure.toJson(mdex));
		fw.flush();
		fw.close();
	}

}
