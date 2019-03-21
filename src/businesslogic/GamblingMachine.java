package businesslogic;

public class GamblingMachine extends Activateable {

    public GamblingMachine() {
        System.out.println("GamblingMachine CTOR");
    }

    public void activate() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("GamblingMachine.activate()");
        DepthWriter.reduce();
    }
}
