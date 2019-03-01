package businesslogic;

public abstract class Activateable extends FieldElement {

    public Activateable() {
        System.out.println("Activateable CTOR");
    }

    public abstract void activate();

    public boolean random() {
        System.out.println("Activateable.random()");
        return false; //default return value
    }
}
