package mokepon;

import java.util.ArrayList;


public class ArrayListCircular<T> extends ArrayList<T>{
   
    @Override
    public T get(int index) {
    	int mida = this.size();
        index = ((index % mida) + mida ) % mida;
        return super.get(index);
    }
}

