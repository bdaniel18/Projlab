package test;

import businesslogic.*;

import java.util.HashMap;
import java.util.Map;

/**
 * A pandát tesztelő osztály
 */
public class TestPanda  {

    /**
     * A panda mozgását tesztelő osztály
     */
    public static void PandaMove() {
        System.out.println("Teszt adatok felvétele: ");
        Panda panda = new CowardPanda();
        Field f = new Field();
        Field f2 = new Field();
        f.addNeighbour(f2);
        panda.setField(f);

        System.out.println(" ");
        DepthWriter.print("Panda Move Szekvencia: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");

        panda.step();
    }

    /**
     * Panda az exithez ér(vagy az őt elkapó orángután)
     */

    public static void PandaExit() {
        System.out.println("Teszt adatok felvétele: ");
        Panda p1 = new CowardPanda();
        Panda p2 = new JumpyPanda();
        Orangutan o = new Orangutan();
        p1.setFollower(p2);
        p2.setFollower(null);
        p1.setCatcher(o);
        p2.setCatcher(o);

        Floor floor = new Floor();
        Field field = new Field();
        Field f2 = new Field();
        Field f3 = new Field();
        floor.addField(field);
        floor.addField(f2);
        floor.addField(f3);

        floor.add(p1);
        floor.add(p2);
        p1.setFloor(floor);
        p2.setFloor(floor);
        Exit exit = new Exit();
        field.setFieldElement(exit);

        System.out.println(" ");
        DepthWriter.print("Panda Exit Szekvencia: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");

        p1.exitReached();
    }

    public static void PandaEnterWardrobe() {
        System.out.println("Teszt adatok felvétele: ");
        /**
         * Mezők létrehozása
         */
        Floor floor = new Floor();
        Field f1 = new Field();
        Field f2 = new Field();
        Field f3 = new Field();
        floor.addField(f1);
        floor.addField(f2);
        floor.addField(f3);
        f2.addNeighbour(f3);

        /**
         * Steppable-k létrehozása
         */
        Panda p = new JumpyPanda();
        Orangutan o = new Orangutan();
        p.setCatcher(o);
        o.setLastSteppedOn(f2);

        /**
         * Szekrények létrehozása
         */
        Wardrobe w = new Wardrobe();
        Wardrobe target = new Wardrobe();

        w.setTarget(target);
        f1.setFieldElement(w);
        f2.setFieldElement(target);

        Map<Orangutan, Field> targetField = new HashMap<Orangutan, Field>();
        targetField.put(o, f3);
        target.setTargetField(targetField);

        /**
         * Függvényhívás, szekvenciakiírás
         */

        System.out.println(" ");
        DepthWriter.print("Panda Exit Szekvencia: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");

        w.hitBy(p);

    }

    public static void PandaDie() {
        System.out.println("Teszt adatok felvétele: ");

        Panda p1 = new JumpyPanda();
        Panda p2 = new SleepyPanda();
        Floor floor = new Floor();
        Field f1 = new Field();
        floor.addField(f1);
        floor.add(p1);
        f1.setFieldElement(p1);
        p1.setFollower(p2);
        p2.setFollower(null);
        p1.setFloor(floor);


        System.out.println(" ");
        DepthWriter.print("Panda Move Szekvencia: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");

        p1.die();
    }

    public static void PandaJump() {

    }

    public static void PandaSleep() {

    }

    public static void PandaScared() {

    }


}
