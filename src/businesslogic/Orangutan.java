package businesslogic;

public class Orangutan extends Steppable {

    private int score;
    private Floor floor;

    public Orangutan() {
        System.out.println("Orangutan CTOR");
        score = 0; //default
        floor = null;
    }

    public void setScore(int score) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Orangutan.setScore()");
        this.score = score;
        DepthWriter.reduce();
    }

    public int getScore() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Orangutan.getScore()");
        DepthWriter.reduce();
        return score;
    }

    public void setFloor(Floor floor) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Orangutan.setFloor()");
        this.floor = floor;
        DepthWriter.reduce();
    }

    public Floor getFloor() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Orangutan.getFloor()");
        DepthWriter.reduce();
        return floor;
    }

    //A paraméterként kapott FieldElement hitby függvényének saját magát adja át és az alapján tér vissza igaz v. hamissal
    @Override
    public boolean collideWith(FieldElement fe) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Orangutan.collideWith()");
        boolean temp = fe.hitBy(this);
        DepthWriter.reduce();
        return temp;
    }

    public void caught(Panda p) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Orangutan.caught()");
        getField().remove(this);
        p.step(getField());

        if (getFollower() != null) {
            p.setFollower(getFollower());
            getFollower().setAnterior(p);
        }
        setFollower(p);
        p.setAnterior(this);
        p.setCatcher(this);
        DepthWriter.reduce();
    }

    public void incScore() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Orangutan.incScore()");
        DepthWriter.reduce();
    }

    @Override
    public void die() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Orangutan.die()");

        if (getFollower() != null) {
            getFollower().releaseBoth();
        }

        getFloor().remove(this);
        DepthWriter.reduce();
    }

}
