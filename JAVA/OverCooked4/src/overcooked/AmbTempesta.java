package overcooked;

public class AmbTempesta implements DecoradorAmbient{

	private DecoradorAmbient ambientDecorat;
	
	public AmbTempesta(DecoradorAmbient ambient) {
		this.ambientDecorat = ambient;
	};
	
	@Override
	public double getModificadorDesgastCuiner() {
		// TODO Auto-generated method stub
		return ambientDecorat.getModificadorDesgastCuiner() * 1.5;
	}

	@Override
	public double getModificadorPacienciaClient() {
		// TODO Auto-generated method stub
		return ambientDecorat.getModificadorPacienciaClient() * 0.7;
	}

}
