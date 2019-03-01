package businesslogic;

public class Sofa extends Activateable {

    private Panda panda;

    public Sofa() {
        System.out.println("Sofa CTOR");
    }

    public void setPanda(Panda panda) {
        this.panda = panda;
        System.out.println("Sofa.setPanda()");
    }

    public Panda getPanda() {
        System.out.println("Sofa.getPanda()");
        return panda;
    }

    public void sit(Panda p) {
        System.out.println("Sofa.sit()");
    }

    public void activate() {
        System.out.println("Sofa.activate()");
    }
}
