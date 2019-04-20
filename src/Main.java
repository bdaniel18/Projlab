import businesslogic.Game;

import java.util.Scanner;

public class Main {

    static Game game = Game.getInstance();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            try {
                game.newGame(s);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

}
