package businesslogic;

import test.DepthWriter;

/**
 * Elfáradó panda, ami ha mellette fotel aktiválódik, és fáradt, beleül.
 */
public class SleepyPanda extends Panda {

    public SleepyPanda(){
        DepthWriter.add();
        DepthWriter.print("SleepyPanda CTOR");
        DepthWriter.reduce();
    }

    /**
     * Szomszédos mezőn fotel van.
     * @param s a szomszédos fotel
     * @return beleült-e a fotelbe
     */
    public boolean sofaActivated(Sofa s) {
        DepthWriter.add();
        DepthWriter.print("SleepyPanda.sofaActivated()");
        DepthWriter.reduce();

        sleep(s);
        return false; //default return value
    }

    /**
     * A panda beleül a fotelbe egy körre
     * @param s a fotel
     */
    private void sleep(Sofa s) {
        DepthWriter.add();
        DepthWriter.print("SleepyPanda.sleep()");
        DepthWriter.reduce();

        releaseFollower();
        releaseBoth();
        s.sit(this);
        getField().remove(this);
    }
}
