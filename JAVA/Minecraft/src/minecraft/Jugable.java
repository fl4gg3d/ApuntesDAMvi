package minecraft;

import java.util.ArrayList;

public class Jugable extends Personatge{

	ArrayList<Item> equip = new ArrayList<Item>();
	int esmeraldes;

	public Jugable(String nom, int maxHp) {
		super(nom, maxHp);
		
	}
	
	
	//Metodos
	public int comprar(Comerciant C) {
		
		return esmeraldes;
	}
	public int vender(Comerciant C) {
		return esmeraldes;
		
	}
	public void utilizar(Pocio P) {
		
	}
}
