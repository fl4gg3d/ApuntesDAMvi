package isaacSolucio;

public class Cuca extends Enemic {

    public Cuca(int hp, int punts) {
        super(hp, punts);
    }

    @Override
    public void danyar(int dany) {
        this.hp -= dany;
        if (this.hp <= 0) {
            notifyObservers();
        }
    }

    @Override
    public String toString() {
        return "Cuca " + super.toString();
    }
}
