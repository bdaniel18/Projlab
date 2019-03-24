package businesslogic;

public class JumpyPanda extends Panda{

    public JumpyPanda(){
        DepthWriter.add();
        DepthWriter.print("JumpyPanda CTOR");
        DepthWriter.reduce();
    }

    public void cmActivated(){
        DepthWriter.add();
        DepthWriter.print("JumpyPanda.cmActivated()");
        DepthWriter.reduce();

        jump();
    }

    private void jump(){
        DepthWriter.add();
        DepthWriter.print("JumpyPanda.jump()");
        DepthWriter.reduce();

        getField().pandaJumped(this);
    }
}
