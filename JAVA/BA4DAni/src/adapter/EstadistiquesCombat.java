package adapter;

enum TipusArma{
	ESPASA,
	MARTELL,
	DESTRAL;
}

public class EstadistiquesCombat {
	private double forca;
	private TipusArma tipusArma;
	
	public EstadistiquesCombat(double forca, TipusArma tipusArma) {
		super();
		this.forca = forca;
		this.tipusArma = tipusArma;
	}

	public double getForca() {
		return forca;
	}

	public void setForca(double forca) {
		this.forca = forca;
	}

	public TipusArma getTipusArma() {
		return tipusArma;
	}

	public void setTipusArma(TipusArma tipusArma) {
		this.tipusArma = tipusArma;
	}
	
	
	
}
