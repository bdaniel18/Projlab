package businesslogic;

/**
 * Elfáradó panda, ami ha mellette fotel aktiválódik, és fáradt, beleül.
 */
public class SleepyPanda extends Panda {

    private boolean slept = false;

    public SleepyPanda() {
    }

    /**
     * Szomszédos mezőn fotel van.
     * @param s a szomszédos fotel
     * @return beleült-e a fotelbe
     */
    public boolean sofaActivated(Sofa s) {
        if (!slept) sleep(s);
        slept = !slept;
        return true; //Always sits in
    }

    /**
     * A panda beleül a fotelbe egy körre
     * @param s a fotel
     */
    private void sleep(Sofa s) {
        System.out.println("MESSAGE: Panda " + getId() + " sat down on Field " + s.getField().getId() + ".");
        if (getAnterior() != null) getAnterior().releaseFollower();
        releaseBoth();
        s.sit(this);
        getField().remove(this);
    }

    public String toString() {
        return "Panda " + getId() + ", type: sleepy" + ", host ID:" + getField().getId();
    }
}
