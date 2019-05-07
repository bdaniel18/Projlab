package businesslogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Szekrény osztály, továbbítja a belelépő Steppableket egy másik szekrénynek.
 */
public class Wardrobe extends FieldElement {

    private Wardrobe target; // a célszekrény
    private Map<Orangutan, Field> targetField; // adott orángutánhoz a mező, amire az orángutánt utoljára rakta.

    public Wardrobe() {
        target = null;
        targetField = new HashMap<>();
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
        System.out.println("MESSAGE: Orangutan " + o.getId() + " stepped out from Wardrobe " + getId() + ".");
        ArrayList<Field> neighbours = new ArrayList<>();
        for (int i = 0; i < getField().getNeighbourNumber(); i++) {
            Field f = getField().getNeighbour(i);
            if (f.getFieldElement() == null) neighbours.add(f);
        }

        Random random = new Random();
        while (neighbours.size() > 0) {
            int a = random.nextInt(neighbours.size());
            Field f = neighbours.remove(a);

            if (f.accept(o)) {
                if (targetField.containsKey(o)) {
                    targetField.replace(o, f);
                } else {
                    targetField.put(o, f);
                }

                return true;
            }
        }
        return false;
    }

    /**
     * Valamelyik szomszédos szabad mezőre rakja a kapott Pandat,
     * ha elfogott panda akkor az orangutanhoz tartozó mezőre rakja azt
     * @param p: Panda
     * @return a lépés sikeressége
     */
    public boolean receive(Panda p) {
        System.out.println("MESSAGE: Panda " + p.getId() + " stepped out from Wardrobe " + getId() + ".");
        if (p.getCatcher() == null) {
            ArrayList<Field> neighbours = new ArrayList<>();
            for (int i = 0; i < getField().getNeighbourNumber(); i++) {
                Field f = getField().getNeighbour(i);
                if (f.getFieldElement() == null) neighbours.add(f);
            }

            Random random = new Random();
            while (neighbours.size() > 0) {
                int a = random.nextInt(neighbours.size());
                Field f = neighbours.remove(a);
                if (f.accept(p)) {

                    return true;
                }
            }
        } else {
            Field f = targetField.get(p.getCatcher());
            if (f.accept(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Paraméterként kapott Pandat elküldi a vele össszekötött szekrényhez
     * @param p: Panda
     * @return a lépés sikeressége
     */
    @Override
    public boolean hitBy(Panda p) {
        System.out.println("MESSAGE: Panda " + p.getId() + " stepped into Wardrobe " + getId() + ".");
        if (target.receive(p)) return true;
        System.out.println("MESSAGE: Panda " + p.getId() + " stepped out from Wardrobe " + getId() + ".");
        return false;
    }

    /**
     * Paraméterként kapott Orangutant elküldi a vele össszekötött szekrényhez
     * @param o: Orangutan
     * @return a lépés sikeressége
     */
    @Override
    public boolean hitBy(Orangutan o) {
        System.out.println("MESSAGE: Orangutan " + o.getId() + " stepped into Wardrobe " + getId() + ".");
        if (target.receive(o)) return true;
        System.out.println("MESSAGE: Orangutan " + o.getId() + " stepped out from Wardrobe " + getId() + ".");
        return false;
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
