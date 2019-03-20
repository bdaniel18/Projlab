package businesslogic;


public abstract class Steppable extends FieldElement {

    private boolean stepped;
    private Panda follower;
    private Steppable anterior;
    private Field lastSteppedOn; //Mező amire legutoljára lépett

    public Steppable() {
        System.out.println("Steppable CTOR");
        stepped = false;
        follower = null;
        anterior = null;
        lastSteppedOn = null;
    }

    public void setStepped(boolean stepped) {
        this.stepped = stepped;
        DepthWriter dw = new DepthWriter("Steppable.setStepped()");
    }
    public void setAnterior(Steppable st){
        DepthWriter dw = new DepthWriter("Steppable.setAnterior()");
        anterior = st;
    }
    public Steppable getAnterior(){
        DepthWriter dw = new DepthWriter("Steppable.getAnterior()");
        return anterior;
    }
    public boolean isStepped() {
        DepthWriter dw = new DepthWriter("Steppable.getAnterior()");
        return stepped;
    }

    public void setFollower(Panda follower) {
        this.follower = follower;
        DepthWriter dw = new DepthWriter("Steppable.setFollower()");
    }

    public Panda getFollower() {
        DepthWriter dw = new DepthWriter("Steppable.getFollower()");
        return follower;
    }
    public void setLastSteppedOn(Field field){
        DepthWriter dw = new DepthWriter("setLastSteppedOn()");
        lastSteppedOn = field;
    }

    public void die() {
        System.out.println("Steppable.die()");
    }


    public boolean step(Field f) {
        DepthWriter dw = new DepthWriter("Steppable.step()");
        dw.add();
        if(getField().moveTo(f, this)){
            if(follower != null){
                follower.step(lastSteppedOn);
            }
        }
        return false; //default return value
    }

    //A panda és az Orángután is override-olja ezt a függvényt
    public boolean  collideWith(FieldElement fe) {
        DepthWriter dw = new DepthWriter("Steppable.collideWith()");
        return false; //default return value;
    }

    public void releaseFollower() {
        System.out.println("Steppable.releaseFollower()");
    }

}
