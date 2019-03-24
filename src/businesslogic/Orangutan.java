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
        DepthWriter.add();
        DepthWriter.print("Orangutan CTOR");
        DepthWriter.reduce();
        score = 0; //default
        floor = null;
    }

    public void setScore(int score) {
        DepthWriter.add();
        DepthWriter.print("Orangutan.setScore()");
        this.score = score;
        DepthWriter.reduce();
    }

    public int getScore() {
        DepthWriter.add();
        DepthWriter.print("Orangutan.getScore()");
        DepthWriter.reduce();
        return score;
    }

    public void setFloor(Floor floor) {
        DepthWriter.add();
        DepthWriter.print("Orangutan.setFloor()");
        this.floor = floor;
        DepthWriter.reduce();
    }

    public Floor getFloor() {
        DepthWriter.add();
        DepthWriter.print("Orangutan.getFloor()");
        DepthWriter.reduce();
        return floor;
    }

    /** A paraméterként kapott FieldElement hitBy függvényével jelzi, hogy ütközés történt majd a visszatérési értéket továbbadja
     *
     * @param fe: Field
     * @return boolean
     */
    @Override
    public boolean collideWith(FieldElement fe) {
        DepthWriter.add();
        DepthWriter.print("Orangutan.collideWith()");
        boolean temp = fe.hitBy(this);
        DepthWriter.reduce();
        return temp;
    }

    /**
     * A paraméterként kapott Pandát elhelyezi az őt követő pandák sorának elejére,
     * és beállítja az előző követő pandának mint vezetőt
     * @param p: Panda
     */

    public void caught(Panda p) {
        DepthWriter.add();
        DepthWriter.print("Orangutan.caught()");
        getField().remove(this);
        p.step(getField());

        if (getFollower() != null) {
            p.setFollower(getFollower());
            getFollower().setAnterior(p);
        }
        setFollower(p);
        p.setAnterior(this);
        p.setCatcher(this);
        DepthWriter.reduce();
    }

    /**
     * Orangutan pontszámát növeli
     */
    public void incScore() {
        DepthWriter.add();
        DepthWriter.print("Orangutan.incScore()");
        DepthWriter.reduce();
    }

    /**
     * Orangutan meghal, elengedi a követője kezét(ha van) illetve lekerül a Floor-ról is
     */
    @Override
    public void die() {
        DepthWriter.add();
        DepthWriter.print("Orangutan.die()");
        if (getFollower() != null) {
            getFollower().releaseFollower();
            getFollower().setCatcher(null);
        }
        getFloor().remove(this);
        DepthWriter.reduce();
    }

}
