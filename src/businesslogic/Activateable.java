package businesslogic;

import java.util.Random;

/**
 * Aktiválható pályaelem, absztrakt osztály
 */
public abstract class Activateable extends FieldElement {


    public Activateable() {
    }
    public abstract void activate();

    /**
     * Meghívása után generál egy véletlen számot, és ettől függően igaz, vagy hamis értéket ad
     *
     * @return 1/2 valószínűséggel igaz, vagy hamis véletlen érték.
     */
    public boolean random() {
        if (Game.getInstance().getTestMode()) return true;

        Random rand = new Random();
        int n = rand.nextInt(50);
        if (n > 24) return true;
        else return false;
    }

    /**
     * Visszaadja az objektum tulajdonságait
     *
     * @return a tulajdonságok stringje
     */
    public abstract String toString();
}
