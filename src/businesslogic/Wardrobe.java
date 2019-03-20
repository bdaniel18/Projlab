package businesslogic;

import java.util.HashMap;
import java.util.Map;

public class Wardrobe extends  FieldElement {

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

    /*Valamelyik szomszédos szabad mezőre rakja a kapott Orangutant*/
    boolean receive(Orangutan o) {
        DepthWriter dw = new DepthWriter("Wardrobe.receive(o: Orangutan)");
        dw.add();
        targetField.put(o,getField().getNeighbour(0));
        return targetField.get(o).accept(o);
    }
    /*Valamelyik szomszédos szabad mezőre rakja a kapott Pandat, ha elfogott panda akkor az orangutanhoz tartozó mezőre rakja azt*/
    boolean receive(Panda p){
        DepthWriter dw = new DepthWriter("Wardrobe.receive(p: Panda)");
        dw.add();
        if(p.getCatcher() == null){
            return getField().getNeighbour(0).accept(p);
        }
        else return getTargetField().get(p.getCatcher()).accept(p);
    }

    /*Wardrobenak neki ment egy panda*/
    @Override
    public boolean hitBy(Panda p) {
        DepthWriter dw = new DepthWriter("Wardrobe.hitBy(p: Panda)");
        dw.add();
        return target.receive(p);
    }
    /*Wardrobenak neki ment egy Oranguran*/
    @Override
    public boolean hitBy(Orangutan o) {
        DepthWriter dw = new DepthWriter("Wardrobe.hitBy(o: Orangutan)");
        dw.add();
        return target.receive(o);

    }

}
