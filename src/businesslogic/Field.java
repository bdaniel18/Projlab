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
        DepthWriter dw = new DepthWriter("Field.setFieldElement()");
    }

    public FieldElement getFieldElement() {
        DepthWriter dw = new DepthWriter("Field.getFieldElement()");
        return fieldElement;
    }

    public void setDurability(int durability) {
        this.durability = durability;
        System.out.println("Field.setDurability()");
    }

    public int getDurability() {
        DepthWriter dw = new DepthWriter("Field.getDurability()");
        return durability;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
        System.out.println("Field.setFragile()");
    }

    public boolean isFragile() {
        DepthWriter dw = new DepthWriter("Field.isFragile()");
        return fragile;
    }

    public void addNeighbour(Field f) {
        System.out.println("Field.addNeighbour()");
        neighbours.add(f);
    }
    /*idx-edik szomszédot adja vissza ha nincs ilyen szomszéd hibét dob*/
    public Field getNeighbour(int idx){
        DepthWriter dw = new DepthWriter("Field.getNeighbour()");
        return neighbours.get(idx);
    }



    public boolean accept(Steppable st) {
        DepthWriter dw = new DepthWriter("Field.accept()");
        dw.add();
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
                return  true;
            }else{
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
            return true;
        }else{
            st.setStepped(true);
            st.setLastSteppedOn(this);
        }
        return true;
    }

    /*(A hívó saját magát adja át paraméterként)
     *Paraméterként kapja, hogy hova és mit kell mozgatni
    */
    public boolean moveTo(Field f, Steppable st) {
        DepthWriter dw = new DepthWriter("Field.moveTo()");
        dw.add();
        if(f.accept(st)){
            remove(fieldElement);
        }
        return true;
    }


    //Eltávolítja a FieldElementet,
    public void remove(FieldElement f) {
        DepthWriter dw = new DepthWriter("Field.remove()");
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
        DepthWriter dw = new DepthWriter("Field.decDurability()");
        --durability;
    }

}
