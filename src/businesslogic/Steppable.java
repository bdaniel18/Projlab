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
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.setStepped()");
        this.stepped = stepped;
        DepthWriter.reduce();

    }
    public void setAnterior(Steppable st){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.setAnterior()");
        anterior = st;
        DepthWriter.reduce();
    }
    public Steppable getAnterior(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.getAnterior()");
        DepthWriter.reduce();
        return anterior;
    }
    public boolean isStepped() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.isStepped()");
        DepthWriter.reduce();
        return stepped;
    }

    public void setFollower(Panda follower) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.setFollower()");
        DepthWriter.reduce();
        this.follower = follower;
    }

    public Panda getFollower() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.getFollower()");
        DepthWriter.reduce();
        return follower;
    }
    public void setLastSteppedOn(Field field){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.setLastSteppedOn()");
        DepthWriter.reduce();
        lastSteppedOn = field;
    }

    public void die() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.die()");
        DepthWriter.reduce();
    }


    public boolean step(Field f) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.step()");

        if(getField().moveTo(f, this)){
            if(follower != null){
                follower.step(lastSteppedOn);
            }
        }
        DepthWriter.reduce();
        return false; //default return value
    }

    //A panda és az Orángután is override-olja ezt a függvényt
    public boolean  collideWith(FieldElement fe) {
        DepthWriter dw = new DepthWriter("Steppable.collideWith()");
        return false; //default return value;
    }

    public void releaseFollower() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Steppable.releaseFollower()");
        DepthWriter.reduce();
    }

}
