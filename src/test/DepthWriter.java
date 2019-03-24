package test;

/** Használata: DepthWriter.print(str: string) Paraméterként kapott stringet a megfelelő mennyiségű behúzással írja ki (depth = mélység, továbbiakban a behúzások számát jelenti)
 * Egy függvényel belüli függvény hívások előtt az Depthwriter.Add() növeli a mélységet majd miután visszatért a DeptWriter.reduce() csökkenti azt
 * A DeepthWriter.reset() a mélységet csökkenti 0-ra
 */
public class DepthWriter {

    public static int depth = 0; // a tabulátorok száma a kiíráskor

    public DepthWriter(String str){
        System.out.println(str);
    }

    /**
     * A kapott stringet annyi tabulátor után írja ki amennyi a depth értéke.
     * @param str a kiírandó szöveg
     */
    public static void print(String str){
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
        System.out.println(str);
    }

    public static void add() {
        depth++;
    }
    public static void reduce() {
        depth--;
    }
    public static void reset() {
        depth = 0;
    }
}
