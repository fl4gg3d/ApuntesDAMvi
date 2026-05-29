package isaacSolucio;

public class PolyphemusTear extends TearDecorada {

    public PolyphemusTear(Tear tear) {
        super(tear);
    }

    @Override
    public double getAtk() {
        return tear.getAtk() * 2;
    }

    @Override
    public double getSize() {
        return tear.getSize() * 2;
    }
}
