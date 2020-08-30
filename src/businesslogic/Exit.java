package businesslogic;

/**
 * A pálya kijárata, amin keresztül az orángutánok kivezetik a pandákat
 */
public class Exit extends FieldElement {

    private Field entrance; // a pálya bejárata

    public Exit() {
        entrance = null;
    }

    public void setEntrance(Field entrance) {
        this.entrance = entrance;
    }

    public Field getEntrance() {
        return entrance;
    }

    /**
     * Paraméterként kapott Pandaval közli, hogy nem mehet ki a kijáraton, csak ha egy Orangutan kivezeti
     * @param p Panda
     * @return a kilépés kimenetele (mindig hamis)
     */
    @Override
    public boolean hitBy(Panda p) {
        return false;
    }

    /**Paraméterként kapott Oragutant a bejárathoz küldi majd a követőivel közli, hogy elérték a kijáratot
     *
     * @param o: Orangutan
     * @return a kilépés kimenetele
     */
    @Override
    public boolean hitBy(Orangutan o) {
        if (entrance.getFieldElement() != null) return false;
        if(entrance.accept(o)){
            if(o.getFollower() != null)
                o.getFollower().exitReached();
            return true;
        }
        return false;
    }

    /**
     * @return Az objektum tulajdonságai stringként
     */
    public String toString() {
        return "Exit " + getId() + ",host ID: " + getField().getId();
    }

    /**
     * Kiírja magát a konzolra, mivel Exitpont.
     */
    @Override
    public void printIfExit() {
        System.out.println(toString());
    }

}
