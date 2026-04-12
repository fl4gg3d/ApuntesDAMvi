package mokepon7;

import java.util.ArrayList;

public class ArrayListAcotada<E> extends ArrayList<E>{

	@Override
    public E get(int index) {

        if (this.size() == 0) {
            return null;
        }

        // si el índice es negativo --> primer elemento
        if (index < 0) {
            return super.get(0);
        }

        // si el índice es mayor que el último --> último elemento
        if (index >= this.size()) {
            return super.get(this.size() - 1);
        }

        // si está dentro del rango
        return super.get(index);
    }
	
}
