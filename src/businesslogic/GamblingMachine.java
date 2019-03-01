package businesslogic;

public class GamblingMachine extends Activateable {

    public GamblingMachine() {
        System.out.println("GamblingMachine CTOR");
    }

    public void activate() {
        System.out.println("GamblingMachine.activate()");
    }
}
