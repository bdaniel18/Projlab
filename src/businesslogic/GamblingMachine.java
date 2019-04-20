package businesslogic;

/**
 * Játékgép, néha sípol és megijeszti a szomszédok cellákon állókat
 */
public class GamblingMachine extends Activateable {

    public GamblingMachine() {
    }

    /**
     * Aktiválódik és megijeszti a szomszédoks cellákon állókat
     * Random szám alapján aktiválódik és fejti ki hatását
     */
    public void activate() {
        if(random()) {
            System.out.println("Activateable " + getId() + "(GamblingMachine) was activated.");
            getField().scareNeighbours();
        }
    }

    public String toString() {
        return "Activateable " + getId() + ",type: GamblingMachine, host ID: " + getField().getId();
    }
}
