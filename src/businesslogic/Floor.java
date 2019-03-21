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
        DepthWriter dw = new DepthWriter("Floor CTOR");
        fields = new ArrayList<Field>();
        activateables = new ArrayList<Activateable>();
        orangutans = new ArrayList<Orangutan>();
        pandas = new ArrayList<Panda>();

        DepthWriter.reduce();
    }

    public void addField(Field f){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Floor.addField()");
        DepthWriter.reduce();
    }

    public void add(Activateable a) {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Floor.add()");
        DepthWriter.reduce();
    }

    public void add(Orangutan o){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Floor.add()");
        DepthWriter.reduce();
    }


    public void add(Panda p){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Floor.add()");
        DepthWriter.reduce();
    }

    public void remove (Orangutan o){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Floor.remove()");
        DepthWriter.reduce();
    }

    public void remove (Panda p){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Floor.remove()");
        DepthWriter.reduce();
    }

    public void newTurn() {
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Floor.newTurn()");
        DepthWriter.reduce();
    }

    public Field waitForStep(Orangutan o){
        DepthWriter.add();
        DepthWriter dw = new DepthWriter("Floor.waitForStep()");
        DepthWriter.reduce();
        return  null; //default return value
    }

}
