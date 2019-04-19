package businesslogic;

import test.DepthWriter;

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
        lastSteppedOn = field;
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

