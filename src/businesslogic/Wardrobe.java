package businesslogic;

import java.util.HashMap;
import java.util.Map;

public class Wardrobe {

    private Wardrobe target;
    private Map<Orangutan, Field> targetField;

    public Wardrobe() {
        target = null;
        targetField = new HashMap<Orangutan, Field>();
        System.out.println("Wardrobe CTOR");
    }

    public void setTarget(Wardrobe target) {
        this.target = target;
        System.out.println("Wardrobe.setTarget()");
    }

    public Wardrobe getTarget() {
        System.out.println("Wardrobe.getTarget()");
        return target;
    }

    public void setTargetField(Map<Orangutan, Field> targetField) {
        this.targetField = targetField;
        System.out.println("Wardrobe.setTargetField()");
    }

    public Map<Orangutan, Field> getTargetField() {
        System.out.println("Wardrobe.getTargetField()");
        return targetField;
    }

    boolean receive(Steppable s) {
        DepthWriter dw = new DepthWriter("Wardrobe.receive()");

        return false; //default return value
    }

    boolean hitBy(Panda p) {
        System.out.println("Wardrobe.hitBy()");
        return false; //default return value
    }

    boolean hitBy(Orangutan o) {
        DepthWriter dw = new DepthWriter("Wardrobe.hitBy()");

        dw.add();
        target.receive(o);

        return false; //default return value
    }

}
