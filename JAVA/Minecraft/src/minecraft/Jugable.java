package minecraft;

import java.util.ArrayList;

public class Jugable extends Personatge {

	ArrayList<Item> equip = new ArrayList<Item>();
	int esmeraldes;

	public Jugable(String nom, int maxHp, int esmeraldes) {
		super(nom, maxHp);
		this.esmeraldes = esmeraldes;
	}

	// Metodos
	public int comprar(Comerciant C) {
		if(C.viu && this.esmeraldes >= C.preuVenda) {
			this.esmeraldes -= C.preuVenda;
			C.quantitat--;
			this.equip.add(C.objecte);
			return esmeraldes;
			} else if(this.esmeraldes < C.preuVenda){
				System.out.println("No tens sufients esmeraldes");
			} else if(!C.viu) {
				System.out.println("El comerciant no esta viu");
			}
		return esmeraldes;
	}

	public int vender(int index, Comerciant C) {
		if (C.viu) {
			esmeraldes += this.equip.get(index).valor;
			this.equip.remove(index);
		}
		return esmeraldes;
	}

	public void utilizar(Pocio P) {
		if(P.tipo == Tipo.consumible) {
			this.setHp(P.poder);
		}
	}

	@Override
	public String toString() {
		return super.toString() + "Jugable [esmeraldes=" + esmeraldes + "]";
	}

}
