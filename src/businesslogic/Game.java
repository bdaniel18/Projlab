package businesslogic;


/**
 * A játék osztály, felelős a játék indításáért és befejezésért.
 */
public class Game {

    private static Game instance; // az egyetlen példány

    private Game(){
        instance = null;
    }

    /**
     * Visszaadja az osztály egyetlen példányát, amit létre is hoz,
     * ha nem létezik.
     * @return a Game osztály példánya
     */
    public static Game getInstance() {
        if (instance == null)
            instance = new Game();
        return instance;
    }

    /**
     * Új játék indítása
     * @param map a pályafájl elérési útvonala
     */
    public void newGame(String map){
    }

    /**
     * Játék vége
     */
    public void endGame(){
    }
}
