package matrius;

public class EstimadaMatriu {

	public static void main(String[] args) {
		
		//mat.lenght -> Filas
		//mat[0].length -> Columnes
		//en una funcion da igual el nombre que declares dentro, si al llamar la 
		//funcion pones el nombre de la "matriu" en este caso, lo hara con el nombre 
		//de la matriu
		
		
		//hacer funcion para no repetir para que el codigo no sea largo de cojones 
		
		int[][] mat = new int [5][4];
		
		omplirMatriu(mat);
		printarMatriu(mat);
	}

	private static void printarMatriu(int[][] mat) {
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.println(mat[i][j]);
			}
		}
	}

	private static void omplirMatriu(int[][] mat) {
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				mat[i][j]=7;
			}
		}
		
	}

}
