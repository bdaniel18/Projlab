package businesslogic;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapParser {
    private Game game;

    public MapParser(Game g) {
        game = g;
    }

    private ArrayList<Field> tempFields = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> fieldparams = new ArrayList<>();
    private ArrayList<Panda> tempPandas = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> pandaparams = new ArrayList<>();
    private ArrayList<Orangutan> tempOrangutans = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> orangutanparams = new ArrayList<>();
    private ArrayList<Activateable> tempActivateables = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> activateableparams = new ArrayList<>();
    private ArrayList<Wardrobe> tempWardrobes = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> wardrobeparams = new ArrayList<>();
    private ArrayList<Exit> tempExits = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<String>>> exitparams = new ArrayList<>();

    public void parse(ArrayList<String> s) throws Exception {
        String ss = s.remove(0), sss;
        if (!ss.trim().equals("<mapfile>")) throw new Exception();
        ss = s.remove(s.size() - 1);
        if (!ss.trim().equals("</mapfile>")) throw new Exception();

        ArrayList<String> temp, temp2;
        ArrayList<ArrayList<String>> params;

        while (s.size() > 0) {
            ss = s.remove(0);
            temp = splitS(ss);
            sss = s.remove(0);
            temp2 = splitS(sss);
            String open = temp.get(0), close = temp2.get(0);
            params = new ArrayList<ArrayList<String>>();
            while (!isClosing(open, close)) {
                params.add(temp2);
                sss = s.remove(0);
                temp2 = splitS(sss);
                close = temp2.get(0);
            }

            switch (open) {
                case "field":
                    fetchField(params);
                    break;
                case "map":
                    fetchMap(params);
                    break;
                case "panda":
                    fetchPanda(params);
                    break;
                case "orangutan":
                    fetchOrangutan(params);
                    break;
                case "activateable":
                    fetchActivateable(params);
                    break;
                case "wardrobe":
                    fetchWardrobe(params);
                    break;
                case "exit":
                    fetchExit(params);
                    break;
            }
        }
        parseFields();
        parseOrangutans();
        parsePandas();
        parseActivateables();
        parseExits();
        parseWardrobes();

    }

    private void fetchField(ArrayList<ArrayList<String>> s) {
        Field f = new Field();
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).get(0).equals("id")) {
                f.setId(Integer.parseInt(s.remove(i).get(1)));
                break;
            }
        }
        tempFields.add(f);
        fieldparams.add(s);
    }

    private void fetchMap(ArrayList<ArrayList<String>> s) {
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).get(0).equals("id")) {
                game.setMapid(Integer.parseInt(s.get(i).get(1)));
            } else if (s.get(i).get(0).equals("name")) {
                game.setMapName(s.get(i).get(1));
            }
        }
    }

    private void fetchPanda(ArrayList<ArrayList<String>> s) {
        int id = -1;
        Panda p = null;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).get(0).equals("type")) {
                String ss = s.get(i).get(1);
                if (ss.equals("sleepy")) p = new SleepyPanda();
                if (ss.equals("jumpy")) p = new JumpyPanda();
                if (ss.equals("coward")) p = new CowardPanda();
            }
            if (s.get(i).get(0).equals("id")) {
                id = Integer.parseInt(s.get(i).get(1));
            }
        }
        p.setId(id);
        tempPandas.add(p);
        pandaparams.add(s);
    }

    private void fetchOrangutan(ArrayList<ArrayList<String>> s) {
        Orangutan o = new Orangutan();
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).get(0).equals("id")) {
                o.setId(Integer.parseInt(s.remove(i).get(1)));
                break;
            }
        }
        tempOrangutans.add(o);
        orangutanparams.add(s);
    }

    private void fetchActivateable(ArrayList<ArrayList<String>> s) {
        Activateable a = null;
        int id = -1;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).get(0).equals("type")) {
                String ss = s.get(i).get(1);
                if (ss.equals("sofa")) a = new Sofa();
                if (ss.equals("chocolatemachine")) a = new ChocolateMachine();
                if (ss.equals("gamblingmachine")) a = new GamblingMachine();
            }
            if (s.get(i).get(0).equals("id")) {
                id = Integer.parseInt(s.get(i).get(1));
            }
        }
        a.setId(id);
        tempActivateables.add(a);
        activateableparams.add(s);
    }

    private void fetchWardrobe(ArrayList<ArrayList<String>> s) {
        Wardrobe w = new Wardrobe();
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).get(0).equals("id")) {
                w.setId(Integer.parseInt(s.remove(i).get(1)));
                break;
            }
        }
        tempWardrobes.add(w);
        wardrobeparams.add(s);
    }

    private void fetchExit(ArrayList<ArrayList<String>> s) {
        Exit e = new Exit();
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).get(0).equals("id")) {
                e.setId(Integer.parseInt(s.remove(i).get(1)));
                break;
            }
        }
        tempExits.add(e);
        exitparams.add(s);
    }

    private void parseFields() {
        for (int i = 0; i < tempFields.size(); i++) {
            Field f = tempFields.get(i);
            for (int j = 0; j < fieldparams.get(i).size(); j++) {
                String param = fieldparams.get(i).get(j).get(0);
                String param2 = fieldparams.get(i).get(j).get(1);
                switch (param) {
                    case "fragile":
                        if (Integer.parseInt(param2) == 1) f.setFragile(true);
                        else f.setFragile(false);
                        break;
                    case "durability":
                        f.setDurability(Integer.parseInt(param2));
                        break;
                    case "neighbour":
                        int id = Integer.parseInt(param2);
                        f.addNeighbour(getField(id));
                        break;
                    default:
                }
            }
            game.getFloor().addField(f);
        }
    }

    private void parsePandas() {
        for (int i = 0; i < tempPandas.size(); i++) {
            Panda p = tempPandas.get(i);
            for (int j = 0; j < pandaparams.get(i).size(); j++) {
                String param = pandaparams.get(i).get(j).get(0);
                String param2 = pandaparams.get(i).get(j).get(1);
                switch (param) {
                    case "host":
                        int id = Integer.parseInt(param2);
                        Field f = getField(id);
                        f.setFieldElement(p);
                        p.setField(f);
                        break;
                    case "anterior":
                        id = Integer.parseInt(param2);
                        p.setAnterior(getSteppable(id));
                        break;
                    case "follower":
                        id = Integer.parseInt(param2);
                        p.setFollower(getPanda(id));
                        break;
                    default:
                }
            }
            game.getFloor().add(p);
        }
    }

    private void parseOrangutans() {
        for (int i = 0; i < tempOrangutans.size(); i++) {
            Orangutan o = tempOrangutans.get(i);
            for (int j = 0; j < orangutanparams.get(i).size(); j++) {
                String param = orangutanparams.get(i).get(j).get(0);
                String param2 = orangutanparams.get(i).get(j).get(1);
                int id = Integer.parseInt(param2);
                switch (param) {
                    case "host":
                        Field f = getField(id);
                        f.setFieldElement(o);
                        o.setField(f);
                        break;
                    case "follower":
                        o.setFollower(getPanda(id));
                        break;
                    default:
                }
            }
            game.getFloor().add(o);
        }
    }

    private void parseActivateables() {
        for (int i = 0; i < tempActivateables.size(); i++) {
            Activateable a = tempActivateables.get(i);
            for (int j = 0; j < activateableparams.get(i).size(); j++) {
                String param = activateableparams.get(i).get(j).get(0);
                String param2 = activateableparams.get(i).get(j).get(1);
                switch (param) {
                    case "host":
                        int id = Integer.parseInt(param2);
                        Field f = getField(id);
                        f.setFieldElement(a);
                        a.setField(f);
                        break;
                    default:
                }
            }
            game.getFloor().add(a);
        }
    }


    private void parseWardrobes() {
        for (int i = 0; i < tempWardrobes.size(); i++) {
            Wardrobe w = tempWardrobes.get(i);
            for (int j = 0; j < wardrobeparams.get(i).size(); j++) {
                String param = wardrobeparams.get(i).get(j).get(0);
                String param2 = wardrobeparams.get(i).get(j).get(1);
                int id = Integer.parseInt(param2);
                switch (param) {
                    case "host":
                        Field f = getField(id);
                        f.setFieldElement(w);
                        w.setField(f);
                        break;
                    case "target":
                        w.setTarget(getWardrobe(id));
                        break;
                    default:
                }
            }
        }
    }

    private void parseExits() {
        for (int i = 0; i < tempExits.size(); i++) {
            Exit e = tempExits.get(i);
            for (int j = 0; j < exitparams.get(i).size(); j++) {
                String param = exitparams.get(i).get(j).get(0);
                String param2 = exitparams.get(i).get(j).get(1);
                int id = Integer.parseInt(param2);
                switch (param) {
                    case "host":
                        Field f = getField(id);
                        f.setFieldElement(e);
                        e.setField(f);
                        break;
                    case "target":
                        e.setEntrance(getField(id));
                        break;
                    default:
                }
            }
        }
    }


    private Field getField(int id) {
        for (int i = 0; i < tempFields.size(); i++) {
            Field f = tempFields.get(i);
            if (f.getId() == id) return f;
        }
        return null;
    }

    private Steppable getSteppable(int id) {
        for (int i = 0; i < tempPandas.size(); i++) {
            Steppable st = tempPandas.get(i);
            if (st.getId() == id) return st;
        }
        for (int i = 0; i < tempOrangutans.size(); i++) {
            Steppable st = tempOrangutans.get(i);
            if (st.getId() == id) return st;
        }
        return null;
    }

    private Panda getPanda(int id) {
        for (int i = 0; i < tempPandas.size(); i++) {
            Panda p = tempPandas.get(i);
            if (p.getId() == id) return p;
        }
        return null;
    }

    private Wardrobe getWardrobe(int id) {
        for (int i = 0; i < tempWardrobes.size(); i++) {
            Wardrobe w = tempWardrobes.get(i);
            if (w.getId() == id) return w;
        }
        return null;
    }

    private ArrayList<String> splitS(String s) throws Exception {
        ArrayList<String> ss = new ArrayList<String>();
        s = s.trim();
        String pattern = "<(\\w*)>\\s*(?:(\\w*)\\s*</(\\w*)>)?";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(s);
        if (m.find()) {
            ss.add(m.group(1));
            ss.add(m.group(2));
            ss.add(m.group(3));
        } else {
            pattern = "</(.*)>";
            p = Pattern.compile(pattern);
            m = p.matcher(s);
            if (m.find()) {
                ss.add(m.group(1));
            } else throw new Exception();
        }

        return ss;
    }

    private boolean isClosing(String s, String line) {
        line = line.trim();
        if (s.equals(line)) return true;
        return false;
    }
}
