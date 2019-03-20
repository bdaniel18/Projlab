package test;

import businesslogic.DepthWriter;
import businesslogic.Orangutan;
import businesslogic.Field;
import businesslogic.*;

public class TestOrangutan {
    /*Orangutan lépését figyeljük meg követővel illetve anélkül
     */
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
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");

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
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
       o.step(f2);
        dw2.reset();
   }
    /*
    Orangutan elkap egy pandát
     */
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
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        o.step(f2);
        dw.reset();
    }
    /*
    Orangutan kimegy a kijáraton egy pandával
     */
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
        DepthWriter dw = new DepthWriter("Orangutan Exit: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        o.step(f2);
        dw.reset();
    }
    /*
    Orangután bemegy egy szekrénybe egy pandával
     */
    public static void OrangutanEnterWardrobe() {
        System.out.println("Test adatok felvétele: ");
        Orangutan o = new Orangutan();
        Panda p = new SleepyPanda();

        Field f = new Field();
        Field f2 = new Field();
        Field f3 = new Field();

        Field wf1 = new Field();
        Field wf2 = new Field();

        Wardrobe wr1 = new Wardrobe();
        Wardrobe wr2 = new Wardrobe();
        wr1.setTarget(wr2);

        wr1.setField(wf1);
        wf1.setFieldElement(wr1);

        wr2.setField(wf2);
        wf2.setFieldElement(wr2);
        wf2.addNeighbour(f3);

        o.setField(f);
        f.setFieldElement(o);
        p.setField(f2);
        f2.setFieldElement(p);

        o.setFollower(p);
        p.setCatcher(o);
        p.setAnterior(o);

        System.out.println("  ");
        DepthWriter dw = new DepthWriter("Orangutan Goes Wardrobe: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        o.step(wf1);
        dw.reset();
    }
    /*
    Orangután meghal
     */
    public static void OrangutanDie() {
        System.out.println("Test adatok felvétele: ");
        Orangutan o = new Orangutan();
        Panda p = new SleepyPanda();
        Floor fr = new Floor();

        o.setFollower(p);
        p.setCatcher(o);
        p.setAnterior(o);
        o.setFloor(fr);

        System.out.println("  ");
        DepthWriter dw = new DepthWriter("Orangutan Die: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        o.die();
        dw.reset();
    }
}