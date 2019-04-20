package businesslogic;

/**
 * A pálya léptethető eleme
 */
public abstract class Steppable extends FieldElement {

    private boolean stepped; // lépett-e az adott körben
    private Panda follower; // a sorban utána következő panda ( ha van)
    private Steppable anterior; // a sorban előtte haladó
    private Field lastSteppedOn; //Mező amire legutoljára lépett

    public Steppable() {
        stepped = false;
        follower = null;
        anterior = null;
        lastSteppedOn = null;
    }

    public void setStepped(boolean stepped) {
        this.stepped = stepped;
    }

    public void setAnterior(Steppable st) {
        anterior = st;
    }

    public Steppable getAnterior() {
        return anterior;
    }

    public boolean isStepped() {
        return stepped;
    }

    public void setFollower(Panda follower) {
        this.follower = follower;
    }

    public Panda getFollower() {
        return follower;
    }

    public void setLastSteppedOn(Field field) {
        lastSteppedOn = field;
    }

    public Field getLastSteppedOn() {
        return lastSteppedOn;
    }
    /**
     * A paraméterként kapott mezőre lép a Steppable, Illetve ha van követője azt a lépés előtti mezőjére lépteti
     * @param f: Field
     * @return a lépés sikeressége
     */
    public boolean step(Field f) {
        if (getField().moveTo(f, this)) {
            if (follower != null) {
                follower.step(lastSteppedOn);
            }
            lastSteppedOn = f;
        }
        return false;
    }

    /**
     * A követő kezét elengedjük
     */
    public void releaseFollower() {
        follower = null;
    }

    /**
     * Egy másik FieldElementtel való ütközés után hívódik meg, a Panda és az Orangutan is felülírja
     * @param fe: Field
     * @return boolean
     */
    public abstract boolean collideWith(FieldElement fe);

    /**
     * Steppable meghal, abstract mert a Panda és az Oruangutan is felülírja
     */
    public abstract void die();
}

