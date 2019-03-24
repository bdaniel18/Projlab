package businesslogic;

/**
 * Olyan panda, ami a csokiautomata sípolásától ugrik egyet.
 */
public class JumpyPanda extends Panda{

    public JumpyPanda(){
        DepthWriter.add();
        DepthWriter.print("JumpyPanda CTOR");
        DepthWriter.reduce();
    }

    /**
     * Csokiautomata aktiválódott szomszédos mezőn.
     */
    public void cmActivated(){
        DepthWriter.add();
        DepthWriter.print("JumpyPanda.cmActivated()");
        DepthWriter.reduce();

        jump();
    }

    /**
     * A panda ugrik egyet.
     */
    private void jump(){
        DepthWriter.add();
        DepthWriter.print("JumpyPanda.jump()");
        DepthWriter.reduce();

        getField().pandaJumped(this);
    }
}
