package businesslogic;

import Graphics.Icons;
import Graphics.View;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * A játék osztály, felelős a játék indításáért és befejezésért.
 * Ellátja a kontroller feladatát, a modellel és a nézettel kommunikál
 */
public class Game {

    private static Game instance = null; // az egyetlen példány
    private Floor floor;
    private int mapid = -1;
    private String mapName = null;

    private View view;
    private int currentOrangutan = -1;

    private Game(){
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

    public Floor getFloor() {
        return floor;
    }


    /*
    A nézettel való kommunikációhoz szükséges függvények
     */

    public void setView(View view) {
        this.view = view;
    }

    public void push(Field f) {
        view.add(f);
    }

    public void push(FieldElement fe, Icons ic) {
        if (fe.getField() == null) return;
        view.add(fe, ic);
    }

    public void pushEntrance(Field f) {
        view.addEntrance(f);
    }

    public void pushSofaPanda(Sofa s) {
        if (s.getField() == null) return;
        view.removeDrawable(s.getId());
        view.removeDrawable(s.getPanda().getId());
        view.add(s, Icons.SOFAPANDA);
    }


    public void startGame() {
        currentOrangutan = 0;
    }

    public boolean stepOrangutan(int fieldId) {
        Field f = floor.getFieldforId(fieldId);
        if (floor.getOrangutan(currentOrangutan).step(f)) {
            currentOrangutan += 1;
            if (currentOrangutan >= floor.getOrangutanNumber()) {
                currentOrangutan = 0;
                floor.newTurn();
            }
            return true;
        }
        return false;
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
        System.out.println("MESSAGE: Map loading successful!");
    }

}
