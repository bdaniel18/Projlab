import businesslogic.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Game game = Game.getInstance();

    private static boolean started = false;
    private static int orangutanNumber = 0;
    private static boolean printedround = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useDelimiter("\n");
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
                case "dissolve":
                    dissolve(sl);
                    break;
                default:
                    if (started) {
                        try {
                            int id = Integer.parseInt(s);
                            Field f = game.getFloor().getField(id);
                            if (f == null) throw new Exception();
                            if (game.getFloor().getCurrentOrangutan().step(f)) {
                                orangutanNumber++;
                                if (orangutanNumber >= game.getFloor().getOrangutanNumber()) {
                                    orangutanNumber = 0;
                                    printedround = false;
                                    game.getFloor().newTurn();
                                }
                                game.getFloor().setCurrentOrangutan(orangutanNumber);
                                game.getFloor().getCurrentOrangutan().setStepped(false);
                            } else {
                            }
                        } catch (Exception e) {
                            System.out.println("MESSAGE: Bad value.");
                        }
                    } else {
                        System.out.println("MESSAGE: Unknown command.");
                    }
            }

            if (started) {
                if (orangutanNumber == 0 && !printedround) {
                    System.out.println("MESSAGE: Round of Orangutans.");
                    printedround = true;
                }
                System.out.println("MESSAGE: Orangutan " + game.getFloor().getCurrentOrangutan().getId() +
                        " has to step. Give a field ID! (ID)");
            }
        }
    }

    private static void step(ArrayList<String> s) {
        game.getFloor().resetStepped();
        if (!game.getTestMode()) {
            System.out.println("MESSAGE: error: not in test mode.");
            return;
        }
        if (s.size() != 2) {
            System.out.println("MESSAGE: step: wrong parameters.");
            return;
        }
        if (game.getFloor() == null) {
            System.out.println("MESSAGE: map does not exist.");
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

    private static void dissolve(ArrayList<String> s) {
        if (game.getFloor() == null) {
            System.out.println("MESSAGE: map does not exist.");
            return;
        }
        if (!started) {
            System.out.println("MESSAGE: Game is not started.");
            return;
        }
        game.getFloor().getCurrentOrangutan().dissolve();
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
        if (game.getFloor() == null) {
            System.out.println("MESSAGE: map does not exist.");
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
        started = false;
        orangutanNumber = 0;
        printedround = false;
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
            game.newGame(ss.substring(1) + ".map");
        } catch (Exception e) {
            game.setMapid(-1);
            System.out.println("MESSAGE: Map loading failed!");
        }
    }

    private static void start(ArrayList<String> s) {
        if (s.size() != 0) {
            System.out.println("MESSAGE: start: wrong parameters");
            return;
        }
        if (game.getFloor() == null) {
            System.out.println("MESSAGE: Game could not start.");
            return;
        }
        System.out.println("MESSAGE: Game started.");
        started = true;
        game.getFloor().setCurrentOrangutan(orangutanNumber);
    }

    private static void stop(ArrayList<String> s) {
        if (s.size() != 0) {
            System.out.println("MESSAGE: stop: wrong parameters");
            return;
        }
        started = false;
        printedround = false;
        orangutanNumber = 0;
        System.out.println("MESSAGE: Game stopped.");
    }

    private static void list(ArrayList<String> s) {
        Floor f = game.getFloor();
        if (f == null) {
            System.out.println("MESSAGE: Game cannot list.");
            return;
        }
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
