package businesslogic;

import java.util.HashMap;
import java.util.Map;

/**
 * Szekrény osztály, továbbítja a belelépő Steppableket egy másik szekrénynek.
 */
public class Wardrobe extends FieldElement {

    private Wardrobe target; // a célszekrény
    private Map<Orangutan, Field> targetField; // adott orángutánhoz a mező, amire az orángutánt utoljára rakta.

    public Wardrobe() {
        target = null;
        targetField = new HashMap<Orangutan, Field>();
    }

    public void setTarget(Wardrobe target) {
        this.target = target;
    }

    public Wardrobe getTarget() {
        return target;
    }

    public void setTargetField(Map<Orangutan, Field> targetField) {
        this.targetField = targetField;
    }

    public Map<Orangutan, Field> getTargetField() {
        return targetField;
    }

    /**
     * Valamelyik szomszédos szabad mezőre rakja a kapott Orangutant
     * @param o: Orangutan
     * @return a lépés sikeressége
     */
    public boolean receive(Orangutan o) {
        targetField.put(o, getField().getNeighbour(0));
        boolean temp = targetField.get(o).accept(o);
        return temp;
    }

    /**
     * Valamelyik szomszédos szabad mezőre rakja a kapott Pandat,
     * ha elfogott panda akkor az orangutanhoz tartozó mezőre rakja azt
     * @param p: Panda
     * @return a lépés sikeressége
     */
    public boolean receive(Panda p) {
        if (p.getCatcher() == null) {
            boolean temp = getField().getNeighbour(0).accept(p);
            return temp;
        } else {
            boolean temp = getTargetField().get(p.getCatcher()).accept(p);
            return temp;
        }
    }

    /**
     * Paraméterként kapott Pandat elküldi a vele össszekötött szekrényhez
     * @param p: Panda
     * @return a lépés sikeressége
     */
    @Override
    public boolean hitBy(Panda p) {
        boolean temp = target.receive(p);
        return temp;
    }

    /**
     * Paraméterként kapott Orangutant elküldi a vele össszekötött szekrényhez
     * @param o: Orangutan
     * @return a lépés sikeressége
     */
    @Override
    public boolean hitBy(Orangutan o) {
        boolean temp = target.receive(o);
        return temp;
    }

    public String toString() {
        return "Wardrobe " + getId() + ",target ID: " + target.getId() + ",target Field ID: "
                + target.getField().getId() + ",host ID: " + getField().getId();
    }

    @Override
    public void printIfWardrobe() {
        System.out.println(toString());
    }

}
