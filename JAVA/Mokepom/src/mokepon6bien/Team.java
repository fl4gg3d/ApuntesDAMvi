package mokepon6bien;

import java.util.ArrayList;

public class Team<T extends mokepon> extends ArrayList<T>{
	  @Override
	    public boolean add(T m) {

	        if (this.size() >= 6) {
	            System.out.println("El equipo ya tiene 6 Mokepon.");
	            return false;
	        }

	        return super.add(m);
	    }
}
