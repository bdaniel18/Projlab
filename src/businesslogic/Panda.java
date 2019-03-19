package businesslogic;

//Ez miért volt abstract?
public  class Panda extends Steppable {

    private Floor floor;
    private Orangutan catcher;

    public Panda() {
        System.out.print("Panda CTOR");
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
        System.out.println("Panda.setCatcher()");
    }

    public Orangutan getCatcher() {
        System.out.println("Panda.getCatcher()");
        return catcher;
    }

    public void exitReached() {
        System.out.println("Panda.exitReached()");
    }

    public void step() {
        System.out.println("Panda.step()");
    }

    public boolean hitBy(Orangutan o) {
        System.out.println("Panda.hitBy()");
        return false; //default return value
    }

    public void releaseBoth() {
        System.out.println("Panda.releaseBoth()");
    }

    public void die() {
        System.out.println("Panda.die()");
    }
}
