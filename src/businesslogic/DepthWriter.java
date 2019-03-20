package businesslogic;

/*Haználata: a konstructorban kapott stringet kiírja a konzolra, a reset() beállítja a mélységet 0-ra
  *Amennyiben van leglább egy függvény hívás a fügvénnyen belül akkor meg kell hívni az add() függvényt a legelső fgv hívás előtt
*/
public class DepthWriter {
    public static int depth=0;
    public DepthWriter(String str){
        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }
        System.out.println(str);
    }
    public void add(){
        depth++;
    }
    public  void reset(){
        depth = 0;
    }
}
