package businesslogic;

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
        return false; //default return value
    }

    private void sleep(Sofa s) {
        DepthWriter.add();
        DepthWriter.print("SleepyPanda.sleep()");
        DepthWriter.reduce();
    }
}
