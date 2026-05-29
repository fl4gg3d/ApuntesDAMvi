package isaacSolucio;

public class SacredHeartTear extends TearDecorada {

    public SacredHeartTear(Tear tear) {
        super(tear);
    }

    @Override
    public double getAtk() {
        return tear.getAtk() * 1.2;
    }

    @Override
    public double getSize() {
        return tear.getSize();
    }
}
