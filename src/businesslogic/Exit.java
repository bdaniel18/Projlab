package businesslogic;

public class Exit extends FieldElement {

    private Field entrance;

    public Exit() {
        entrance = null;
        System.out.println("Exit CTOR");
    }

    public void setEntrance(Field entrance) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Exit.setEntrance()");
        this.entrance = entrance;
        DepthWriter.reduce();
    }

    public Field getEntrance() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Exit.getEntrance()");
        DepthWriter.reduce();
        return entrance;
    }

    public boolean hiBy(Panda p) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Exit.hitBy()");
        DepthWriter.reduce();
        return false; //default return value
    }
    /*Egy orángután neki megy a kijáratnak akkor az elkapott pandáit kivezeti majd ő maga visszamegy a bejáratra
     */
    @Override
    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Exit.hitBy()");
        if(entrance.accept(o)){
            if(o.getFollower() != null)
                 o.getFollower().exitReached();
            DepthWriter.reduce();
            return true;
        }
        DepthWriter.reduce();
        return false; //default return value
    }

}
