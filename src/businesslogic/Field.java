package businesslogic;

import Graphics.Vertex;

import java.util.List;
import java.util.ArrayList;

/**
 * A játék mezője
 */
public class Field {

    private FieldElement fieldElement; // a mezőn álló elem
    private int durability; // a mező tartóssága
    private boolean fragile; // törékeny-e a mező
    private List<Field> neighbours; //a szomszédos mezők
    private int id;

    private ArrayList<Graphics.Vertex> vertices;

    public Field() {
        fieldElement = null;
        durability = 0;
        fragile = false;
        neighbours = new ArrayList<Field>();
    }

    public void setFieldElement(FieldElement fieldElement) {
        this.fieldElement = fieldElement;
        fieldElement.setField(this);
    }

    public FieldElement getFieldElement() {
        return fieldElement;
    }

    public ArrayList<Graphics.Vertex> getVertices() {
        return vertices;
    }

    public void addVertex(Vertex v) {
        vertices.add(v);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public int getDurability() {
        return durability;
    }

    public void setFragile(boolean fragile) {
        this.fragile = fragile;
    }

    public boolean isFragile() {
        return fragile;
    }

    public void addNeighbour(Field f) {
        neighbours.add(f);
    }

    public int getNeighbourNumber() {
        return neighbours.size();
    }

    /**
     * megnézi hogy a kapott mező szomszéd-e
     *
     * @param f a kapott mező
     * @return szomszédos-e a mező
     */
    public boolean isNeighbour(Field f) {
        for (int i = 0; i < neighbours.size(); i++) {
            if (neighbours.get(i).equals(f)) return true;
        }
        return false;
    }

    /**
     * idx-edik szomszédot adja vissza ha nincs ilyen szomszéd null-t ad vissza
     */
    public Field getNeighbour(int idx){
        if (idx >= neighbours.size()) {
            return null;
        }
        return neighbours.get(idx);
    }

    /** Paraméterként kapott Steppable-t megpróbálja elhelyezni a Field-en
     * Vizsgáljuk, hogy van-e a Field-en FieldElement és a vele való ütközés eredménye alapján történik az elhelyezés, amennyiben sikerült a lépés
     * megnézzük, hogy a Field Fragile-e amennyiben igen a durability-t csökkentjünk és ha nulla akkor leesik a Steppable, (meghal)
     * @param st: Steppable
     * @return boolean , Sikerült-e elhelyezni a Steppable-t
     */
    public boolean accept(Steppable st) {
        if (st.isStepped()) return false;
        if(fieldElement != null){
            if (st.collideWith(fieldElement)) { // a lépés sikeres
                if (!st.isStepped()) {
                    st.printStepped(this);
                    st.setStepped(true);
                    st.setField(this);
                    setFieldElement(st);
                    if(isFragile()){
                        decDurability();
                        if (getDurability() < 1) {
                            st.die();
                        }
                    }
                }
                return  true;
            } else { // a lépés sikertelen
                return false;
            }
        }
        //Mivel a FieldElement null, a lépés megtörténik
        if (!st.isStepped()) {
            st.printStepped(this);
            st.setField(this);
            st.setStepped(true);
            setFieldElement(st);
            if (isFragile()) {
                decDurability();
                if (getDurability() < 1) {
                    if (getDurability() == 0) System.out.println("MESSAGE: Field " + getId() + " has broken.");
                    st.die();
                }
            }
        }
        return true;
    }

    /**
     * (A hívó saját magát adja át paraméterként)
     * Paraméterként kapja, hogy hova és mit kell mozgatni
     */
    public boolean moveTo(Field f, Steppable st) {
        if (!isNeighbour(f)) return false;
        if(f.accept(st)){
            remove(fieldElement);
            return true;
        }
        return false;
    }


    /**
     * Eltávolítja a kapott FieldElementet a mezőről, ha rajta van.
     */
    public void remove(FieldElement f) {
        if (fieldElement == f)
            fieldElement = null;
    }

    /**
     * Aktiválódott a mezőn egy GamblingMachine.
     * A szomszédos mezőn állók gmActivated() függvényét meghívja.
     */
    public void scareNeighbours() {
        for (int i = 0; i < neighbours.size(); i++) {
            Field temp = neighbours.get(i);
            FieldElement fe = temp.getFieldElement();
            if (fe != null) fe.gmActivated();
        }
    }

    /**
     * Aktiválódott a mezőn egy ChocolateMachine.
     * A szomszédos mezőn állók cmActivated() függvényét meghívja.
     */
    public void jumpNeighbours() {
        for (int i = 0; i < neighbours.size(); i++) {
            Field temp = neighbours.get(i);
            FieldElement fe = temp.getFieldElement();
            if (fe != null) fe.cmActivated();
        }
    }

    /**
     * Szól a szomszédos mezőknek, hogy a mezőn fotel van.
     * @param s A mezőn álló fotel
     */
    public void sleepNeighbours(Sofa s) {
        for (int i = 0; i < neighbours.size(); i++) {
            Field temp = neighbours.get(i);
            FieldElement fe = temp.getFieldElement();
            if (fe != null) {
                if (fe.sofaActivated(s)) break;
            }
        }
    }

    /**
     * A mezőn álló panda ugrott egyet, amitől eggyel csökken a durability,
     * ha a mező törékeny.
     */
    public void pandaJumped(Panda p) {
        System.out.println("MESSAGE: Panda " + p.getId() + " jumped on Field " + getId() + ".");
        if (fragile) {
            decDurability();
            if (durability < 1) p.die();
        }
    }

    /**
     * A durability értékét csökkenti eggyel.
     */
    public void decDurability() {
        if (durability > 0) {
            System.out.println("MESSAGE: Durability decrementation of Field " + getId() + ".");
        }
        --durability;
    }

    public String toString() {
        String s = fragile ? "1" : "0";
        String idd = "null";
        if (fieldElement != null) idd = String.valueOf(fieldElement.getId());
        return "Field " + id + ", object ID: " + idd +
                ", fragile:" + s + ", durability: " + durability;
    }

}
