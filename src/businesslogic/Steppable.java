package businesslogic;

public abstract class Steppable extends FieldElement {

    private boolean stepped;
    private Panda follower;

    public Steppable() {
        System.out.println("Steppable CTOR");
        stepped = false;
        follower = null;
    }

    public void setStepped(boolean stepped) {
        this.stepped = stepped;
        System.out.println("Steppable.setStepped()");
    }

    public boolean isStepped() {
        System.out.println("Steppable.isStepped()");
        return stepped;
    }

    public void setFollower(Panda follower) {
        this.follower = follower;
        System.out.println("Steppable.setFollower()");
    }

    public Panda getFollower() {
        System.out.println("Steppable.getFollower()");
        return follower;
    }

    public void die() {
        System.out.println("Steppable.die()");
    }

    public boolean step(Field f) {
        System.out.println("Steppable.step()");
        return false; //default return value
    }

    public boolean collideWith(FieldElement fe) {
        System.out.println("Steppable.collideWith()");
        return false; //default return value;
    }

    public void releaseFollower() {
        System.out.println("Steppable.releaseFollower()");
    }

}
