package businesslogic;

public class Game {

    private static Game instance;

    private Game(){
        instance = null;
    }

    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    public void newGame(String map){
        System.out.println("Game.newGame()");
    }

    public void endGame(String map){
        System.out.println("Game.endGame()");
    }
}
