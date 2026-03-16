package mokepon6bien;

public class Parella<T> {

    private T primer;
    private T segon;

    // Constructor vacío
    public Parella() {}

    // Constructor con valores
    public Parella(T primer, T segon) {
        this.primer = primer;
        this.segon = segon;
    }

    public T getPrimer() {
        return primer;
    }

    public void setPrimer(T primer) {
        this.primer = primer;
    }

    public T getSegon() {
        return segon;
    }

    public void setSegon(T segon) {
        this.segon = segon;
    }

    @Override
    public String toString() {
        return "[" + primer + ", " + segon + "]";
    }
}
