package businesslogic;

public class Game {

    private static Game instance;

    private Game(){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Game CTOR");
        DepthWriter.reduce();
        instance = null;
    }

    public static Game getInstance() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Game.getInstance()");
        if (instance == null)
            instance = new Game();
        DepthWriter.reduce();
        return instance;
    }

    public void newGame(String map){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Game.newGame()");
        DepthWriter.reduce();
    }

    public void endGame(String map){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Game.endGame()");
        DepthWriter.reduce();
    }
}
