package businesslogic;

//Ez miért volt abstract?
public abstract  class Panda extends Steppable {

    private Floor floor;
    private Orangutan catcher;

    public Panda() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda CTOR");
        DepthWriter.reduce();
        floor = null;
        catcher = null;
    }

    public void setFloor(Floor floor) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.setFloor()");
        DepthWriter.reduce();
        this.floor = floor;
    }

    public Floor getFloor() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.getFloor()");
        DepthWriter.reduce();
        return floor;
    }

    public void setCatcher(Orangutan catcher) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.setCatcher()");
        DepthWriter.reduce();
        this.catcher = catcher;
    }

    public Orangutan getCatcher() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.getCatcher()");
        DepthWriter.reduce();
        return catcher;
    }

    public void exitReached() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.exitReached()");

        getCatcher().incScore();
        if(getFollower() != null){
            getFollower().exitReached();
        }
        die();
        DepthWriter.reduce();
    }

    public void step() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.step()");
        DepthWriter.reduce();
    }

    public boolean hitBy(Orangutan o) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.hitBy()");
        if(catcher == null){
            dw.add();
            o.caught(this);
            DepthWriter.reduce();
            return true;
        }
        DepthWriter.reduce();
        return false; //default return value
    }

    public void releaseBoth() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.releaseBoth()");

        if(getFollower() != null)
            getFollower().releaseBoth();
        DepthWriter.reduce();
    }

    public void die() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Panda.die()");
        DepthWriter.reduce();
    }
}
