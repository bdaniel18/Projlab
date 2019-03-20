package businesslogic;

public class JumpyPanda extends Panda{

    public JumpyPanda(){
        //System.out.println("JumpyPanda CTOR");
    }

    public void cmActivated(){
        System.out.println("JumpyPanda.cmActivated()");
    }

    private void jump(){
        System.out.println("JumpyPanda.jump()");
    }
}
