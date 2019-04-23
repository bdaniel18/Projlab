package businesslogic;

/**
 * Ijedős panda , aki megijed a játékgép csilingelésétől.
 */
public class CowardPanda extends Panda{

    public CowardPanda() {
    }

    /**
     * A szomszédos mezőn játékgép aktiválódott(csilingel).
     */
    public void gmActivated(){
        scared();
    }

    /**
     * A panda megijedt, tehát ugrik egyet a mezőjén.
     */
    public void scared(){
        System.out.println("MESSAGE: Panda " + getId() + " got scared on Field " + getField().getId() + ".");
        releaseBoth();
        releaseFollower();
    }

    /**
     * @return Az objektum tulajdonságai stringként
     */
    public String toString() {
        return "Panda " + getId() + ", type: coward" + ", host ID:" + getField().getId();
    }
}
