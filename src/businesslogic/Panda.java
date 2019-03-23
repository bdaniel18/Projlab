package businesslogic;

import com.sun.xml.internal.bind.annotation.XmlLocation;

//Ez miért volt abstract?
public abstract  class Panda extends Steppable {

    private Floor floor;
    private Orangutan catcher;

    public Panda() {
        DepthWriter.add();
        DepthWriter.print("Panda CTOR");
        DepthWriter.reduce();
        floor = null;
        catcher = null;
    }

    public void setFloor(Floor floor) {
        DepthWriter.add();
        DepthWriter.print("Panda.setFloor()");
        DepthWriter.reduce();
        this.floor = floor;
    }

    public Floor getFloor() {
        DepthWriter.add();
        DepthWriter.print("Panda.getFloor()");
        DepthWriter.reduce();
        return floor;
    }

    public void setCatcher(Orangutan catcher) {
        DepthWriter.add();
        DepthWriter.print("Panda.setCatcher()");
        DepthWriter.reduce();
        this.catcher = catcher;
    }

    public Orangutan getCatcher() {
        DepthWriter.add();
        DepthWriter.print("Panda.getCatcher()");
        DepthWriter.reduce();
        return catcher;
    }

    /** A szabad pandak random mezőre lépnek
     *
     */
    public void step() {
        DepthWriter.add();
        DepthWriter.print("Panda.step()");
        DepthWriter.reduce();
    }

    /**A pandát kivezette egy Orangutan a kijáraton így az megszünik( előtte még ad egy pontot az Orangutannak)
     *
     */

    public void exitReached() {
        DepthWriter.add();
        DepthWriter.print("Panda.exitReached()");

        getCatcher().incScore();
        if(getFollower() != null){
            getFollower().exitReached();
        }
        die();
        DepthWriter.reduce();
    }

    /**A panda egy Orangutannal ütközött így az elfogja
     *
     * @param o: Orangutan
     * @return boolean
     */
    @Override
    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter.print("Panda.hitBy()");
        if(catcher == null){
            DepthWriter.add();
            o.caught(this);
            DepthWriter.reduce();
            return true;
        }
        DepthWriter.reduce();
        return false; //default return value
    }
    @Override
    public boolean hitBy(Panda p){
        DepthWriter.add();
        DepthWriter.print("Panda.hitBy()");
        DepthWriter.reduce();
        return false;
    }

    /** A panda elengedi a követője kezét(ha van) illetve az őt vezető kezét is.
     *
     */

    public void releaseBoth() {
        DepthWriter.add();
        DepthWriter.print("Panda.releaseBoth()");

        if(getFollower() != null)
            getFollower().releaseBoth();
        DepthWriter.reduce();
    }

    /**A paraméterként kapott FieldElement hitBy függvénnyel közli a Panda, hogy ütköztek és a visszatérési értéket továbbadja a hívónak
     *
     * @param fe: Field
     * @return boolean
     */
    @Override
    public  boolean  collideWith(FieldElement fe){
        DepthWriter.add();
        DepthWriter.print("Panda.collideWith()");
        boolean temp = fe.hitBy(this);
        DepthWriter.reduce();
        return temp;
    }

    /**Panda meghal, elengedi a vezetője és a követője kezét is(ha van) és lekerül a Floor-ról
     *
     */
    @Override
    public void die() {
        DepthWriter.add();
        DepthWriter.print("Orangutan.die()");
        if (getFollower() != null) {
            getFollower().releaseBoth();
        }
        getFloor().remove(this);
        DepthWriter.reduce();
    }
}
