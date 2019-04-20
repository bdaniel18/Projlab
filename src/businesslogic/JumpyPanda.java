package businesslogic;

/**
 * Olyan panda, ami a csokiautomata sípolásától ugrik egyet.
 */
public class JumpyPanda extends Panda{

    public JumpyPanda(){
    }

    /**
     * Csokiautomata aktiválódott szomszédos mezőn.
     */
    public void cmActivated(){
        jump();
    }

    /**
     * A panda ugrik egyet.
     */
    private void jump(){
        getField().pandaJumped(this);
    }

    public String toString() {
        return "Panda " + getId() + ", type: jumpy" + ", host ID:" + getField().getId();
    }
}
