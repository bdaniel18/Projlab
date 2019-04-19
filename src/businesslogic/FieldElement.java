package businesslogic;

/**
 * Bármilyen elem a játékban, ami egy mezőre tud állni.
 * Absztrakt osztály.
 */
public abstract class FieldElement {

    private Field field; // a mező amin áll
    private int id;

    public FieldElement() {
        field = null;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public Field getField() {
        return field;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Panda próbál ugyanerre a mezőre lépni
     * @param p Panda
     * @return sikertelen lépés
     */
    public boolean hitBy(Panda p) {
        return false; //default return value
    }

    /**
     * Orángutánnal történik ütközés
     *
     * @param o Orangutan
     * @return sikertelen lépés
     */
    public boolean hitBy(Orangutan o) {
        return false; //default return value
    }

    /**
     * Szomszédos mezőn Sofa van.
     * @param s a szomszédos fotel
     * @return nem ül bele a fotelbe a FieldElement (default)
     */
    public boolean sofaActivated(Sofa s) {
        return false; //default return value
    }

    /**
     * Szomszédos mezőn játékgép van.
     */
    public void gmActivated() {
    }

    /**
     * Szomszédos mezőn Csokiautomata van.
     */
    public void cmActivated() {

    }
}
