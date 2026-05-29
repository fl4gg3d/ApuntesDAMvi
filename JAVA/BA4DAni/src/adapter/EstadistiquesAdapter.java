package adapter;

public class EstadistiquesAdapter implements DanyProvider{
	private EstadistiquesCombat stats;

	public EstadistiquesAdapter(EstadistiquesCombat stats) {
		super();
		this.stats = stats;
	}

	@Override
	public int getDany() {
		double forca = stats.getForca();
		switch(stats.getTipusArma()) {
		case ESPASA:
			forca=forca*1.5;
			break;
		case MARTELL:
			forca=forca*3.2;
			break;
		case DESTRAL:
			forca=forca*1.8;
			break;
		default:
			break;
		}
		System.out.println("Força calculada: "+forca);
		return (int)(forca);
	}

	@Override
	public String toString() {
		return "EstadistiquesAdapter [getDany()=" + getDany() + "]";
	}
	
	
}
