package overcooked1;

import java.util.ArrayDeque;

public class PlatsBruts extends ArrayDeque<Plat>{
	
	public boolean add(Plat plat) {
		push(plat);
		return true;
	}
	
	public void use() {
		if (!isEmpty()) {
            Plat plat = pop();
            System.out.println("S'ha rentat el plat: " + plat);
        } else {
            System.out.println("No queden plats per rentar. Rentat aturat.");
        }
	}
}
