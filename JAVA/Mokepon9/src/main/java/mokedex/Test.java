package mokedex;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {

	public static void main(String[] args) {

		String fitxer = "src//main//resources//Mokedex.xml";

		// CREAR MOKEDEX

		Mokedex mok = new Mokedex();

		mok.setNom_entrenador("Ash");

		// CREAR ENTRADA

		Entrada entrada = new Entrada();

		entrada.setId(45);
		entrada.setNom("Mileplume");
		entrada.setTipus("Planta,Veneno");
		entrada.setPes(18.5f);

		// CREAR EVOLUCIONS

		Evolucions evo = new Evolucions();

		evo.setPre_evolucio("-");
		evo.setPost_evolucio("Vileplume");

		entrada.setEvolucions(evo);

		// LOCALITZACIONS

		entrada.getLocalitzacions().add("Ruta 1");
		entrada.getLocalitzacions().add("Ruta 6");

		// AÑADIR ENTRADA A MOKEDEX

		mok.getEntrades().add(entrada);

		// GUARDAR XML BIEN

		try {

			JAXBContext context = JAXBContext.newInstance(Mokedex.class);

			Marshaller mar = context.createMarshaller();

			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			mar.marshal(mok, new File(fitxer));

		} catch (Exception e) {

			e.printStackTrace();

		}

		// AHORA YA FUNCIONAN LAS FUNCIONES

		afegirLocalitzacio(fitxer, 45, "Bosc dels Mulmasaurs");

		modificarPes(fitxer, 45, 2.0f);

		postEvolucio(fitxer, 45);

	}

	public static void afegirMokedex(String nomFitxer, Entrada novaEntrada) {

		try {
			File fitxer = new File(nomFitxer);
			JAXBContext context = JAXBContext.newInstance(Mokedex.class);
			Unmarshaller um = context.createUnmarshaller();
			Mokedex mok = (Mokedex) um.unmarshal(fitxer);
			// Añadir nueva entrada
			mok.getEntrades().add(novaEntrada);
			// Guardar archivo
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(mok, fitxer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void modificarPes(String nomFitxer, int idEntrada, float pesExtra) {

		try {

			File fitxer = new File(nomFitxer);
			JAXBContext context = JAXBContext.newInstance(Mokedex.class);
			Unmarshaller um = context.createUnmarshaller();
			Mokedex mok = (Mokedex) um.unmarshal(fitxer);
			boolean trobat = false;
			for (Entrada e : mok.getEntrades()) {
				if (e.getId() == idEntrada) {
					e.setPes(e.getPes() + pesExtra);
					trobat = true;
					break;
				}
			}
			if (!trobat) {
				System.out.println("ERROR: id no trobada");
				return;
			}
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(mok, fitxer);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void afegirLocalitzacio(String nomFitxer, int idEntrada, String novaLoc) {

		try {
			File fitxer = new File(nomFitxer);
			JAXBContext context = JAXBContext.newInstance(Mokedex.class);
			Unmarshaller um = context.createUnmarshaller();
			Mokedex mok = (Mokedex) um.unmarshal(fitxer);
			boolean trobat = false;
			for (Entrada e : mok.getEntrades()) {
				if (e.getId() == idEntrada) {
					e.getLocalitzacions().add(novaLoc);

					trobat = true;
					break;
				}
			}
			if (!trobat) {
				System.out.println("ERROR: id no trobada");
				return;
			}
			Marshaller mar = context.createMarshaller();
			mar.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			mar.marshal(mok, fitxer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void postEvolucio(String nomFitxer, int idEntrada) {

		try {

			File fitxer = new File(nomFitxer);
			JAXBContext context = JAXBContext.newInstance(Mokedex.class);
			Unmarshaller um = context.createUnmarshaller();
			Mokedex mok = (Mokedex) um.unmarshal(fitxer);
			boolean trobat = false;
			for (Entrada e : mok.getEntrades()) {
				if (e.getId() == idEntrada) {
					String post = e.getEvolucions().getPost_evolucio();
					if (post.equals("-")) {
						System.out.println("No té post-evolució");
					} else {
						System.out.println("Post-evolució: " + post);
					}
					trobat = true;
					break;
				}
			}
			if (!trobat) {
				System.out.println("ERROR: id no trobada");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
