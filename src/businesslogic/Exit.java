package businesslogic;

/**
 * A pálya kijárata, amin keresztül az orángutánok kivezetik a pandákat
 */
public class Exit extends FieldElement {

    private Field entrance; // a pálya bejárata

    public Exit() {
        DepthWriter.add();
        DepthWriter.print("Exit CTOR");
        DepthWriter.reduce();
        entrance = null;
    }

    public void setEntrance(Field entrance) {
        DepthWriter.add();
        DepthWriter.print("Exit.setEntrance()");
        this.entrance = entrance;
        DepthWriter.reduce();
    }

    public Field getEntrance() {
        DepthWriter.add();
        DepthWriter.print("Exit.getEntrance()");
        DepthWriter.reduce();
        return entrance;
    }

    /**
     * Paraméterként kapott Pandaval közli, hogy nem mehet ki a kijáraton, csak ha egy Orangutan kivezeti
     * @param p Panda
     * @return a kilépés kimenetele (mindig hamis)
     */
    @Override
    public boolean hitBy(Panda p) {
        DepthWriter.add();
        DepthWriter.print("Exit.hitBy()");
        DepthWriter.reduce();
        return false; //default return value
    }

    /**Paraméterként kapott Oragutant a bejárathoz küldi majd a követőivel közli, hogy elérték a kijáratot
     *
     * @param o: Orangutan
     * @return a kilépés kimenetele
     */
    @Override
    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter.print("Exit.hitBy()");
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
