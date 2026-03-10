package mokepon4bien;

public class Ataque {
	
	private String nombre;
	//Poder
	private Double power;
	//Tipo
	private Tipos tipo;
	//Usos
	private int useMax;
	private int useAct;
	
	//Contructor Ataque Detallado
	public Ataque(String nombre, Double power, int useMax, Tipos tipo) {
		
		this.nombre = nombre;
		//Poder
		this.power = power;
		//Usos
		this.useMax = useMax;
		this.useAct = useMax;
		//Tipo
		this.tipo = tipo;
		
		//Limite
		if(this.power < 10) {
			this.power = 10.0;
		} else if(this.power > 100) {
			this.power = 100.0;
		}
		
	}
	//Contructor Ataque Simplificado
	public Ataque(String nombre, Tipos tipo) {
		
		this.nombre = nombre;
		this.tipo = tipo;
		this.power = 10.0;
		this.useMax = 10;
		this.useAct = useMax;
		
	}
	//toString
	@Override
	public String toString() {
		return nombre + ", Poder = " + power + ", Tipo = " + tipo + ", Uso Maximo = " + useMax + ", Usos Actuales="
				+ useAct;
	}
	//Fin toString
	//Getters
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
	//Setters
	public void setUseAct(int useAct) {
		this.useAct = useAct;
	}
}
