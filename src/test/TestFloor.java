package test;

import businesslogic.*;

public class TestFloor {
    public static void NewTurn() {

        System.out.println("Teszt adatok felvétele: ");

        Floor floor = new Floor();
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();
        floor.addField(f1);
        floor.addField(f2);
        floor.addField(f3);
        f1.addNeighbour(f2);
        f2.addNeighbour(f3);
        f3.addNeighbour(f1);

        Panda p1 = new JumpyPanda();
        Orangutan o1 = new Orangutan();
        Sofa s = new Sofa();
        floor.add(p1);
        floor.add(o1);
        floor.add(s);
        p1.setField(f1);
        o1.setField(f2);
        s.setField(f3);

        System.out.println(" ");
        DepthWriter.print("Turn start Szekvencia: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");

        floor.newTurn();
    }
}
