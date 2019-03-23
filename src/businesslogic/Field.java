package businesslogic;

import java.util.List;
import java.util.ArrayList;

/**
 * A pálya egy mezője, állhat rajta egyszerre egy FieldElement.
 */
public class Field {

    private FieldElement fieldElement; //a mezőn álló elem
    private int durability;    // ha törékeny a csempe, az élettartamát tárolja
    private boolean fragile;   //törékeny-e a csempe
    private List<Field> neighbours;  // a szomszédos mezők

    public Field() {
        DepthWriter.add();
        DepthWriter.print("Field CTOR");
        fieldElement = null;
        durability = 0; //default
        fragile = false; //default
        neighbours = new ArrayList<Field>();

        DepthWriter.reduce();
    }

    public void setFieldElement(FieldElement fieldElement) {
        DepthWriter.add();
        DepthWriter.print("Field.setFieldElement()");
        DepthWriter.reduce();
        this.fieldElement = fieldElement;
        fieldElement.setField(this);
    }

    public FieldElement getFieldElement() {
        DepthWriter.add();
        DepthWriter.print("Field.getFieldElement()");
        DepthWriter.reduce();
        return fieldElement;
    }

    public void setDurability(int durability) {
        DepthWriter.add();
        DepthWriter.print("Field.setDurability()");
        DepthWriter.reduce();
        this.durability = durability;
    }

    public int getDurability() {
        DepthWriter.add();
        DepthWriter.print("Field.getDurability()");
        DepthWriter.reduce();
        return durability;
    }

    public void setFragile(boolean fragile) {
        DepthWriter.add();
        DepthWriter.print("Field.setFragile()");
        DepthWriter.reduce();
        this.fragile = fragile;
    }

    public boolean isFragile() {
        DepthWriter.add();
        DepthWriter.print("Field.isFragile()");
        DepthWriter.reduce();
        return fragile;
    }

    public void addNeighbour(Field f) {
        DepthWriter.add();
        DepthWriter.print("Field.addNeighbour()");
        neighbours.add(f);
        DepthWriter.reduce();
    }

    /**
     * Visszaadja a paraméterként kapott indexű szomszédot
     * @param idx a kért mező indexe
     * @return az idx. szomszéd
     */
    public Field getNeighbour(int idx){
        DepthWriter.add();
        DepthWriter.print("Field.getNeighbour()");
        if (idx >= neighbours.size()) {
            DepthWriter.reduce();
            return null;
        }
        Field temp = neighbours.get(idx);
        DepthWriter.reduce();
        return temp;
    }

    /**
     * Egy Steppable lépést kísérel meg a mezőre
     *
     * @param st a lépést végző Steppable
     * @return a lépés sikeressége
     */
    public boolean accept(Steppable st) {
        DepthWriter.add();
        DepthWriter.print("Field.accept()");

        if(fieldElement != null){
            if(st.collideWith(fieldElement)){
                st.setStepped(true);
                st.setLastSteppedOn(this);
                if(isFragile()){
                    decDurability();
                    if (getDurability() < 1) {
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

    /**
     * A mezőn álló Steppable lépést kísérel meg egy szomszédos mezőre
     *
     * @param f  a célmező
     * @param st a lépő Steppable
     * @return a lépés sikeressége
     */
    public boolean moveTo(Field f, Steppable st) {
        DepthWriter.add();
        DepthWriter.print("Field.moveTo()");
        if(f.accept(st)){
            remove(fieldElement);
        }
        DepthWriter.reduce();
        return true;
    }


    /**
     * Eltávolítja a mezőről a kapott FieldElementet, ha rajta áll
     * @param f az eltávolítandó elem
     */
    public void remove(FieldElement f) {
        DepthWriter.add();
        DepthWriter.print("Field.remove()");
        if (fieldElement == f)
            fieldElement = null;
        DepthWriter.reduce();
    }

    /**
     * A mező szól a szomszédos mezőn álló elemeknek, hogy játékgép aktiválódott rajta
     */
    public void scareNeighbours() {
        DepthWriter.add();
        DepthWriter.print("Field.scareNeighbours()");
        for (int i = 0; i < neighbours.size(); i++) {
            Field temp = neighbours.get(i);
            FieldElement fe = temp.getFieldElement();
            if (fe != null) fe.gmActivated();
        }
        DepthWriter.reduce();
    }

    /**
     * A mezőn csokiautomata aktiválódott, szól a szomdédos elemeknek.
     */
    public void jumpNeighbours() {
        DepthWriter.add();
        DepthWriter.print("Field.jumpNeighbours()");
        for (int i = 0; i < neighbours.size(); i++) {
            Field temp = neighbours.get(i);
            FieldElement fe = temp.getFieldElement();
            if (fe != null) fe.cmActivated();
        }
        DepthWriter.reduce();
    }

    /**
     * Szól a szomszédos mezőknek, hogy a mezőn fotel van
     * @param s A mezőn álló fotel
     */
    public void sleepNeighbours(Sofa s) {
        DepthWriter.add();
        DepthWriter.print("Field.sleepNeighbours()");

        for (int i = 0; i < neighbours.size(); i++) {
            Field temp = neighbours.get(i);
            FieldElement fe = temp.getFieldElement();
            if (fe != null) {
                if (fe.sofaActivated(s)) break;
            }
        }
        DepthWriter.reduce();
    }

    /**
     * A mezőn álló panda ugrott egyet, amitől eggyel csökken a durability,
     * ha a mező törékeny.
     * @param p a mezőn álló panda
     */
    public void pandaJumped(Panda p) {
        DepthWriter.add();
        DepthWriter.print("Field.pandaJumped()");
        if (fragile) {
            decDurability();
            if (durability < 1) p.die();
        }
        DepthWriter.reduce();
    }

    /**
     * A durability értékét csökkenti eggyel.
     */
    public void decDurability() {
        DepthWriter.add();
        DepthWriter.print("Field.decDurability()");
        --durability;
        DepthWriter.reduce();
    }

}
