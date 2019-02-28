package businesslogic;

public class SleepyPanda extends Panda {

    public SleepyPanda(){
        System.out.println("SleepyPanda CTOR");
    }

    public boolean sofaActivated(Sofa s) {
        System.out.println("SleepyPanda.sofaActivated()");
        return false; //default return value
    }

    private void sleep(Sofa s) {
        System.out.println("SleepyPanda.sleep()");
    }
}
