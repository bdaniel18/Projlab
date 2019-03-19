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
        System.out.println("Orangutan.getFloor()");
        return floor;
    }

    //A paraméterként kapott FieldElement hitby függvényének saját magát adja át és az alapján tér vissza igaz v. hamissal
    @Override
    public  boolean  collideWith(FieldElement fe){
        System.out.println("Orangutan.collideWith()");
        return fe.hitBy(this);
    }

    public void caught(Panda p) {
        System.out.println("Orangutan.caught()");
    }

    public void incScore() {
        System.out.println("Orangutan.incScore()");
    }

}
