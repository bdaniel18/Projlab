package businesslogic;

//Ez miért volt abstract?
public  class Panda extends Steppable {

    private Floor floor;
    private Orangutan catcher;

    public Panda() {
        System.out.println("Panda CTOR");
        floor = null;
        catcher = null;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
        System.out.println("Panda.setFloor()");
    }

    public Floor getFloor() {
        System.out.println("Panda.getFloor()");
        return floor;
    }

    public void setCatcher(Orangutan catcher) {
        this.catcher = catcher;
        DepthWriter dw = new DepthWriter("Panda.setCatcher()");
    }

    public Orangutan getCatcher() {
        DepthWriter dw = new DepthWriter("Panda.getCatcher()");
        return catcher;
    }



    public void exitReached() {
        DepthWriter dw = new DepthWriter("Panda.exitReached()");
        dw.add();
        getCatcher().incScore();
        if(getFollower() != null){
            getFollower().exitReached();
        }
        this.die();
    }

    public void step() {
        System.out.println("Panda.step()");
    }

    public boolean hitBy(Orangutan o) {
        DepthWriter dw = new DepthWriter("Panda.hitBy()");

        if(catcher == null){
            dw.add();
            o.caught(this);
            return true;
        }
        return false; //default return value
    }

    public void releaseBoth() {
        DepthWriter dw = new DepthWriter("Panda.releaseBoth()");
        if(getFollower() != null)
            getFollower().releaseBoth();
    }

    public void die() {
        DepthWriter dw = new DepthWriter("Panda.die()");
    }
}
