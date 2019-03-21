package businesslogic;

public class GamblingMachine extends Activateable {

    public GamblingMachine() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("GamblingMachine CTOR");
        DepthWriter.reduce();
    }

    public void activate() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("GamblingMachine.activate()");
        DepthWriter.reduce();
    }
}
