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

    public boolean hiBy(Panda p) {
        System.out.println("Exit.hitBy()");
        return false; //default return value
    }
    /*Egy orángután neki megy a kijáratnak akkor az elkapott pandáit kivezeti majd ő maga visszamegy a bejáratra
     */
    @Override
    public boolean hitBy(Orangutan o) {
        DepthWriter dw = new DepthWriter("Exit.hitBy()");
        dw.add();
        if(entrance.accept(o)){
            if(o.getFollower() != null)
                 o.getFollower().exitReached();
            return true;
        }
        return false; //default return value
    }

}
