package test;

import businesslogic.DepthWriter;
import businesslogic.Orangutan;
import businesslogic.Field;
import businesslogic.*;

public class TestOrangutan {
    public static void OrangutanMove() {
       System.out.println("Test adatok felvétele: ");
       Orangutan o = new Orangutan();
       Field f = new Field();
       Field f2 = new Field();
       Field f3 = new Field();
       o.setField(f);
       f.addNeighbour(f2);
       f2.addNeighbour(f);
       f2.addNeighbour(f3);
       System.out.println(" ");
        DepthWriter dw = new DepthWriter("Orangutan Move Szekvencia without follower: ");

       o.step(f2);
       System.out.println(" ");
       System.out.println("Test adatok felvétele: ");

        Panda p = new SleepyPanda();
       p.setField(f3);
       p.setCatcher(o);
       o.setFollower(p);
       o.setField(f);
        dw.reset();
       System.out.println(" ");
        DepthWriter dw2 = new DepthWriter("Orangutan Move Szekvencia with follower: ");
       o.step(f2);
        dw2.reset();
   }

    public static void OrangutanCatchPanda() {
        System.out.println("Test adatok felvétele: ");
        Orangutan o = new Orangutan();
        Panda p = new SleepyPanda();

        Field f = new Field();
        Field f2 = new Field();
        Field f3 = new Field();

        o.setField(f);
        p.setField(f2);
        f.setFieldElement(o);
        f2.setFieldElement(p);

        f.addNeighbour(f2);
        f2.addNeighbour(f);
        f2.addNeighbour(f3);

        DepthWriter dw = new DepthWriter("Orangutan catch Panda: ");
        o.step(f2);
        dw.reset();
    }

    public static void OrangutanExit() {
        System.out.println("Test adatok felvétele: ");
        Orangutan o = new Orangutan();
        Panda p = new SleepyPanda();

        Field f = new Field();
        Field f2 = new Field();
        Field f3 = new Field();
        Field f4 = new Field();

        Exit e = new Exit();
        f2.setFieldElement(e);
        e.setEntrance(f3);

        o.setField(f);
        f.setFieldElement(o);
        p.setField(f4);
        f4.setFieldElement(p);

        o.setFollower(p);
        p.setCatcher(o);
        p.setAnterior(o);

        System.out.println("  ");
        DepthWriter dw = new DepthWriter("Orangutan goes Narnia: ");
        o.step(f2);
        dw.reset();
    }

    public static void OrangutanEnterWardrobe() {

    }

    public static void OrangutanDie() {
        Orangutan o = new Orangutan();
        Panda p = new SleepyPanda();
        Floor fr = new Floor();

        o.setFollower(p);
        p.setCatcher(o);
        p.setAnterior(o);
        o.setFloor(fr);

        o.die();
    }
}
