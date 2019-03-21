package test;

import businesslogic.*;

public class TestFurniture {

    public static void SofaActivate() {

    }

    public static void GMActivate() {

    }

    /**
     * Teszteli a ChocolateMachine activate() függvényét
     */
    public static void CMActivate() {
        System.out.println("Teszt adatok felvétele:");
        Field f = new Field();
        Field[] ff = new Field[3];
        for (int i = 0; i < ff.length; i++) {
            ff[i] = new Field();
            f.addNeighbour(ff[i]);
        }
        Activateable cm = new ChocolateMachine();
        f.setFieldElement(cm);

        ff[0].setFieldElement(new Orangutan());
        ff[2].setFieldElement(new Wardrobe());

        System.out.println("  ");
        DepthWriter dw = new DepthWriter("Activate ChocolateMachine: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        cm.activate();
        dw.reset();
    }
}
