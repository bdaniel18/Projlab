package businesslogic;

import test.DepthWriter;

public class SleepyPanda extends Panda {

    public SleepyPanda(){
        DepthWriter.add();
        DepthWriter.print("SleepyPanda CTOR");
        DepthWriter.reduce();
    }

    public boolean sofaActivated(Sofa s) {
        DepthWriter.add();
        DepthWriter.print("SleepyPanda.sofaActivated()");
        DepthWriter.reduce();

        sleep(s);

        return false; //default return value
    }

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
