package businesslogic;


public abstract class Activateable extends FieldElement {


    public Activateable() {
        DepthWriter.add();
        DepthWriter.print("Activateable CTOR");
        DepthWriter.reduce();
    }

    public abstract void activate();

    /**
     * Meghívása után generál egy véletlen számot, és ettől függően igaz, vagy hamis értéket ad
     *
     * @return 1/2 valószínűséggel igaz, vagy hamis véletlen érték.
     */
    public boolean random() {
        DepthWriter.add();
        DepthWriter.print("Activateable.random()");
        DepthWriter.reduce();
        return false; //default return value
    }
}
