package businesslogic;

/**
 * Fotel osztály, ülhet benne egy panda egyszerre, amit tárol.
 * Minden körben aktiválódik.
 */
public class Sofa extends Activateable {

    private Panda panda; // a fotelben ülő panda

    public Sofa() {
        panda = null;
    }

    public void setPanda(Panda panda) {
        this.panda = panda;
    }

    public Panda getPanda() {
        return panda;
    }

    /**
     * Egy álmos panda beleül a fotelbe.
     * @param p Panda
     */
    public void sit(Panda p) {
        panda = p;
    }

    /**
     * A fotel, ha ül benne panda megpróbálja továbbítani szomszédos mezőre,
     * ha üressé vált, szól a mezőjének hogy aktiválódott.
     */
    public void activate() {
        int i = 0;
        System.out.println("MESSAGE: Activateable " + getId() + "(Sofa) was activated.");
        while (panda != null) {
            Field temp = getField().getNeighbour(i);
            if (temp == null) return;         //nincs üres szomszédos mező
            FieldElement fe = temp.getFieldElement();
            if (fe == null) {
                temp.accept(panda);
                break;
            }
            i++;
        }
        getField().sleepNeighbours(this);
    }

    public String toString() {
        return "Activateable " + getId() + ",type: Sofa, host ID: " + getField().getId();
    }
}
