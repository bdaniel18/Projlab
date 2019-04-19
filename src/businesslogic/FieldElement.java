package businesslogic;

import test.DepthWriter;

/**
 * Bármilyen elem a játékban, ami egy mezőre tud állni.
 * Absztrakt osztály.
 */
public abstract class FieldElement {

    private Field field; // a mező amin áll
    private int id;

    public FieldElement() {
        DepthWriter.add();
        DepthWriter.print("FieldElement CTOR");
        DepthWriter.reduce();
        field = null;
    }

    public void setField(Field field) {
        DepthWriter.add();
        DepthWriter.print("FieldElement.setField()");

        this.field = field;

        DepthWriter.reduce();
    }

    public Field getField() {
        DepthWriter.add();
        DepthWriter.print("FieldElement.getField()");
        DepthWriter.reduce();

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
     *
     * @param p Panda
     * @return sikertelen lépés
     */
    public boolean hitBy(Panda p) {
        DepthWriter.add();
        DepthWriter.print("FieldElement.hitBy()");
        DepthWriter.reduce();

        return false; //default return value
    }

    /**
     * Orángutánnal történik ütközés
     *
     * @param o Orangutan
     * @return sikertelen lépés
     */
    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter.print("FieldElement.hitBy()");
        DepthWriter.reduce();

        return false; //default return value
    }

    /**
     * Szomszédos mezőn Sofa van.
     * @param s a szomszédos fotel
     * @return nem ül bele a fotelbe a FieldElement (default)
     */
    public boolean sofaActivated(Sofa s) {
        DepthWriter.add();
        DepthWriter.print("FieldElement.sofaActivated()");
        DepthWriter.reduce();

        return false; //default return value
    }

    /**
     * Szomszédos mezőn játékgép van.
     */
    public void gmActivated() {
        DepthWriter.add();
        DepthWriter.print("FieldElement.gmActivated()");
        DepthWriter.reduce();
    }

    /**
     * Szomszédos mezőn Csokiautomata van.
     */
    public void cmActivated() {
        DepthWriter.add();
        DepthWriter.print("FieldElement.cmActivated()");
        DepthWriter.reduce();
    }
}
