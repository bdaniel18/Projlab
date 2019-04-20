package businesslogic;

/**
 * Elfáradó panda, ami ha mellette fotel aktiválódik, és fáradt, beleül.
 */
public class SleepyPanda extends Panda {

    public SleepyPanda() {
    }

    /**
     * Szomszédos mezőn fotel van.
     * @param s a szomszédos fotel
     * @return beleült-e a fotelbe
     */
    public boolean sofaActivated(Sofa s) {
        System.out.println("MESSAGE: Activateable " + s.getId() + "(Sofa) was activated.");
        System.out.println("MESSAGE: Panda " + getId() + " sat down on Field " + s.getField().getId());
        sleep(s);
        return true; //Always sits in
    }

    /**
     * A panda beleül a fotelbe egy körre
     * @param s a fotel
     */
    private void sleep(Sofa s) {
        if (getAnterior() != null) getAnterior().releaseFollower();
        releaseBoth();
        s.sit(this);
        getField().remove(this);
    }

    public String toString() {
        return "Panda " + getId() + ", type: sleepy" + ", host ID:" + getField().getId();
    }
}
