package mokepon6bien;

public class Trio<T> {
	private T primer;
    private T segon;
    private T tercer;

    public Trio(T primer, T segon, T tercer) {
        this.primer = primer;
        this.segon = segon;
        this.tercer = tercer;
    }

    public T getPrimer() {
        return primer;
    }

    public T getSegon() {
        return segon;
    }

    public T getTercer() {
        return tercer;
    }

    public void setPrimer(T primer) {
        this.primer = primer;
    }

    public void setSegon(T segon) {
        this.segon = segon;
    }

    public void setTercer(T tercer) {
        this.tercer = tercer;
    }

    @Override
    public String toString() {
        return "[" + primer + ", " + segon + ", " + tercer + "]";
    }
}
