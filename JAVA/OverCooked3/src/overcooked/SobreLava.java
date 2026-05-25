package overcooked;

public class SobreLava implements DecoradorAmbient{
	private DecoradorAmbient ambientDecorat;
	
	public SobreLava(DecoradorAmbient ambient) {
		this.ambientDecorat = ambient;
	}

	@Override
	public double getModificadorDesgastCuiner() {
		// TODO Auto-generated method stub
		return ambientDecorat.getModificadorDesgastCuiner()*2.0;
	}

	@Override
	public double getModificadorPacienciaClient() {
		// TODO Auto-generated method stub
		return ambientDecorat.getModificadorDesgastCuiner()*0.8;
	}
}
