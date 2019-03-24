package businesslogic;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private List<Field> fields;
    private List<Activateable> activateables;
    private List<Orangutan> orangutans;
    private List<Panda> pandas;

    public Floor(){
        DepthWriter.add();
        DepthWriter.print("Floor CTOR");
        fields = new ArrayList<Field>();
        activateables = new ArrayList<Activateable>();
        orangutans = new ArrayList<Orangutan>();
        pandas = new ArrayList<Panda>();

        DepthWriter.reduce();
    }

    public void addField(Field f){
        DepthWriter.add();
        DepthWriter.print("Floor.addField()");
        DepthWriter.reduce();

        fields.add(f);
    }

    public void add(Activateable a) {
        DepthWriter.add();
        DepthWriter.print("Floor.add()");
        DepthWriter.reduce();

        activateables.add(a);
    }

    public void add(Orangutan o){
        DepthWriter.add();
        DepthWriter.print("Floor.add()");
        DepthWriter.reduce();

        orangutans.add(o);
    }


    public void add(Panda p){
        DepthWriter.add();
        DepthWriter.print("Floor.add()");
        DepthWriter.reduce();

        pandas.add(p);
    }

    public void remove (Orangutan o){
        DepthWriter.add();
        DepthWriter.print("Floor.remove()");
        DepthWriter.reduce();

        orangutans.remove(o);
    }

    public void remove (Panda p){
        DepthWriter.add();
        DepthWriter.print("Floor.remove()");
        DepthWriter.reduce();

        pandas.remove(p);
    }

    public void newTurn() {
        DepthWriter.add();
        DepthWriter.print("Floor.newTurn()");
        DepthWriter.reduce();
    }

    public Field waitForStep(Orangutan o){
        DepthWriter.add();
        DepthWriter.print("Floor.waitForStep()");
        DepthWriter.reduce();
        return  null; //default return value
    }

}
