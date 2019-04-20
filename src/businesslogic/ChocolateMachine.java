package businesslogic;

/**
 * Csokoládéautomata. Néha aktiválódik, ilyenkor sípol.
 */
public class ChocolateMachine extends Activateable {

    public ChocolateMachine() {
    }

    /**
     * Az automata aktiválódik(sípol), amit jelez a mezőjének.
     */
    public void activate() {
        if(random()) {
            System.out.println("MESSAGE: Activateable " + getId() + "(ChocolateMachine) was activated.");
            getField().jumpNeighbours();
        }
    }
}
