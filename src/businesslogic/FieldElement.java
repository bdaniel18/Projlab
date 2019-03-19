package businesslogic;

public abstract class FieldElement {

    private Field field;

    public FieldElement() {
        System.out.println("FieldElement CTOR");
        field = null;
    }

    public void setField(Field field) {
        this.field = field;
        System.out.println("FieldElement.setField()");
    }

    public Field getField() {
        System.out.println("FieldElement.getField()");
        return field;
    }


    public  boolean hitBy(Panda p) {
        System.out.println("FieldElement.hitBy()");
        return false; //default return value
    }


    public boolean hitBy(Orangutan o) {
        System.out.println("FieldElement.hitBy()");
        return false; //default return value
    }

    public boolean sofaActivated(Sofa s) {
        System.out.println("FieldElement.sofaActivated()");
        return false; //default return value
    }


    public void gmActivated() {
        System.out.println("FieldElement.gmActivated()");
    }

    public void cmActivated() {
        System.out.println("FieldElement.cmActivated()");
    }

}
