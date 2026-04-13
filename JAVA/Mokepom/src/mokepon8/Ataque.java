package mokepon8;

public class Ataque implements Comparable<Ataque>{

	private String nombre;
	// Poder
	private Double power;
	// Tipo
	private Tipos tipo;
	// Usos
	private int useMax;
	private int useAct;

	// Contructor Ataque Detallado
	public Ataque(String nombre, Double power, int useMax, Tipos tipo) {

		this.nombre = nombre;
		// Poder
		this.power = power;
		// Usos
		this.useMax = useMax;
		this.useAct = useMax;
		// Tipo
		this.tipo = tipo;

		// Limite
		if (this.power < 10) {
			this.power = 10.0;
		} else if (this.power > 100) {
			this.power = 100.0;
		}

	}

	// Contructor Ataque Simplificado
	public Ataque(String nombre, Tipos tipo) {

		this.nombre = nombre;
		this.tipo = tipo;
		this.power = 10.0;
		this.useMax = 10;
		this.useAct = useMax;

	}

	// toString
	@Override
	public String toString() {
		return nombre + ", Poder = " + power + ", Tipo = " + tipo + ", Uso Maximo = " + useMax + ", Usos Actuales="
				+ useAct;
	}

	// Fin toString
	// Getters
	public String getNombre() {
		return nombre;
	}

	public Double getPower() {
		return power;
	}

	public Tipos getTipo() {
		return tipo;
	}

	public int getUseMax() {
		return useMax;
	}

	public int getUseAct() {
		return useAct;
	}

	// Setters
	public void setUseAct(int useAct) {
		this.useAct = useAct;
	}

	@Override
	public boolean equals(Object obj) {
		// si els dos objectes son el mateix objecte torna true
		if (this == obj)
			return true;
		// si l'objecte passat es null torna false
		if (obj == null)
			return false;
		// si l'objecte passat es d'una classe diferent a atac torna false
		if (getClass() != obj.getClass())
			return false;
		// casteja l'objecte a atac
		Ataque other = (Ataque) obj;
		// compara tots els atributs d'aquest objecte amb els de l'altre objecte
		if (tipo == other.tipo && nombre.equals(other.nombre) && power == other.power && useAct == other.useAct
				&& useMax == other.useMax) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int compareTo(Ataque otro) {
	    // comparar por power
	    if (otro.power > this.power) {
	        return -1;
	    } else if (this.power > otro.power) {
	        return 1;
	    } 
	    // si tienen el mismo power, comparar por nombre
	    else {
	        return this.nombre.compareTo(otro.nombre);
	    }
	}

}
