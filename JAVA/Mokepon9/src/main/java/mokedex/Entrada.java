package mokedex;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "entrada")

@XmlType(propOrder = { "nom", "tipus", "pes", "evolucions", "localitzacions" })

public class Entrada {

	int id;
	String nom;
	String tipus;
	float pes;

	Evolucions evolucions;

	List<String> localitzacions = new ArrayList<>();

	// ATRIBUTO ID

	@XmlAttribute
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// NOM

	@XmlElement
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	// TIPUS

	@XmlElement
	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	// PES (nuevo)

	@XmlElement
	public float getPes() {
		return pes;
	}

	public void setPes(float pes) {
		this.pes = pes;
	}

	// EVOLUCIONS (nuevo objeto)

	@XmlElement
	public Evolucions getEvolucions() {
		return evolucions;
	}

	public void setEvolucions(Evolucions evolucions) {
		this.evolucions = evolucions;
	}

	// LOCALITZACIONS (lista)

	@XmlElementWrapper(name = "localitzacions")

	@XmlElement(name = "localitzacio")

	public List<String> getLocalitzacions() {
		return localitzacions;
	}

	public void setLocalitzacions(List<String> localitzacions) {
		this.localitzacions = localitzacions;
	}

	@Override
	public String toString() {

		return "Mokemon: " + nom + "\nNum.Mokedex: " + id + "\nTipus: " + tipus + "\nPes: " + pes;

	}

}
