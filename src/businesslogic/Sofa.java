package businesslogic;

public class Sofa extends Activateable {

    private Panda panda;

    public Sofa() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Sofa CTOR");
        DepthWriter.reduce();
    }

    public void setPanda(Panda panda) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Sofa.setPanda()");
        DepthWriter.reduce();
        this.panda = panda;
    }

    public Panda getPanda() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Sofa.getPanda()");
        DepthWriter.reduce();
        return panda;
    }

    public void sit(Panda p) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Sofa.sit()");
        DepthWriter.reduce();
    }

    public void activate() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Sofa.activate()");
        DepthWriter.reduce();
    }
}
