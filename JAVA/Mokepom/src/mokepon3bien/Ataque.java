package mokepon3bien;

public class Ataque {
	
	String nombre;
	//Poder
	Double power;
	//Tipo
	Tipos tipo;
	//Usos
	int useMax;
	int useAct;
	
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
	
}
