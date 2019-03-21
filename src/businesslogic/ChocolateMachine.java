package businesslogic;

public class ChocolateMachine extends Activateable {

    public ChocolateMachine() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("ChocolateMachine CTOR");
        DepthWriter.reduce();
    }

    public void activate() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("ChocolateMachine.activate()");

        random();
        getField().jumpNeighbours();
        DepthWriter.reduce();
    }
}
