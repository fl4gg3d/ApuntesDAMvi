package examenTutti;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "stats")
@XmlType(propOrder = {"vida", "atac", "defensa"})
public class Stats {

	int vida;
	int atac;
	int defensa;
	@XmlElement
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	@XmlElement
	public int getAtac() {
		return atac;
	}
	public void setAtac(int atac) {
		this.atac = atac;
	}
	@XmlElement
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	@Override
	public String toString() {
		return "Stats [vida=" + vida + ", atac=" + atac + ", defensa=" + defensa + "]";
	}
	public Stats() {
		super();
	}
	
	public Stats(int vida, int atac, int defensa) {
		super();
		this.vida = vida;
		this.atac = atac;
		this.defensa = defensa;
	}
	
}
