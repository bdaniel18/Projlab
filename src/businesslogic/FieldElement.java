package businesslogic;

public abstract class FieldElement {

    private Field field;

    public FieldElement() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("FieldElement CTOR");
        DepthWriter.reduce();
        field = null;
    }

    public void setField(Field field) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("FieldElement.setField()");
        this.field = field;
        DepthWriter.reduce();
    }

    public Field getField() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("FieldElement.getField()");
        DepthWriter.reduce();
        return field;
    }

    public boolean hitBy(Panda p) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("FieldElement.hitBy()");
        DepthWriter.reduce();
        return false; //default return value
    }


    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("FieldElement.hitBy()");
        DepthWriter.reduce();
        return false; //default return value
    }

    public boolean sofaActivated(Sofa s) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("FieldElement.sofaActivated()");
        DepthWriter.reduce();
        return false; //default return value
    }


    public void gmActivated() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("FieldElement.gmActivated()");
        DepthWriter.reduce();
    }

    public void cmActivated() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("FieldElement.cmActivated()");
        DepthWriter.reduce();
    }

}
