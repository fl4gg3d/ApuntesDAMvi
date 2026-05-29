package isaacSolucio;

public class AdapterBomb implements AtkSizeProvider{
	
	private Bomb bomb;
	
	

	public AdapterBomb(Bomb bomb) {
		super();
		this.bomb = bomb;
	}

	@Override
	public double getAtk() {
		// TODO Auto-generated method stub
		return bomb.getDmg()*0.5;
	}

	@Override
	public double getSize() {
		// TODO Auto-generated method stub
		return 1;
	}

}
