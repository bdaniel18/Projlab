package businesslogic;

import test.DepthWriter;

/**
 * Ijedős panda , aki megijed a játékgép csilingelésétől.
 */
public class CowardPanda extends Panda{

    public CowardPanda(){
        DepthWriter.add();
        DepthWriter.print("CowardPanda CTOR");
        DepthWriter.reduce();
    }

    /**
     * A szomszédos mezőn játékgép aktiválódott(csilingel).
     */
    public void gmActivated(){
        DepthWriter.add();
        DepthWriter.print("CowardPanda.gmActivated()");
        scared();
        DepthWriter.reduce();
    }

    /**
     * A panda megijedt, tehát ugrik egyet a mezőjén.
     */
    public void scared(){
        DepthWriter.add();
        DepthWriter.print("CowardPanda.scared()");
        DepthWriter.reduce();

        releaseBoth();
        releaseFollower();
    }
}
