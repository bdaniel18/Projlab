package businesslogic;

public class Orangutan extends Steppable {

    private int score;
    private Floor floor;

    public Orangutan() {
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

    public void caught(Panda p) {
        System.out.println("Orangutan.caught()");
    }

    public void incScore() {
        System.out.println("Orangutan.incScore()");
    }

    public void releaseFollower() {
        System.out.println("Orangutan.releaseFollower");
    }

}
