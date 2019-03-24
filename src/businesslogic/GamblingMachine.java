package businesslogic;

/**
 * Játékgép, néha sípol és megijeszti a szomszédok cellákon állókat
 */
public class GamblingMachine extends Activateable {

    public GamblingMachine() {
        DepthWriter.add();
        DepthWriter.print("GamblingMachine CTOR");
        DepthWriter.reduce();
    }

    /**
     * Aktiválódik és megijeszti a szomszédoks cellákon állókat
     * Random szám alapján aktiválódik és fejti ki hatását
     */
    public void activate() {
        DepthWriter.add();
        DepthWriter.print("GamblingMachine.activate()");

        random();
        getField().scareNeighbours();
        DepthWriter.reduce();
    }
}
