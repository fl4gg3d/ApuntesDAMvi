package mokepon;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Mokepon8Main {

	public static void main(String[] args) throws Exception {

		Pocio p = new Pocio("curadora", 100);
		afegirObjecte(p);
		Reviure r = new Reviure("Elixir");
		afegirObjecte(r);
		Objecte obj = recuperarObjecte();
		System.out.println(obj);

		ArrayList<Objecte> llistaObjectes = recuperaObjectes();
		System.out.println(llistaObjectes);

		Pocio pConreta = recuperaPocioConcreta(100);
		System.out.println(pConreta);

		MokeponCapturat mok = new MokeponCapturat("Charmander", 20, 60, 3, 5, 40);
		afegeixMokepon(mok);
		MokeponCapturat mokRec = recuperarMokepon("Charmander", 20, "Dani", "Charmander" );
		System.out.println(mokRec);
		
		teamMocketAtacaDeNou();
		MokeponCapturat mokRec2 = recuperarMokepon("Charmander", 20, "Team Mocket", "Charmander" );
		System.out.println(mokRec2);
	}

	private static void teamMocketAtacaDeNou() {
		
		try {

			File f = new File("mokepons.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			File f2 = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(f2, true);
			AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos, true);
			try {
				while (true) {
					Object o = ois.readObject();

					if (o instanceof MokeponCapturat) {
						MokeponCapturat m = (MokeponCapturat) o;
						m.setNomEntrenador("Team Mocket");
						oos.writeObject(m);
					}
				}
			} catch (EOFException e) {
				System.out.println("Final de fitxer, tutto bene");
				oos.flush();
				oos.close();
				ois.close();
				f.delete();
				f2.renameTo(f);

			}
		} catch (

		FileNotFoundException e) {
			System.out.println("no existeix el fitxer");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("excepció d'entrada/sortida");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("no s'ha trobat la classe demanada");
			e.printStackTrace();
		}

	}

	private static MokeponCapturat recuperarMokepon(String nom, int nivell, String nomEntrenador, String nomDonat) {
		try {

			File f = new File("mokepons.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			File f2 = new File("temp.dat");
			FileOutputStream fos = new FileOutputStream(f2, true);
			AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos, true);

			boolean trobat = false;
			MokeponCapturat mokRetorn = null;
			try {
				while (true) {
					Object o = ois.readObject();

					if (o instanceof MokeponCapturat) {
						MokeponCapturat m = (MokeponCapturat) o;
						if (m.getNom().equals(nom) && m.getNivell() == nivell && m.getNomEntrenador().equals(nomEntrenador) && m.getNomPosat().equals(nomDonat)) {
							trobat = true;
							mokRetorn = m;
						} else {
							oos.writeObject(o);
						}
					}
				}
			} catch (EOFException e) {
				System.out.println("Final de fitxer, tutto bene");
				oos.flush();
				oos.close();
				ois.close();
				f.delete();
				f2.renameTo(f);

			}
			if (trobat) {
				System.out.println("S'ha trobat el MokeponCapturat " + nom);
				return mokRetorn;
			}

		} catch (

		FileNotFoundException e) {
			System.out.println("no existeix el fitxer");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("excepció d'entrada/sortida");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("no s'ha trobat la classe demanada");
			e.printStackTrace();
		}

		return null;
		
	}

	private static void afegeixMokepon(MokeponCapturat mok) throws Exception {

		try {

			File f2 = new File("mokepons.dat");
			FileOutputStream fos = new FileOutputStream(f2, true);
			AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos, true);

			boolean existeix = false;
			if (f2.exists()) {
				File f = new File("mokepons.dat");
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				try {
					while (true) {
						Object o = ois.readObject();

						if (o instanceof MokeponCapturat) {
							MokeponCapturat m = (MokeponCapturat) o;
							if (m.equals(mok)) {

								existeix = true;
								System.out.println("El MokeponCapturat " + m.getNom() + " ja existeix al fitxer");
							}

						}
					}
				} catch (EOFException e) {
					System.out.println("Final de fitxer, tutto bene");
					ois.close();
				}
				if (!existeix) {
					oos.writeObject(mok);
					oos.flush();
					oos.close();
					fos.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("no existeix el fitxer");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("excepció d'entrada/sortida");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("no s'ha trobat la classe demanada");
			e.printStackTrace();
		}

	}

	private static Pocio recuperaPocioConcreta(int n) throws IOException {
		File f = new File("objectes.dat");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {
			while (true) {
				Object o = ois.readObject();
				if (o instanceof Pocio) {
					Pocio p = (Pocio) o;
					if (p.getHp_curada() == n) {
						return p;
					}
				}
			}
		} catch (EOFException e) {
			System.out.println("Lectura finalitzada");
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	private static ArrayList<Objecte> recuperaObjectes() throws IOException {

		File f = new File("objectes.dat");
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		ArrayList<Objecte> llista = new ArrayList<Objecte>();

		try {
			while (true) {
				Object o = ois.readObject();
				if (o instanceof Pocio) {

					Pocio p = (Pocio) o;
					llista.add(p);

				}
				if (o instanceof Reviure) {

					Reviure r = (Reviure) o;
					llista.add(r);

				}
				if (o instanceof Arma) {

					Arma a = (Arma) o;
					llista.add(a);

				}
				if (o instanceof Armadura) {

					Armadura ar = (Armadura) o;
					llista.add(ar);
				}
			}
		} catch (EOFException e) {
			System.out.println("Lectura finalitzada");
			ois.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return llista;
	}

	private static Objecte recuperarObjecte() {
		try {
			File f = new File("objectes.dat");
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fis);

			Object o = ois.readObject();
			ois.close();
			if (o instanceof Pocio) {

				Pocio p = (Pocio) o;
				System.out.println(p);
				return p;
			}
			if (o instanceof Reviure) {

				Reviure r = (Reviure) o;
				System.out.println(r);
				return r;
			}
			if (o instanceof Arma) {

				Arma a = (Arma) o;
				System.out.println(a);
				return a;
			}
			if (o instanceof Armadura) {

				Armadura ar = (Armadura) o;
				System.out.println(ar);
				return ar;
			}
		} catch (FileNotFoundException e) {
			System.out.println("no existeix el fitxer");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("excepció d'entrada/sortida");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("no s'ha trobat la classe demanada");
			e.printStackTrace();
		}
		return null;

	}

	private static void afegirObjecte(Objecte obj) {

		try {
			File f = new File("objectes.dat");
			FileOutputStream fos = new FileOutputStream(f, true);
			AppendableObjectOutputStream oos = new AppendableObjectOutputStream(fos, true);
			oos.writeObject(obj);
			oos.flush();
			oos.close();
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}