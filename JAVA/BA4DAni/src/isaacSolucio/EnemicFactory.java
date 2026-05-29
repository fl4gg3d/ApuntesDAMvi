package isaacSolucio;

public class EnemicFactory {
	
	public static Enemic crearEnemic(Class<? extends Enemic> tipusEnemic, Dificultat dificultat) {
		if(dificultat==Dificultat.FACIL) {
			if(tipusEnemic == Mosca.class) {
				return new Mosca(1,20);
			} else {
				return new Cuca(3,75);
			}
		} else {
			if(tipusEnemic == Mosca.class) {
				return new Mosca(3,60);
			} else {
				return new Cuca(5,125);
			}
		}
			
	}
}
