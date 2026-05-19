package examenTutti;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "companyia")
@XmlType(propOrder = {"personatges"})
public class Companyia {
	String nom;
	ArrayList<Personatge> personatges;
	
	public Companyia() {
		super();
	}
	
	public Companyia(String nom, ArrayList<Personatge> personatges) {
		super();
		this.nom = nom;
		this.personatges = personatges;
	}
	@XmlAttribute
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElementWrapper(name = "personatges")
	@XmlElement(name = "personatge")
	public ArrayList<Personatge> getPersonatges() {
		return personatges;
	}
	public void setPersonatges(ArrayList<Personatge> personatges) {
		this.personatges = personatges;
	}
	@Override
	public String toString() {
		return "Companyia [nom=" + nom + ", personatges=" + personatges + "]";
	}
}
