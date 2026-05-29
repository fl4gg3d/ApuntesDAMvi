package isaacSolucio;

public class Mosca extends Enemic {

    public Mosca(int hp, int punts) {
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
        return "Mosca " + super.toString();
    }
}
