package businesslogic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Az emelet osztály, tárolja a pálya mezőit, és az elemeket, amik minden körben
 * aktiválódnak, vagy lépnek.
 */
public class Floor {

    private List<Field> fields; // a pálya mezői
    private List<Activateable> activateables; // a pálya aktiválható elemei
    private List<Orangutan> orangutans; // a pálya orángutánjai
    private List<Panda> pandas; // a pálya pandái

    private Vector<Orangutan> originalOrangutans = new Vector<>();

    public Floor(){
        fields = new ArrayList<>();
        activateables = new ArrayList<>();
        orangutans = new ArrayList<>();
        pandas = new ArrayList<>();
    }

    public Orangutan getOrangutan(int i) {
        return orangutans.get(i);
    }

    public int getOrangutanNumber() {
        return orangutans.size();
    }

    public int getPandaNumber() {
        return pandas.size();
    }

    public Vector<Orangutan> getOriginalOrangutans() {
        return originalOrangutans;
    }

    /**
     * Egy mezőt ad a pályához.
     * @param f Field
     */
    public void addField(Field f){
        fields.add(f);
    }

    /**
     * Egy Activeablet ad a pályához
     * @param a Aktiválható elem
     */
    public void add(Activateable a) {
        activateables.add(a);
    }

    /**
     * Egy orángutánt ad a pályához
     * @param o Orángután
     */
    public void add(Orangutan o){
        orangutans.add(o);
        originalOrangutans.add(o);
    }

    /**
     * Egy pandát ad a pályához.
     * @param p Panda
     */
    public void add(Panda p){
        pandas.add(p);
    }

    /**
     * A pálya irányításából eltávolít egy orángutánt
     * @param o az eltávolítandó orángután.
     */
    public void remove (Orangutan o){
        orangutans.remove(o);
        Game.getInstance().pushremove(o);
    }

    /**
     * A pálya irányításából eltávolít egy pandát
     * @param p az eltávolítandó panda
     */
    public void remove (Panda p){
        pandas.remove(p);
        Game.getInstance().pushremove(p);
    }

    public void resetStepped() {
        for (int i = 0; i < orangutans.size(); i++) {
            orangutans.get(i).setStepped(false);
        }
        for (int i = 0; i < pandas.size(); i++) {
            pandas.get(i).setStepped(false);
        }
    }

    public Field getField(int i) {
        return fields.get(i);
    }

    public int getFieldCount() {
        return fields.size();
    }

    public Field getFieldforId(int id) {
        for (int i = 0; i < fields.size(); i++) {
            Field f = fields.get(i);
            if (f.getId() == id) return f;
        }
        return null;
    }

    /**
     * Új kör kezdődik, minden Steppable lép, és minden Activateable-nek meghívódik
     * az activate() függvénye
     */
    public void newTurn() {
        System.out.println("MESSAGE: Round of pandas.");
        for (int i = 0; i < pandas.size(); i++) {
            Panda p = pandas.get(i);
            if (!p.isStepped() && p.getField() != null) p.step();
        }
        resetStepped();
        for (int i = 0; i < activateables.size(); i++)
            activateables.get(i).activate();
    }


}
