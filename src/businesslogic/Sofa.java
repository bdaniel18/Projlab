package businesslogic;

import test.DepthWriter;

/**
 * Fotel osztály, ülhet benne egy panda egyszerre, amit tárol.
 * Minden körben aktiválódik.
 */
public class Sofa extends Activateable {

    private Panda panda; // a fotelben ülő panda

    public Sofa() {
        DepthWriter.add();
        DepthWriter.print("Sofa CTOR");
        DepthWriter.reduce();
    }

    public void setPanda(Panda panda) {
        DepthWriter.add();
        DepthWriter.print("Sofa.setPanda()");
        DepthWriter.reduce();
        this.panda = panda;
    }

    public Panda getPanda() {
        DepthWriter.add();
        DepthWriter.print("Sofa.getPanda()");
        DepthWriter.reduce();
        return panda;
    }

    /**
     * Egy álmos panda beleül a fotelbe.
     * @param p Panda
     */
    public void sit(Panda p) {
        DepthWriter.add();
        DepthWriter.print("Sofa.sit()");
        DepthWriter.reduce();
        panda = p;
    }

    /**
     * A fotel, ha ül benne panda megpróbálja továbbítani szomszédos mezőre,
     * ha üressé vált, szól a mezőjének hogy aktiválódott.
     */
    public void activate() {
        DepthWriter.add();
        DepthWriter.print("Sofa.activate()");
        int i = 0;
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
        DepthWriter.reduce();
    }
}
