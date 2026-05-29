package adapter;

public class Guerrer {
    private int defensa;
    private DanyProvider danyProvider;

    public Guerrer(int defensa, DanyProvider danyProvider) {
        this.defensa = defensa;
        this.danyProvider = danyProvider;
    }

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public DanyProvider getDanyProvider() {
		return danyProvider;
	}

	@Override
	public String toString() {
		return "Guerrer [defensa=" + defensa + ", danyProvider=" + danyProvider + "]";
	}

    
}
