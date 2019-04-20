package businesslogic;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * A játék osztály, felelős a játék indításáért és befejezésért.
 */
public class Game {

    private static Game instance; // az egyetlen példány
    private Floor floor;
    private int mapid;
    private String mapName;

    private Game(){
        instance = null;
        floor = null;
    }

    public int getMapid() {
        return mapid;
    }

    public void setMapid(int id) {
        mapid = id;
    }

    public String getMapName() {
        return mapName;
    }

    public void setMapName(String name) {
        mapName = name;
    }

    public void setFloor(Floor f) {
        floor = f;
    }

    public Floor getFloor() {
        return floor;
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
     * Játék vége
     */
    public void endGame() {
    }

    /**
     * Új játék indítása
     * @param map a pályafájl elérési útvonala
     */
    public void newGame(String map) throws Exception {
        File f = new File(map);
        Scanner input = new Scanner(f);
        ArrayList<String> s = new ArrayList<String>();
        while (input.hasNextLine()) {
            s.add(input.nextLine());
        }
        floor = new Floor();
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).trim().isEmpty()) {
                s.remove(i);
                i--;
            }
        }
        MapParser mp = new MapParser(this);
        mp.parse(s);
    }


}
