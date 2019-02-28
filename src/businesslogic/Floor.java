package businesslogic;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private List<Field> fields;
    private List<Activateable> activateables;
    private List<Orangutan> orangutans;
    private List<Panda> pandas;

    public Floor(){
        System.out.println("Floor CTOR");
        fields = new ArrayList<Field>();
        activateables = new ArrayList<Activateable>();
        orangutans = new ArrayList<Orangutan>();
        pandas = new ArrayList<Panda>();
    }

    public void addField(Field f){
        System.out.println("Floor.addField()");
    }

    public void addFieldElement(FieldElement fe){
        System.out.println("Floor.addFieldElement()");
    }

    public void newTurn(){
        System.out.println("Floor.newTurn()");
    }

    public void add(Orangutan o){
        System.out.println("Floor.add()");
    }

    public void add(Panda p){
        System.out.println("Floor.add()");
    }

    public void remove (Orangutan o){
        System.out.println("Floor.remove()");
    }

    public void remove (Panda p){
        System.out.println("Floor.remove()");
    }

    public Field waitForStep(Orangutan o){
        System.out.println("Floor.waitForStep()");
        return  null; //default return value
    }
}
