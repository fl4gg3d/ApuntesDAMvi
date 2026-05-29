package factoryMethod;

public class MainJoc {

	public static void main(String[] args) {
	
		Joc j1 = new JocGuerrers();
		j1.jugar();
		
		Joc j2 = new JocArquers();
		j2.jugar();

	}

}
