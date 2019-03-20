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
        this.score = score;
        System.out.println("Orangutan.setScore()");
    }

    public int getScore() {
        System.out.println("Orangutan.getScore()");
        return score;
    }

    public void setFloor(Floor floor) {
        this.floor = floor;
        System.out.println("Orangutan.setFloor()");
    }

    public Floor getFloor() {
        DepthWriter dw = new DepthWriter("Orangutan.getFloor()");
        return floor;
    }

    //A paraméterként kapott FieldElement hitby függvényének saját magát adja át és az alapján tér vissza igaz v. hamissal
    @Override
    public  boolean  collideWith(FieldElement fe){
        DepthWriter dw = new DepthWriter("Orangutan.collideWith()");
        dw.add();
        return fe.hitBy(this);
    }

    public void caught(Panda p) {
        DepthWriter dw = new DepthWriter("Orangutan.caught()");

        dw.add();
        getField().remove(this);
        p.step(getField());

        if(getFollower() != null){
            p.setFollower(getFollower());
            getFollower().setAnterior(p);
        }
        setFollower(p);
        p.setAnterior(this);
        p.setCatcher(this);
    }

    public void incScore() {
        DepthWriter dw = new DepthWriter("Orangutan.incScore()");
    }

    @Override
    public void die(){
        DepthWriter dw = new DepthWriter("Orangutan.die()");
        dw.add();
        if(getFollower() != null){
            getFollower().releaseBoth();
        }

        getFloor().remove(this);
    }

}
