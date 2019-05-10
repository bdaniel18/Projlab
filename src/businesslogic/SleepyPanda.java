package businesslogic;

/**
 * Elfáradó panda, ami ha mellette fotel aktiválódik, és fáradt, beleül.
 */
public class SleepyPanda extends Panda {

    private boolean slept = false;
    private boolean sleeping = false;

    public SleepyPanda() {
    }

    /**
     * Szomszédos mezőn fotel van.
     * @param s a szomszédos fotel
     * @return beleült-e a fotelbe
     */
    public boolean sofaActivated(Sofa s) {
        if (sleeping) return false;
        if (!slept) {
            sleep(s);
            return true;
        }
        slept = !slept;
        return false;
    }

    public void setSleeping(boolean b) {
        sleeping = b;
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
        sleeping = true;
    }

    public String toString() {
        return "Panda " + getId() + ", type: sleepy" + ", host ID:" + getField().getId();
    }
}
