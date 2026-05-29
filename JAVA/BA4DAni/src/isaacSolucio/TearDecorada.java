package isaacSolucio;

public abstract class TearDecorada implements Tear {

    protected Tear tear;

    public TearDecorada(Tear tear) {
        super();
        this.tear = tear;
    }
    @Override
    public void setAtk(double atk) {
        tear.setAtk(atk);
    }

    @Override
    public void setSize(double size) {
        tear.setSize(size);
    }
}
