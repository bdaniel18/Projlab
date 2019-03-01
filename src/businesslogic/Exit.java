package businesslogic;

public class Exit extends FieldElement {

    private Field entrance;

    public Exit() {
        entrance = null;
        System.out.println("Exit CTOR");
    }

    public void setEntrance(Field entrance) {
        this.entrance = entrance;
        System.out.println("Exit.setEntrance()");
    }

    public Field getEntrance() {
        System.out.println("Exit.getEntrance()");
        return entrance;
    }

    public boolean hitby(Panda p) {
        System.out.println("Exit.hitBy()");
        return false; //default return value
    }

    public boolean hitby(Orangutan o) {
        System.out.println("Exit.hitBy()");
        return false; //default return value
    }

}
