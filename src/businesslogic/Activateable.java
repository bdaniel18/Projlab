package businesslogic;

public abstract class Activateable extends FieldElement {

    public Activateable() {
        System.out.println("Activateable CTOR");
    }

    public abstract void activate();

    public boolean random() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Activateable.random()");
        DepthWriter.reduce();
        return false; //default return value
    }
}
