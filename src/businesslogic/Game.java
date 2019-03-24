package businesslogic;

import test.DepthWriter;

/**
 * A játék osztály, felelős a játék indításáért és befejezésért.
 */
public class Game {

    private static Game instance; // az egyetlen példány

    private Game(){
        DepthWriter.add();
        DepthWriter.print("Game CTOR");
        DepthWriter.reduce();
        instance = null;
    }

    /**
     * Visszaadja az osztály egyetlen példányát, amit létre is hoz,
     * ha nem létezik.
     *
     * @return a Game osztály példánya
     */
    public static Game getInstance() {
        DepthWriter.add();
        DepthWriter.print("Game.getInstance()");
        if (instance == null)
            instance = new Game();
        DepthWriter.reduce();
        return instance;
    }

    /**
     * Új játék indítása
     *
     * @param map a pályafájl elérési útvonala
     */
    public void newGame(String map){
        DepthWriter.add();
        DepthWriter.print("Game.newGame()");
        DepthWriter.reduce();
    }

    /**
     * Játék vége
     */
    public void endGame(){
        DepthWriter.add();
        DepthWriter.print("Game.endGame()");
        DepthWriter.reduce();
    }
}
