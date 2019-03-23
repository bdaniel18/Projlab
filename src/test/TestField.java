package test;

import businesslogic.*;

/** Orangutan Törékeny mezőre lép aminek 1 a durability-e
 *
 */
public class TestField {
    public static void FieldBreak() {
        System.out.println("Test adatok felvétele: ");
        Field f = new Field();
        Floor fr = new Floor();

        f.setDurability(1);
        f.setFragile(true);

        Orangutan o = new Orangutan();
        Field f2 = new Field();
        f2.setFieldElement(o);
        o.setField(f2);
        o.setFloor(fr);

        System.out.println("  ");
        DepthWriter.print("Orangutan steps on Fragile Field: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        o.step(f);
        DepthWriter.reset();
    }
}
