package businesslogic;

import java.util.ArrayList;
import java.util.List;

/**
 * Az emelet osztály, tárolja a pálya mezőit, és az elemeket, amik minden körben
 * aktiválódnak, vagy lépnek.
 */
public class Floor {

    private List<Field> fields; // a pálya mezői
    private List<Activateable> activateables; // a pálya aktiválható elemei
    private List<Orangutan> orangutans; // a pálya orángutánjai
    private List<Panda> pandas; // a pálya pandái

    /**
     * Konstruktor, inicializálja a listákat
     */
    public Floor(){
        fields = new ArrayList<Field>();
        activateables = new ArrayList<Activateable>();
        orangutans = new ArrayList<Orangutan>();
        pandas = new ArrayList<Panda>();
    }

    /**
     * Egy mezőt ad a pályához.
     *
     * @param f Field
     */
    public void addField(Field f){
        fields.add(f);
    }

    /**
     * Egy Activeablet ad a pályához
     *
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
    }

    /**
     * A pálya irányításából eltávolít egy pandát
     * @param p az eltávolítandó panda
     */
    public void remove (Panda p){
        pandas.remove(p);
    }

    /**
     * Új kör kezdődik, minden Steppable lép, és minden Activateable-nek meghívódik
     * az activate() függvénye
     */
    public void newTurn() {
        if(orangutans.size() != 0) orangutans.get(0).setStepped(false);
        if(pandas.size() != 0) {
            pandas.get(0).setStepped(false);
            pandas.get(0).step();
        }
        if(activateables.size() != 0) activateables.get(0).activate();
    }

    /**
     * Várunk, hogy a felhasználó léptesse az adott orángutánt.
     * @param o Orángután
     * @return a mező, amire lépett
     */
    public Field waitForStep(Orangutan o){
        return  null; //default return value
    }

}
