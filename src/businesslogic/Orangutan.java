package businesslogic;

/**
 * Orángután osztály, a játékos irányítja a lépését, pandákat tud elfogni, és vezetni.
 */
public class Orangutan extends Steppable {

    /**
     * az orángután pontszáma, amit pandák kivezetéséért kap
     */
    private int score;
    private Floor floor;

    public Orangutan() {
        score = 0; //default
        floor = null;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
    }

    public Floor getFloor() {
        return floor;
    }

    /** A paraméterként kapott FieldElement hitBy függvényével jelzi, hogy ütközés történt majd a visszatérési értéket továbbadja
     *
     * @param fe: Field
     * @return boolean
     */
    @Override
    public boolean collideWith(FieldElement fe) {
        boolean temp = fe.hitBy(this);
        return temp;
    }

    /**
     * A paraméterként kapott Pandát elhelyezi az őt követő pandák sorának elejére,
     * és beállítja az előző követő pandának mint vezetőt
     * @param p: Panda
     */
    public void caught(Panda p) {
        getField().remove(this);
        p.step(getField());
        if (getFollower() != null) {
            p.setFollower(getFollower());
            getFollower().setAnterior(p);
        }
        setFollower(p);
        p.setAnterior(this);
        p.setCatcher(this);
    }

    public void dissolve() {

    }

    /**
     * Orangutan pontszámát növeli
     */
    public void incScore() {
    }

    /**
     * Orangutan meghal, elengedi a követője kezét(ha van) illetve lekerül a Floor-ról is
     */
    @Override
    public void die() {
        if (getFollower() != null) {
            getFollower().releaseFollower();
            getFollower().setCatcher(null);
        }
        getFloor().remove(this);
    }

    public String toString() {
        return "Orangutan " + getId() + ",host ID: " + getField().getId();
    }

}
