package businesslogic;

import test.DepthWriter;

/**
 * Csokoládéautomata, néha aktiválódik, ilyenkor sípol.
 */
public class ChocolateMachine extends Activateable {

    public ChocolateMachine() {
        DepthWriter.add();
        DepthWriter.print("ChocolateMachine CTOR");
        DepthWriter.reduce();
    }

    /**
     * Az automata sípol, amit jelez a mezőjének.
     */
    public void activate() {
        DepthWriter.add();
        DepthWriter.print("ChocolateMachine.activate()");

        random();
        getField().jumpNeighbours();
        DepthWriter.reduce();
    }
}
