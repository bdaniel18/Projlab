package businesslogic;

import java.util.List;
import java.util.ArrayList;

public class Field {

    private FieldElement fieldElement;
    private int durability;
    private boolean fragile;
    private List<Field> neighbours;

    public Field() {
        System.out.println("Field CTOR");
        fieldElement = null;
        durability = 0; //default
        fragile = false; //default
        neighbours = new ArrayList<Field>();
    }

    public void setFieldElement(FieldElement fieldElement) {
        this.fieldElement = fieldElement;
        System.out.println("Field.setFieldElement()");
    }

    public FieldElement getFieldElement() {
        System.out.println("Field.getFieldElement()");
        return fieldElement;
    }

    public void setDurability(int durability) {
        this.durability = durability;
        System.out.println("Field.setDurability()");
    }

    public int getDurability() {
        System.out.println("Field.getDurability()");
        return durability;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
        System.out.println("Field.setFragile()");
    }

    public boolean isFragile() {
        System.out.println("Field.isFragile()");
        return fragile;
    }

    public void addNeighbour(Field f) {
        System.out.println("Field.addNeighbour()");
    }

    public boolean accept(Steppable s) {
        System.out.println("Field.accept()");
        return false; //default return value
    }

    public void moveTo(Field f) {
        System.out.println("Field.moveTo()");
    }

    public void remove(FieldElement f) {
        System.out.println("Field.remove()");
    }

    public void scareNeighbours() {
        System.out.println("Field.scareNeighbours()");
    }

    public void jumpNeighbours() {
        System.out.println("Field.jumpNeighbours()");
    }

    public void sleepNeighbours() {
        System.out.println("Field.sleepNeighbours()");
    }

    public void pandaJumped() {
        System.out.println("Field.pandaJumped()");
    }

    public void decDurability() {
        System.out.println("Field.decDurability()");
    }

}
