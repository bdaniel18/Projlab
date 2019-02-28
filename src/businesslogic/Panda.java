package businesslogic;

public abstract class Panda extends Steppable{

    private Floor floor;
    private Orangutan catcher;

    public Panda(){
        System.out.print("Panda CTOR");
        floor = null;
        catcher = null;
    }

    public void exitReached(){
        System.out.print("Panda.exitReached()");
    }

    public void step(){
        System.out.print("Panda.step()");
    }

    public boolean hitBy(Orangutan o){
        System.out.print("Panda.hitBy()");
        return false; //default return value
    }
}
