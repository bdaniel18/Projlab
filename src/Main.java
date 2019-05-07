import Graphics.View;
import businesslogic.Game;

public class Main {

    public static void main(String[] args) {
        Game game = Game.getInstance();

        View v = new View(game);
        v.start();
    }

}
