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
        DepthWriter.add();
        DepthWriter.print("Steppable CTOR");
        DepthWriter.reduce();
        stepped = false;
        follower = null;
        anterior = null;
        lastSteppedOn = null;
    }

    public void setStepped(boolean stepped) {
        DepthWriter.add();
        DepthWriter.print("Steppable.setStepped()");
        this.stepped = stepped;
        DepthWriter.reduce();

    }

    public void setAnterior(Steppable st) {
        DepthWriter.add();
        DepthWriter.print("Steppable.setAnterior()");
        anterior = st;
        DepthWriter.reduce();
    }

    public Steppable getAnterior() {
        DepthWriter.add();
        DepthWriter.print("Steppable.getAnterior()");
        DepthWriter.reduce();
        return anterior;
    }

    public boolean isStepped() {
        DepthWriter.add();
        DepthWriter.print("Steppable.isStepped()");
        DepthWriter.reduce();
        return stepped;
    }

    public void setFollower(Panda follower) {
        DepthWriter.add();
        DepthWriter.print("Steppable.setFollower()");
        DepthWriter.reduce();
        this.follower = follower;
    }

    public Panda getFollower() {
        DepthWriter.add();
        DepthWriter.print("Steppable.getFollower()");
        DepthWriter.reduce();
        return follower;
    }

    public void setLastSteppedOn(Field field) {
        DepthWriter.add();
        DepthWriter.print("Steppable.setLastSteppedOn()");
        DepthWriter.reduce();
        lastSteppedOn = field;
    }


    /**
     * A paraméterként kapott mezőre lép a Steppable, Illetve ha van követője azt a lépés előtti mezőjére lépteti
     * @param f: Field
     * @return boolean
     */
    public boolean step(Field f) {
        DepthWriter.add();
        DepthWriter.print("Steppable.step()");

        if (getField().moveTo(f, this)) {
            if (follower != null) {
                follower.step(lastSteppedOn);
            }
        }
        DepthWriter.reduce();
        return false; //default return value
    }

    /**
     * A követő kezét elengedjük
     */
    public void releaseFollower() {
        DepthWriter.add();
        DepthWriter.print("Steppable.releaseFollower()");
        DepthWriter.reduce();
    }


    /**
     * Egy másik FieldElementtel való ütközés után hívódik meg, a Panda és az Orangutan is felülírja
     * @param fe: Field
     * @return boolean
     */
    public abstract boolean collideWith(FieldElement fe);

    /**
     * Steppable meghal, abstarct mert a Panda és az Oruangutan is felülírja
     */
    public abstract void die();
}

