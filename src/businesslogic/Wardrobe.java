package businesslogic;

import test.DepthWriter;

import java.util.HashMap;
import java.util.Map;

/**
 * Szekrény osztály,
 */
public class Wardrobe extends FieldElement {

    private Wardrobe target;
    private Map<Orangutan, Field> targetField;

    public Wardrobe() {
        DepthWriter.add();
        DepthWriter.print("Wardrobe CTOR");
        DepthWriter.reduce();
        target = null;
        targetField = new HashMap<Orangutan, Field>();
    }

    public void setTarget(Wardrobe target) {
        DepthWriter.add();
        DepthWriter.print("Wardrobe.setTarget()");
        DepthWriter.reduce();
        this.target = target;
    }

    public Wardrobe getTarget() {
        DepthWriter.add();
        DepthWriter.print("Wardrobe.getTarget()");
        DepthWriter.reduce();
        return target;
    }

    public void setTargetField(Map<Orangutan, Field> targetField) {
        DepthWriter.add();
        DepthWriter.print("Wardrobe.setTargetField()");
        DepthWriter.reduce();
        this.targetField = targetField;
    }

    public Map<Orangutan, Field> getTargetField() {
        DepthWriter.add();
        DepthWriter.print("Wardrobe.getTargetField()");
        DepthWriter.reduce();
        return targetField;
    }

    /**Valamelyik szomszédos szabad mezőre rakja a kapott Orangutant
     *
     * @param o: Orangutan
     * @return boolean
     */
    public boolean receive(Orangutan o) {
        DepthWriter.add();
        DepthWriter.print("Wardrobe.receive(Orangutan)");
        targetField.put(o, getField().getNeighbour(0));
        boolean temp = targetField.get(o).accept(o);

        DepthWriter.reduce();
        return temp;
    }

    /**
     * Valamelyik szomszédos szabad mezőre rakja a kapott Pandat,
     * ha elfogott panda akkor az orangutanhoz tartozó mezőre rakja azt
     * @param p: Panda
     * @return boolean
     */
    public boolean receive(Panda p) {
        DepthWriter.add();
        DepthWriter.print("Wardrobe.receive(Panda)");
        if (p.getCatcher() == null) {
            boolean temp = getField().getNeighbour(0).accept(p);
            DepthWriter.reduce();
            return temp;
        } else {
            boolean temp = getTargetField().get(p.getCatcher()).accept(p);
            DepthWriter.reduce();
            return temp;
        }
    }

    /**
     * Paraméterként kapott Pandat elküldi a vele össszekötött szekrényhez
     * @param p: Panda
     * @return boolean
     */
    @Override
    public boolean hitBy(Panda p) {
        DepthWriter.add();
        DepthWriter.print("Wardrobe.hitBy(Panda)");
        boolean temp = target.receive(p);
        DepthWriter.reduce();
        return temp;
    }

    /**Paraméterként kapott Orangutant elküldi a vele össszekötött szekrényhez
     *
     * @param o: Orangutan
     * @return boolean
     */
    @Override
    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter.print("Wardrobe.hitBy(Orangutan)");
        boolean temp = target.receive(o);
        DepthWriter.reduce();
        return temp;

    }

}
