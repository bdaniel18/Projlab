package businesslogic;

public class GamblingMachine extends Activateable {

    public GamblingMachine() {
        DepthWriter.add();
        DepthWriter.print("GamblingMachine CTOR");
        DepthWriter.reduce();
    }

    public void activate() {
        DepthWriter.add();
        DepthWriter.print("GamblingMachine.activate()");

        random();
        getField().scareNeighbours();
        DepthWriter.reduce();
    }
}
