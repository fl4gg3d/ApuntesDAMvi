package mokepon9;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//l'element es diu entrada en el XML
@XmlRootElement(name = "entrada")
// l'ordre en que apareixeran els seus elements interns en el XML
@XmlType(propOrder = { "nom", "tipus", "pes", "evolucions", "localitzacions" })
public class Entrada {

	int id;
	String nom;
	String tipus;
	double pes;
	Evolucions evolucions;
	ArrayList<String> localitzacions = new ArrayList<String>();

	public Entrada() {
		super();
	}

	public Entrada(int id, String nom, String tipus, double pes, Evolucions evolucions, ArrayList<String> localitzacions) {
		super();
		this.id = id;
		this.nom = nom;
		this.tipus = tipus;
		this.pes = pes;
		this.evolucions = evolucions;
		this.localitzacions = localitzacions;
	}

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
	public String getTipus() {
		return tipus;
	}

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	@XmlElement
	public double getPes() {
		return pes;
	}

	public void setPes(double pes) {
		this.pes = pes;
	}

	@XmlElement
	public Evolucions getEvolucions() {
		return evolucions;
	}

	public void setEvolucions(Evolucions evolucions) {
		this.evolucions = evolucions;
	}

	@XmlElementWrapper(name = "localitzacions")
	@XmlElement(name = "localitzacio")
	public ArrayList<String> getLocalitzacions() {
		return localitzacions;
	}

	public void setLocalitzacions(ArrayList<String> localitzacions) {
		this.localitzacions = localitzacions;
	}

	@Override
	public String toString() {
		return "Entrada [id=" + id + ", nom=" + nom + ", tipus=" + tipus + ", pes=" + pes + ", evolucions=" + evolucions
				+ ", localitzacions=" + localitzacions + "]";
	}

}
