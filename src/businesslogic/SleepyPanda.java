package businesslogic;

public class SleepyPanda extends Panda {

    public SleepyPanda(){
        System.out.println("SleepyPanda CTOR");
    }

    public void sofaActivated(Sofa s){
        System.out.println("SleepyPanda.sofaActivated()");
    }

    public void sleep (Sofa s){
        System.out.println("SleepyPanda.sleep()");
    }
}
