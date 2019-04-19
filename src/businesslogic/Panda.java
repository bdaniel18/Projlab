package businesslogic;

import java.util.ArrayList;
import java.util.Random;

/**
 * Panda osztály, az orángutánok el tudják fogni, és kivezetni a kijáraton.
 */
public abstract  class Panda extends Steppable {

    private Floor floor;
    private Orangutan catcher;

    public Panda() {
        floor = null;
        catcher = null;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Floor getFloor() {
        return floor;
    }

    public void setCatcher(Orangutan catcher) {
        this.catcher = catcher;
    }

    public Orangutan getCatcher() {
        return catcher;
    }

    /**
     * A szabad pandák random mezőre lépnek
     */
    public void step() {
        Random rand = new Random();
        ArrayList<Field> options = new ArrayList<Field>();

        for (int i = 0; i < getField().getNeighbourNumber(); i++) {
            options.add(getField().getNeighbour(i));
        }
        while (options.size() > 0) {
            int r = rand.nextInt(options.size());
            if (step(options.get(r))) return;
            options.remove(r);
        }
    }

    /**
     * A pandát kivezette egy Orángután a kijáraton így az megszünik,
     * ad egy pontot az Orangutannak
     */
    public void exitReached() {
        getCatcher().incScore();
        if(getFollower() != null){
            getFollower().exitReached();
        }
        die();
    }

    /**
     * A panda egy Orangutannal ütközött így az elfogja
     * @param o: Orangutan
     * @return az ütközés kimenetele
     */
    @Override
    public boolean hitBy(Orangutan o) {
        if(catcher == null){
            o.caught(this);
            return true;
        }
        return false; //default return value
    }

    /**
     * A panda ütközik egy másik pandával, ezért nem tud oda lépni
     * @param p
     * @return
     */
    @Override
    public boolean hitBy(Panda p){
        return false;
    }

    /**
     * A panda elengedi a követője kezét(ha van) illetve az őt vezető kezét is.
     */
    public void releaseBoth() {
        catcher = null;
        if(getFollower() != null)
            getFollower().releaseBoth();
    }

    /**
     * A paraméterként kapott FieldElement hitBy függvénnyel közli a Panda,
     * hogy ütköztek és a visszatérési értéket továbbadja a hívónak
     * @param fe: Field
     * @return boolean
     */
    @Override
    public  boolean  collideWith(FieldElement fe){
        boolean temp = fe.hitBy(this);
        return temp;
    }

    /**
     * Panda meghal, elengedi a vezetője és a követője kezét is(ha van) és lekerül a Floor-ról
     */
    @Override
    public void die() {

        if (getFollower() != null) {
            getFollower().releaseBoth();
        }
        getFloor().remove(this);

    }
}
