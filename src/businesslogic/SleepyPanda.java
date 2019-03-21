package businesslogic;

public class SleepyPanda extends Panda {

    public SleepyPanda(){
        System.out.println("SleepyPanda CTOR");
    }

    public boolean sofaActivated(Sofa s) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("SleepyPanda.sofaActivated()");
        DepthWriter.reduce();
        return false; //default return value
    }

    private void sleep(Sofa s) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("SleepyPanda.sleep()");
        DepthWriter.reduce();
    }
}
