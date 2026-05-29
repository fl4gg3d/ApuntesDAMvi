package isaacSolucio;

public class SoyMilkTear extends TearDecorada {

    public SoyMilkTear(Tear tear) {
        super(tear);
    }

    @Override
    public double getAtk() {
        return tear.getAtk() * 2;
    }

    @Override
    public double getSize() {
        return tear.getSize() * 0.2;
    }
}
