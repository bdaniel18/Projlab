package businesslogic;

/**
 * Bármilyen elem a játékban, ami egy mezőre tud állni.
 */
public abstract class FieldElement {

    private Field field;

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

    public boolean hitBy(Panda p) {
        DepthWriter.add();
        DepthWriter.print("FieldElement.hitBy()");
        DepthWriter.reduce();
        return false; //default return value
    }


    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter.print("FieldElement.hitBy()");
        DepthWriter.reduce();
        return false; //default return value
    }

    public boolean sofaActivated(Sofa s) {
        DepthWriter.add();
        DepthWriter.print("FieldElement.sofaActivated()");
        DepthWriter.reduce();
        return false; //default return value
    }


    public void gmActivated() {
        DepthWriter.add();
        DepthWriter.print("FieldElement.gmActivated()");
        DepthWriter.reduce();
    }

    public void cmActivated() {
        DepthWriter.add();
        DepthWriter.print("FieldElement.cmActivated()");
        DepthWriter.reduce();
    }

}
