package mokedex;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {

	public static void main(String[] args) {
		
		Entrada entrada = new Entrada();
		entrada.id = 45;
		entrada.tipus = "Planta,Veneno";
		entrada.nom = "Mileplume";
		
		File fitxerDesti = new File("src//main//resources//Mokedex.xml");
		try{
		    //si ja has creat el jaxbContext abans per llegir no cal aquesta línea, clar.
		    JAXBContext jaxbContext = JAXBContext.newInstance(Entrada.class);
		    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		    // Es grava el fitxer desti amb la sortida formatada (aixo ultim s'indica en la
		    // instruccio que segueix)
		    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		    //entrada es un objecte de tipus Entrada. fitxerDesti es una String amb el path al fitxer
		    jaxbMarshaller.marshal(entrada, fitxerDesti);


		} catch (JAXBException je) {
		            je.printStackTrace();
		}
		
		File fitxerOrigen = new File("src//main//resources//Mokedex.xml");
		try {
		    // Es crea el context indicant la classe arrel
		    //hauras de posar la classe adient, clar.
		    JAXBContext jaxbContext = JAXBContext.newInstance(Entrada.class);
		    // Es crea un Unmarshaller amb el context de la classe Entrada
		    Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		    // Es fa servir el mètode unmarshal, per a obtenir les dades. Sempre s'ha de fer un casteig. fitxerOrigen es una String amb el path al fitxer
		    Entrada p = (Entrada) jaxbUnmarshaller.unmarshal(fitxerOrigen);
		    System.out.println(p);
		} catch (JAXBException je) {
		    je.printStackTrace();
		}
		
	}

}
