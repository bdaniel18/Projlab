package businesslogic;

public class JumpyPanda extends Panda{

    public JumpyPanda(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("JumpyPanda CTOR");
        DepthWriter.reduce();
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
