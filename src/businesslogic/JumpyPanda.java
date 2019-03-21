package businesslogic;

public class JumpyPanda extends Panda{

    public JumpyPanda(){
        System.out.println("JumpyPanda CTOR");
    }

    public void cmActivated(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("JumpyPanda.cmActivated()");
        DepthWriter.reduce();
    }

    private void jump(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("JumpyPanda.jump()");
        DepthWriter.reduce();
    }
}
