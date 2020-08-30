package businesslogic;

/**
 * Elfáradó panda, ami ha mellette fotel aktiválódik, és fáradt, beleül.
 */
public class SleepyPanda extends Panda {

    private boolean sleptLastTime = false;

    public SleepyPanda() {
    }

    public void sleptThisTurn() {
        sleptLastTime = true;
    }


    /**
     * Szomszédos mezőn fotel van.
     * @param s a szomszédos fotel
     * @return beleült-e a fotelbe
     */
    public boolean sofaActivated(Sofa s) {
        if (!sleptLastTime) {
            sleep(s);
            return true;
        }
        sleptLastTime = false;
        return false;
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
        setField(null);
        sleptLastTime = true;
    }

    public String toString() {
        return "Panda " + getId() + ", type: sleepy" + ", host ID:" + getField().getId();
    }
}
