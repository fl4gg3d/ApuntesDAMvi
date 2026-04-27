package mokepon10;

import java.util.ArrayList;

public class Marc {

	private String nom;
    private long edad;
    private ArrayList<String> aficions = new ArrayList<>();
    public Marc() {
        super();
    }
    //aqui falten els getters i setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public long getEdad() {
		return edad;
	}
	public void setEdad(long edad) {
		this.edad = edad;
	}
	public ArrayList<String> getAficions() {
		return aficions;
	}
	public void setAficions(ArrayList<String> aficions) {
		this.aficions = aficions;
	}
    
}
