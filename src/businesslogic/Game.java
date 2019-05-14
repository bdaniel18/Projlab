package businesslogic;

import Graphics.FieldView;
import Graphics.Icons;
import Graphics.View;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

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
    private boolean gameWon = false;
    private boolean gameRunning = false;
    private int[][] leaderBoard;


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

    public boolean getGameWon() {
        return gameWon;
    }

    public boolean getGameRunning() {
        return gameRunning;
    }

    /**
     * visszaadja a játék eredményét, az orángutánok pontjait.
     *
     * @return az eredmények
     */
    public Vector<String> getOrangutanResults() {
        Vector<String> vec = new Vector<String>();
        Vector<Orangutan> orangs = floor.getOriginalOrangutans();
        for (int i = 0; i < orangs.size(); i++) {
            Orangutan o = orangs.get(i);
            vec.add("Orangutan " + o.getId() + ":  " + o.getScore() + " points");
        }
        saveResults();

        return vec;
    }

    /**
     * Elmenti a dicsőséglistához az adatokat fájlba
     */
    public void saveResults() {
        Vector<Orangutan> orangs = floor.getOriginalOrangutans();
        for (int i = 0; i < orangs.size(); i++) {
            Orangutan o = orangs.get(i);

            for(int j = 0; j < 5; j++) {
                if(o.getScore() > leaderBoard[j][1]) {
                    leaderBoard[j][0] = o.getId();
                    leaderBoard[j][1] = o.getScore();
                    break;
                }
            }
        }

        try {
            PrintWriter pw = new PrintWriter("leaderboard.txt");
            for(int i = 0; i < 5; i++) {
                pw.println(leaderBoard[i][0] + " " + leaderBoard[i][1]);
            }
            pw.close();
        } catch(Exception e) {

        }
    }


    public Orangutan getActiveOrangutan() {
        if (gameRunning) return floor.getOrangutan(currentOrangutan);
        else return null;
    }

    /*
    A nézettel való kommunikációhoz szükséges függvények
     */

    public void setView(View view) {
        this.view = view;
    }

    /**
     * Egy mezőt ad át a nézetnek
     * @param f a mező
     */
    public void push(Field f) {
        if (currentOrangutan >= 0 && f.getFieldElement() != null) {
            Orangutan o = floor.getOrangutan(currentOrangutan);
            if (f.getFieldElement().getId() == o.getId()) {
                view.add(f, FieldView.Colors.TO_STEP_COLOR);
                return;
            }
            ArrayList<Panda> followers = new ArrayList<>();
            Panda p = o.getFollower();
            while (p != null) {
                followers.add(p);
                p = p.getFollower();
            }
            FieldElement fe = f.getFieldElement();
            for (int i = 0; i < followers.size(); i++) {
                if (fe.getId() == followers.get(i).getId()) {
                    view.add(f, FieldView.Colors.TO_STEP_FOLLOWER_COLOR);
                    return;
                }
            }
        }

        if (f.isFragile()) {
            if (f.getDurability() <= 0) {
                view.add(f, FieldView.Colors.BROKEN_COLOR);
                return;
            }
            view.add(f, FieldView.Colors.FRAGILE_COLOR);
            return;
        }
        view.add(f, FieldView.Colors.NON_FRAGILE_COLOR);
    }

    /**
     * Egy fieldelementet ad át a nézetnek
     * @param fe a fieldelement
     * @param ic az ikonja
     */
    public void push(FieldElement fe, Icons ic) {
        if (fe.getField() == null) return;
        view.add(fe, ic);
    }

    public void pushEntrance(Field f) {
        view.addEntrance(f);
    }

    /**
     * Egy olyan fotelt ad át a nézetnek, amiben panda ül
     * @param s a fotel
     */
    public void pushSofaPanda(Sofa s) {
        if (s.getField() == null) return;
        view.removeDrawable(s.getId());
        view.removeDrawable(s.getPanda().getId());
        view.add(s, Icons.SOFAPANDA);
    }

    /**
     * Kitörli a kapott fieldelementet a nézetből
     * @param fe a törlendő elem
     */
    public void pushremove(FieldElement fe) {
        view.removeDrawable(fe.getId());
    }


    /**
     * Elindítja a játékot, inicializája a dicsőséglistát, és a nézetet
     */
    public void startGame() {
        currentOrangutan = 0;
        gameRunning = true;
        Steppable st = floor.getOrangutan(currentOrangutan);
        while (st != null) {
            push(st.getField());
            st = st.getFollower();
        }

        //A leaderboard állását kiolvassa fájlból, és beírja a saját tömbjébe
        leaderBoard = new int[5][2];
        try {
            File leaderBoardFile = new File("leaderboard.txt");
            Scanner sc = new Scanner(leaderBoardFile).useDelimiter("\\s*");

            for(int i = 0; i < 5; i++) {
                leaderBoard[i][0] = sc.nextInt();
                leaderBoard[i][1] = sc.nextInt();
            }
            sc.close();
        } catch(Exception e) {

        }
    }

    /** A soron következő orángután lép a kapott mezőre
     * @param fieldId a mező amire a soron levő orángután lép
     * @return vége-e a játéknak
     */
    public boolean stepOrangutan(int fieldId) {
        Field f = floor.getFieldforId(fieldId);
        if (floor.getOrangutan(currentOrangutan).step(f)) {
            incrementCurrentOrangutan();
        }
        if (floor.getOrangutanNumber() == 0) {
            gameWon = false;
            gameRunning = false;
            return true;
        } else if (floor.getPandaNumber() == 0) {
            gameWon = true;
            gameRunning = false;
            return true;
        }
        return false;
    }

    /**
     * A következő orángután köre következik,
     * ha mindenki lépett már, új kör jön
     */
    private void incrementCurrentOrangutan() {
        currentOrangutan += 1;
        if (currentOrangutan >= floor.getOrangutanNumber()) {
            currentOrangutan = 0;
            floor.newTurn();
        }
        for (int i = 0; i < floor.getFieldCount(); i++) {
            push(floor.getField(i));
        }
    }

    /**
     * A soron lévő orángután lemond a lépés jogáról.
     */
    public void passTurn() {
        incrementCurrentOrangutan();
    }

    /**
     * A soron lévő orángután elengedi a mögötte álló kezét
     */
    public void dissolveCurrentOrangutan() {
        ArrayList<Panda> followers = new ArrayList<>();
        Panda p = floor.getOrangutan(currentOrangutan).getFollower();
        while (p != null) {
            followers.add(p);
            p = p.getFollower();
        }
        floor.getOrangutan(currentOrangutan).dissolve();

        for (int i = 0; i < followers.size(); i++) {
            push(followers.get(i).getField());
        }
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

        view.clear();
        mp.parse(s);
        System.out.println("MESSAGE: Map loading successful!");
    }

}
