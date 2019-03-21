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
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.setFieldElement()");
        DepthWriter.reduce();
        this.fieldElement = fieldElement;
    }

    public FieldElement getFieldElement() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.getFieldElement()");
        DepthWriter.reduce();
        return fieldElement;
    }

    public void setDurability(int durability) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.setDurability()");
        DepthWriter.reduce();
        this.durability = durability;
    }

    public int getDurability() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.getDurability()");
        DepthWriter.reduce();
        return durability;
    }

    public void setFragile(boolean fragile) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.setFragile()");
        DepthWriter.reduce();
        this.fragile = fragile;
    }

    public boolean isFragile() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.isFragile()");
        DepthWriter.reduce();
        return fragile;
    }

    public void addNeighbour(Field f) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.addNeighbour()");
        neighbours.add(f);
        DepthWriter.reduce();
    }

    /*idx-edik szomszédot adja vissza ha nincs ilyen szomszéd hibát dob*/
    public Field getNeighbour(int idx){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.getNeighbour()");
        Field temp = neighbours.get(idx);
        DepthWriter.reduce();
        return temp;
    }



    public boolean accept(Steppable st) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.accept()");

        if(fieldElement != null){
            if(st.collideWith(fieldElement)){
                st.setStepped(true);
                st.setLastSteppedOn(this);
                if(isFragile()){
                    decDurability();
                        if(getDurability() < 1){
                            st.die();
                        }

                }
                DepthWriter.reduce();
                return  true;
            }else{
                DepthWriter.reduce();
                return false;
            }
        }
        if(isFragile()){
            decDurability();
            st.setStepped(true);
            st.setLastSteppedOn(this);
            if(getDurability() < 1){
                st.die();
            }
            DepthWriter.reduce();
            return true;
        }else{
            st.setStepped(true);
            st.setLastSteppedOn(this);
        }
        DepthWriter.reduce();
        return true;
    }

    /*(A hívó saját magát adja át paraméterként)
     *Paraméterként kapja, hogy hova és mit kell mozgatni
    */
    public boolean moveTo(Field f, Steppable st) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.moveTo()");
        if(f.accept(st)){
            remove(fieldElement);
        }
        DepthWriter.reduce();
        return true;
    }


    //Eltávolítja a FieldElementet,
    public void remove(FieldElement f) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.remove()");
        DepthWriter.reduce();
    }

    public void scareNeighbours() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.scareNeighbours()");
        DepthWriter.reduce();
    }

    public void jumpNeighbours() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.jumpNeighbours()");
        DepthWriter.reduce();
    }

    public void sleepNeighbours() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.sleepNeighbours()");
        DepthWriter.reduce();
    }

    public void pandaJumped() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.pandaJumped()");
        DepthWriter.reduce();
    }

    public void decDurability() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Field.decDurability()");
        --durability;
        DepthWriter.reduce();
    }

}
