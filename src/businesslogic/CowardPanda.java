package businesslogic;

public class CowardPanda extends Panda{

    public CowardPanda(){
        System.out.println("CowardPanda CTOR");
    }

    public void gmActivated(){
        System.out.println("CowardPanda.gmActivated()");
    }

    public void scared(){
        System.out.println("CowardPanda.scared()");
    }
}
