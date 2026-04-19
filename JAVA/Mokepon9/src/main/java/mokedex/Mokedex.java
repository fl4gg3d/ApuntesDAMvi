package mokedex;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "mokedex")

@XmlType(propOrder = { "nom_entrenador", "entrades" })

public class Mokedex {

	String nom_entrenador;

	List<Entrada> entrades = new ArrayList<>();

	// NOM ENTRENADOR

	@XmlElement
	public String getNom_entrenador() {
		return nom_entrenador;
	}

	public void setNom_entrenador(String nom_entrenador) {
		this.nom_entrenador = nom_entrenador;
	}

	// LISTA DE ENTRADES

	@XmlElementWrapper(name = "entrades")

	@XmlElement(name = "entrada")

	public List<Entrada> getEntrades() {
		return entrades;
	}

	public void setEntrades(List<Entrada> entrades) {
		this.entrades = entrades;
	}

}