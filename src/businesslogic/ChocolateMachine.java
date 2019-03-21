package businesslogic;

public class ChocolateMachine extends Activateable {

    public ChocolateMachine() {
        System.out.println("ChocolateMachine CTOR");
    }

    public void activate() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("ChocolateMachine.activate()");

        DepthWriter.reduce();
    }
}
