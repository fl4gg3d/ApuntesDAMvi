package isaacSolucio;

import java.util.ArrayList;
import java.util.List;

public class RoomManager implements Observer{
	int punts;

	public RoomManager() {
		super();
		this.punts = 0;
	}
	
	public List<Enemic> initRoom(int nombreEnemics){
		List<Enemic> enemics = new ArrayList<>();		
		for(int i=0; i<nombreEnemics; i++) {
			Enemic enemic = EnemicFactory.crearEnemic(Cuca.class, Dificultat.FACIL);
			enemic.addObserver(this);
			enemics.add(enemic);
		}
		return enemics;
	}

	@Override
	public void update(int punts) {
		System.out.println("Enemic mort. Punts guanyats: "+punts);
		this.punts+=punts;
		
	}

	@Override
	public String toString() {
		return "RoomManager [punts=" + punts + "]";
	}
	
}
