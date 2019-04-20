import businesslogic.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Game game = Game.getInstance();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String[] ss = s.split(" ");
            ArrayList<String> sl = new ArrayList<>();
            for (int i = 0; i < ss.length; i++) {
                sl.add(ss[i]);
            }
            s = sl.remove(0);
            switch (s.toLowerCase()) {
                case "list":
                    list(sl);
                    break;
                case "load":
                    load(sl);
                    break;
                case "start":
                    start(sl);
                    break;
                case "stop":
                    stop(sl);
                    break;
                case "test":
                    game.setTestMode(true);
                    break;
                case "step":
                    step(sl);
                    break;
                case "activate":
                    activate(sl);
                    break;
                default:
                    if () System.out.println("MESSAGE: Unknown command.");
            }
        }
    }

    private static void step(ArrayList<String> s) {
        if (!game.getTestMode()) {
            System.out.println("MESSAGE: error: not in test mode.");
            return;
        }
        if (s.size() != 2) {
            System.out.println("MESSAGE: step: wrong parameters.");
            return;
        }
        int id1 = Integer.parseInt(s.get(0)), id2 = Integer.parseInt(s.get(1));
        Steppable st = game.getFloor().getSteppable(id1);
        Field f = game.getFloor().getField(id2);
        if (st == null || f == null) {
            System.out.println("MESSAGE: step: wrong parameters.");
            return;
        }
        st.step(f);
    }

    private static void activate(ArrayList<String> s) {
        if (!game.getTestMode()) {
            System.out.println("MESSAGE: error: not in test mode.");
            return;
        }
        if (s.size() != 1) {
            System.out.println("MESSAGE: activate: wrong parameters.");
            return;
        }
        int id = Integer.parseInt(s.get(0));
        Activateable a = game.getFloor().getActivateable(id);
        if (a == null) {
            System.out.println("MESSAGE: activate: wrong parameters.");
            return;
        }
        a.activate();
    }

    private static void load(ArrayList<String> s) {
        if (!s.get(0).toLowerCase().equals("map") || s.size() > 2) {
            System.out.println("MESSAGE: load: wrong parameters.");
            return;
        }
        String ss = s.get(1);
        if (ss.charAt(0) != '-') {
            System.out.println("MESSAGE: load: wrong parameters.");
            return;
        }
        try {
            game.newGame(ss.substring(1));
        } catch (Exception e) {
            System.out.println("MESSAGE: Map loading failed!");
        }
    }

    private static void start(ArrayList<String> s) {
        if (s.size() != 0) System.out.println("MESSAGE: start: wrong parameters");
        else game.start();
    }

    private static void stop(ArrayList<String> s) {
        if (s.size() != 0) System.out.println("MESSAGE: stop: wrong parameters");
        else game.stop();
    }

    private static void list(ArrayList<String> s) {
        Floor f = game.getFloor();
        switch (s.get(0).toLowerCase()) {
            case "fields":
                f.listFields();
                break;
            case "neighbours":
                f.listNeighbours();
                break;
            case "pandas":
                f.listPandas();
                break;
            case "orangutans":
                f.listOrangutans();
                break;
            case "activateables":
                f.listActivateables();
                break;
            case "wardrobes":
                f.listWardrobes();
                break;
            case "exits":
                f.listExits();
                break;
            case "caught":
                if (s.get(1).toLowerCase().equals("pandas")) {
                    f.listCaughtPandas();
                    break;
                }
            default:
                System.out.println("MESSAGE: Game cannot list.");
        }
    }
}
