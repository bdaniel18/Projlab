package businesslogic;

import java.util.HashMap;
import java.util.Map;

public class Wardrobe extends FieldElement {

    private Wardrobe target;
    private Map<Orangutan, Field> targetField;

    public Wardrobe() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe CTOR");
        DepthWriter.reduce();
        target = null;
        targetField = new HashMap<Orangutan, Field>();
    }

    public void setTarget(Wardrobe target) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe.setTarget()");
        DepthWriter.reduce();
        this.target = target;
    }

    public Wardrobe getTarget() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe.getTarget()");
        DepthWriter.reduce();
        return target;
    }

    public void setTargetField(Map<Orangutan, Field> targetField) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe.setTargetField()");
        DepthWriter.reduce();
        this.targetField = targetField;
    }

    public Map<Orangutan, Field> getTargetField() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe.getTargetField()");
        DepthWriter.reduce();
        return targetField;
    }

    /*Valamelyik szomszédos szabad mezőre rakja a kapott Orangutant*/
    boolean receive(Orangutan o) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe.receive(Orangutan)");
        targetField.put(o, getField().getNeighbour(0));
        boolean temp = targetField.get(o).accept(o);

        DepthWriter.reduce();
        return temp;
    }

    /*Valamelyik szomszédos szabad mezőre rakja a kapott Pandat, ha elfogott panda akkor az orangutanhoz tartozó mezőre rakja azt*/
    boolean receive(Panda p) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe.receive(Panda)");
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

    /*Wardrobenak neki ment egy panda*/
    @Override
    public boolean hitBy(Panda p) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe.hitBy(Panda)");
        boolean temp = target.receive(p);
        DepthWriter.reduce();
        return temp;
    }

    /*Wardrobenak neki ment egy Oranguran*/
    @Override
    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Wardrobe.hitBy(Orangutan)");
        boolean temp = target.receive(o);
        DepthWriter.reduce();
        return temp;

    }

}
