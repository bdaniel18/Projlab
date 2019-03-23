package test;

import businesslogic.*;

/**
 * Aktiválható tárgyakat tesztelő osztály
 */
public class TestFurniture {

    /**
     * Teszteli a Sofa aktiválódását.
     * A fotelben inicializál egy alvó pandát.
     */
    public static void SofaActivate() {
        Field f = new Field();
        Field[] ff = new Field[3];
        for (int i = 0; i < ff.length; i++) {  // mezők létrehozása, és szomszédságok beállítása
            ff[i] = new Field();
            f.addNeighbour(ff[i]);
        }
        Sofa sofa = new Sofa();
        sofa.setPanda(new SleepyPanda());
        f.setFieldElement(sofa);

        ff[0].setFieldElement(new Orangutan());
        ff[2].setFieldElement(new Wardrobe());

        System.out.println("  ");
        DepthWriter.print("Activate GamblingMachine: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        sofa.activate();
        DepthWriter.reset();

    }

    /**
     * Teszteli a GamblingMachine aktiválódását
     */
    public static void GMActivate() {
        System.out.println("Teszt adatok felvétele:");
        Field f = new Field();
        Field[] ff = new Field[3];
        for (int i = 0; i < ff.length; i++) {  // mezők létrehozása, és szomszédságok beállítása
            ff[i] = new Field();
            f.addNeighbour(ff[i]);
        }
        Activateable gm = new GamblingMachine();
        f.setFieldElement(gm);

        ff[0].setFieldElement(new Orangutan());
        ff[2].setFieldElement(new Sofa());

        System.out.println("  ");
        DepthWriter.print("Activate GamblingMachine: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        gm.activate();
        DepthWriter.reset();
    }

    /**
     * Teszteli a ChocolateMachine aktiválódását
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
        DepthWriter.print("Activate ChocolateMachine: ");
        System.out.println("-+-+-+-+-+-+-+-+-+-+-+-+-");
        cm.activate();
        DepthWriter.reset();
    }
}
