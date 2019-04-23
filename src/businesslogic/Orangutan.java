package businesslogic;

/**
 * Orángután osztály, a játékos irányítja a lépését, pandákat tud elfogni, és vezetni.
 */
public class Orangutan extends Steppable {

    private int score; // az orángután pontszáma, amit pandák kivezetéséért kap
    private Floor floor;
    private int stepsLeft;

    public Orangutan() {
        score = 0; //default
        floor = null;
        stepsLeft = 0; //default
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void setStepsLeft(int i){
        stepsLeft = i;
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
    public  int getStepsLeft(){
        return  stepsLeft;
    }

    /** A paraméterként kapott FieldElement hitBy függvényével jelzi, hogy ütközés történt
     * majd a visszatérési értéket továbbadja
     * @param fe: Field
     * @return boolean
     */
    @Override
    public boolean collideWith(FieldElement fe) {
        return fe.hitBy(this);
    }

    /**
     * A paraméterként kapott Pandát elhelyezi az őt követő pandák sorának elejére,
     * és beállítja az előző követő pandának mint vezetőt
     * @param p: Panda
     */
    public void caught(Panda p) {
        System.out.println("MESSAGE: Orangutan " + getId() + " caught Panda " + p.getId() + ".");
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

    /**
     * Az Orangutan elendedi a pandákat amiker gyűjtött (felbomlik az őt követő sor)
     */
    public void dissolve() {
        if(getFollower() != null){
            getFollower().releaseBoth();
        }
    }

    /**
     * Orangutan pontszámát növeli
     */
    public void incScore() {
        score++;
        System.out.println("MESSAGE: Orangutan "+getId()+" Points increased by 1.");
    }

    /**
     * Orangutan meghal, elengedi a követője kezét(ha van) illetve lekerül a Floor-ról is
     */
    @Override
    public void die() {
        if (getFollower() != null) {
            getFollower().releaseBoth();
        }
        System.out.println("MESSAGE: Orangutan "+getId()+" died.");
        getFloor().remove(this);
    }

    /**
     * @return Visszaadja az objektum tulajdonságait stringként
     */
    public String toString() {
        return "Orangutan " + getId() + ",host ID: " + getField().getId();
    }

    /**
     * Paraméterként kapott Field-re próbálja meg léptetni az Orangutant
     * @param f: Field(a mező amelyre lépni szeretne az Orangutan)
     * @return boolean (false ha nem sikerült a lépés különben true)
     */
    @Override
    public boolean step(Field f){
        if(getField().moveTo(f, this)){
            if(stepsLeft > 0){
                stepsLeft -=1;
            }
            if(getFollower() != null){
                getFollower().step(this.getLastSteppedOn());
            }
            this.setLastSteppedOn(f);
            return true;
        }
        return false;
    }

    @Override
    public boolean hitBy(Orangutan o){
        if(this.getStepsLeft() == 0 && this.getFollower() != null && o.getFollower() == null){
            System.out.println("MESSAGE: Orangutan "+o.getId()+" stole Pandas from Orangutan "+this.getId()+".");

            Field temp = o.getField();
            o.getField().remove(o);
            Field temp_this = getField();
            getField().moveTo(temp, this);
            o.step(temp_this);
            o.setStepped(false); // még léphet a körben, ha sorra kerül

            this.getFollower().setCatcher(o);
            this.getFollower().setAnterior(o);
            o.setFollower(this.getFollower());
            this.setFollower(null);
            this.setStepsLeft(3);

            return true;
        }
        return false;
    }

    /**
     * Az orángután lépését kiíratja a konzolra
     * @param f a mező, amire lépett
     */
    @Override
    public void printStepped(Field f) {
        System.out.println("MESSAGE: Orangutan " + getId() + " stepped to Field " + f.getId() + ".");
    }

}
