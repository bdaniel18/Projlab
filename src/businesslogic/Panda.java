package businesslogic;

import Graphics.Icons;

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

    public void setCatcher(Orangutan _catcher) {
        if (catcher != null && _catcher == null) {
            System.out.println("MESSAGE: Orangutan " + catcher.getId() + " lost Panda " + getId() + ".");
        }
        this.catcher = _catcher;
    }

    public Orangutan getCatcher() {
        return catcher;
    }

    /**
     * A szabad panda random mezőre lép
     */
    public void step() {
        if (getField() == null || catcher != null) return;
        Random rand = new Random();
        ArrayList<Field> options = new ArrayList<Field>();

        for (int i = 0; i < getField().getNeighbourNumber(); i++) {
            options.add(getField().getNeighbour(i)); // feltöltjük a szomszédos mezők tömbjét
        }

        while (options.size() > 0) { // próbál lépni egy mezőre, ha sikertelen kiveszi a tömbből.
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
        System.out.println("MESSAGE: Panda " + getId() + " exited.");
        getCatcher().incScore();
        if(getFollower() != null){
            getFollower().exitReached();
        }
        die();
    }

    /**
     * A panda lép a kapott mezőre
     * @param f: Field
     * @return sikeres lépés volt-e
     */
    @Override
    public boolean step(Field f) {
        if (getField().moveTo(f, this)) {
            if (getFollower() != null) {
                getFollower().step(getLastSteppedOn());
            }
            setLastSteppedOn(f);
            Game.getInstance().push(this, Icons.PANDA);
        }
        return false;
    }

    /**
     * A panda egy Orangutannal ütközött így az elfogja
     * @param o: Orangutan
     * @return az ütközés kimenetele
     */
    @Override
    public boolean hitBy(Orangutan o) {
        if(o.getStepsLeft() == 0 && catcher == null){
            o.caught(this);
            return true;
        }
        return false;
    }

    /**
     * A panda ütközik egy másik pandával, ezért nem tud oda lépni
     * @param p Panda
     * @return mindig hamis
     */
    @Override
    public boolean hitBy(Panda p){
        return false;
    }

    /**
     * A panda elengedi a követője kezét(ha van) illetve az őt vezető kezét is.
     */
    public void releaseBoth() {
        setCatcher(null);
        if (getAnterior() != null) getAnterior().setFollower(null);
        setAnterior(null);
        if(getFollower() != null)
            getFollower().releaseBoth();
        setFollower(null);
    }

    /**
     * A paraméterként kapott FieldElement hitBy függvénnyel közli a Panda,
     * hogy ütköztek és a visszatérési értéket továbbadja a hívónak
     * @param fe: vele történt ütközés
     * @return az ütközés kimenetele
     */
    @Override
    public boolean collideWith(FieldElement fe){
        boolean temp = fe.hitBy(this);
        return temp;
    }

    /**
     * Panda meghal, elengedi a vezetője és a követője kezét is(ha van) és lekerül a Floor-ról
     */
    @Override
    public void die() {
        System.out.println("MESSAGE: Panda " + getId() + " died.");
        setCatcher(null);
        releaseBoth();
        getField().remove(this);
        setField(null);
        getFloor().remove(this);
    }

    public abstract String toString();

    @Override
    public void printStepped(Field f) {
        System.out.println("MESSAGE: Panda " + getId() + " stepped to Field " + f.getId() + ".");
    }

    /**
     * Ha egy panda alszik, vagy felébred állítani kell a változót
     * csak SleepyPanda esetén kell felüldefiniálni
     */
    public void sleptThisTurn() {
    }
}
