package examenTutti;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement(name = "personatge")
@XmlType(propOrder = {"nom", "classe", "stats", "habilitats"})
public class Personatge {

	int id;
	String nom;
	String classe;
	Stats stats;
	ArrayList<String> habilitats;
	
	@XmlAttribute
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@XmlElement
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@XmlElement
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	@XmlElement
	public Stats getStats() {
		return stats;
	}
	public void setStats(Stats stats) {
		this.stats = stats;
	}
	@XmlElementWrapper(name = "habilitats")
	@XmlElement(name = "li")
	public ArrayList<String> getHabilitats() {
		return habilitats;
	}
	public void setHabilitats(ArrayList<String> habilitats) {
		this.habilitats = habilitats;
	}
	
	public Personatge() {
		super();
	}
	
	public Personatge(int id, String nom, String classe, Stats stats, ArrayList<String> habilitats) {
		super();
		this.id = id;
		this.nom = nom;
		this.classe = classe;
		this.stats = stats;
		this.habilitats = habilitats;
	}
	@Override
	public String toString() {
		return "Personatge [id=" + id + ", nom=" + nom + ", classe=" + classe + ", stats=" + stats + ", habilitats="
				+ habilitats + "]";
	}
	
	
	
}
