import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import businesslogic.*;


public class Main {

    // hány tabulátor kell a fv név kiírásához, meghívott függvény növeli, visszatéréskor csökkenti
    public static int depth = 0;

    //adott darab tabulátort ír ki a konzolra
    public static void printTabs(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println("   ");
        }
    }

    private static final int BASE_MENU = 0, ORANGUTAN_MENU = 1, PANDA_MENU = 2,
            FURNITURE_MENU = 3, FIELD_MENU = 4, FLOOR_MENU = 5, EXIT_GAME = 6;

    private static void printMenu(int type) {
        switch (type) {
            case BASE_MENU:
                System.out.println("Orangutan test -> 1");
                System.out.println("Panda test -> 2");
                System.out.println("Furniture test -> 3");
                System.out.println("Field test -> 4");
                System.out.println("Floor test -> 5");
                System.out.println("Exit Game -> 6");
                break;

            case ORANGUTAN_MENU:
                System.out.println("Base Menu -> 0");
                System.out.println("Orangutan step -> 1");
                System.out.println("Orangutan catches Panda -> 2");
                System.out.println("Orangutan exit -> 3");
                System.out.println("Orangutan enters Wardrobe -> 4");
                System.out.println("Orangutan die -> 5");
                break;

            case PANDA_MENU:
                System.out.println("Base Menu -> 0");
                System.out.println("Panda step -> 1");
                System.out.println("Panda exit -> 2");
                System.out.println("Panda enters Wardrobe -> 3");
                System.out.println("Panda die -> 4");
                System.out.println("Panda jump -> 5");
                System.out.println("Panda sleep -> 6");
                System.out.println("Panda scared -> 7");
                break;

            case FURNITURE_MENU:
                System.out.println("Base Menu -> 0");
                System.out.println("Sofa activate -> 1");
                System.out.println("GamblingMachine activate -> 2");
                System.out.println("ChocolateMachine activate -> 3");
                break;

            case FIELD_MENU:
                System.out.println("Base Menu -> 0");
                System.out.println("Field breaks -> 1");
                break;

            case FLOOR_MENU:
                System.out.println("Base Menu -> 0");
                System.out.println("New Turn -> 1");
                break;
            default:
        }

    }

    public static void main(String[] args) throws IOException {
        System.out.println("Main.main()");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int menuLayer = BASE_MENU, chosenMenu;

        while (true) {
            printMenu(menuLayer);
            System.out.println("Valasztott menupont:");
            chosenMenu = Integer.parseInt(reader.readLine());

            switch (menuLayer) {
                case BASE_MENU:
                    if (chosenMenu >= ORANGUTAN_MENU && chosenMenu <= FLOOR_MENU)
                        menuLayer = chosenMenu;
                    else if (chosenMenu == EXIT_GAME) return;
                    else System.out.println("Hibas menupont.");
                    break;

                case ORANGUTAN_MENU:
                    switch (chosenMenu) {
                        case BASE_MENU:
                            menuLayer = BASE_MENU;
                            break;
                        case 1:
                            test.TestOrangutan.OrangutanMove();
                            break;
                        case 2:
                            test.TestOrangutan.OrangutanCatchPanda();
                            break;
                        case 3:
                            test.TestOrangutan.OrangutanExit();
                            break;
                        case 4:
                            test.TestOrangutan.OrangutanEnterWardrobe();
                            break;
                        case 5:
                            test.TestOrangutan.OrangutanDie();
                            break;
                        default:
                            System.out.println("Hibas menupont");
                    }
                    break;

                case PANDA_MENU:
                    switch (chosenMenu) {
                        case BASE_MENU:
                            menuLayer = BASE_MENU;
                            break;
                        case 1:
                            test.TestPanda.PandaMove();
                            break;
                        case 2:
                            test.TestPanda.PandaExit();
                            break;
                        case 3:
                            test.TestPanda.PandaEnterWardrobe();
                            break;
                        case 4:
                            test.TestPanda.PandaDie();
                            break;
                        case 5:
                            test.TestPanda.PandaJump();
                            break;
                        case 6:
                            test.TestPanda.PandaSleep();
                            break;
                        case 7:
                            test.TestPanda.PandaScared();
                            break;
                        default:
                            System.out.println("Hibas menupont");
                    }
                    break;
                case FIELD_MENU:
                    if (chosenMenu == BASE_MENU) menuLayer = BASE_MENU;
                    else if (chosenMenu == 1) test.TestField.FieldBreak();
                    else System.out.println("Hibas menupont");
                    break;
                case FLOOR_MENU:
                    if (chosenMenu == BASE_MENU) menuLayer = BASE_MENU;
                    else if (chosenMenu == 1) test.TestFloor.NewTurn();
                    else System.out.println("Hibas menupont");
                    break;

                default:

            }


        }
    }

}
