package test;

import businesslogic.Orangutan;
import businesslogic.Field;
import businesslogic.Panda;

public class TestOrangutan {
    public static void OrangutanMove() {
       Orangutan o = new Orangutan();
       Field f = new Field();
       Field f2 = new Field();
       Field f3 = new Field();
       o.setField(f);
       f.addNeighbour(f2);
       f2.addNeighbour(f);
       f2.addNeighbour(f3);
       System.out.println(" ");
       System.out.println("Orangutan Move Szekvencia without follower: ");

       o.step(f2);

       System.out.println(" ");
       System.out.println("Orangutan Move Szekvencia with follower: ");
       Panda p = new Panda();
       p.setField(f3);
       p.setCatcher(o);
       o.setFollower(p);
       o.setField(f);
       o.step(f2);

   }

    public static void OrangutanCatchPanda() {

    }

    public static void OrangutanExit() {

    }

    public static void OrangutanEnterWardrobe() {

    }

    public static void OrangutanDie() {

    }
}
