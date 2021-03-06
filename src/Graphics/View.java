package Graphics;

import businesslogic.Field;
import businesslogic.FieldElement;
import businesslogic.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A játékhoz tartozó nézet, az ablakokat,
 * és a kirajzolható alkotóelemeket kezeli
 */
public class View {

    public View(Game g) {
        game = g;
        icons.put(Icons.PANDA, loadIcon("panda.png"));
        icons.put(Icons.SOFA, loadIcon("sofa.png"));
        icons.put(Icons.WARDROBE, loadIcon("wardrobe.png"));
        icons.put(Icons.CHOCOLATEMACHINE, loadIcon("chocolate_machine.png"));
        icons.put(Icons.ENTRANCE, loadIcon("entrance.png"));
        icons.put(Icons.EXIT, loadIcon("exit.png"));
        icons.put(Icons.GAMBLINGMACHINE, loadIcon("gambling_machine.png"));
        icons.put(Icons.ORANGUTAN, loadIcon("orangutan.png"));
        icons.put(Icons.SOFAPANDA, loadIcon("sofapanda.png"));

        gameIcon = loadIcon("icon.png");
        gameLogo = loadIcon("logo.png");

    }

    private Game game;
    private Options nextFrame = Options.MAINMENU; // a következő ablak ami meg fog nyílni, ha az előző bezárult
    private Frame frame = null; // aktuális ablak

    private ArrayList<Drawable> drawables = new ArrayList<>();
    private ArrayList<FieldView> fieldViews = new ArrayList<>();

    private Map<Icons, ImageIcon> icons = new HashMap<>(); // a kirajzolható ikonok gyűjteménye
    private ImageIcon gameIcon;
    private ImageIcon gameLogo;

    public void setNextFrame(Options o) {
        nextFrame = o;
    }

    public ArrayList<Drawable> getDrawables() {
        return drawables;
    }

    public ArrayList<FieldView> getFieldViews() {
        return fieldViews;
    }

    public FieldView getFieldViewForId(int id) {
        FieldView fw;
        for (int i = 0; i < fieldViews.size(); i++) {
            fw = fieldViews.get(i);
            if (fw.getId() == id) return fw;
        }
        return null;
    }


    public Game getGame() {
        return game;
    }

    public ImageIcon getGameIcon() {
        return gameIcon;
    }

    public ImageIcon getGameLogo() {
        return gameLogo;
    }

    /**
     * Atmeretez egy kepet a kert ertekre
     * @param srcImg a forráskép
     * @param w kért szélesség
     * @param h kért magasság
     * @return az átméretezett kép
     */
    public Image getScaledImage(Image srcImg, int w, int h) {
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg, 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    /**
     * Kitörli egy mező nézetét a nézetek közül
     *
     * @param id a mező id-je
     */
    public void removeFieldView(int id) {
        for (int i = 0; i < fieldViews.size(); i++) {
            FieldView fw = fieldViews.get(i);
            if (fw.getId() == id) fieldViews.remove(i);
        }
    }

    /**
     * Kitörli a kirajzolható ikont a nézetek közül
     * @param id a drawable idje
     */
    public void removeDrawable(int id) {
        for (int i = 0; i < drawables.size(); i++) {
            Drawable dw = drawables.get(i);
            if (dw.getId() == id) drawables.remove(i);
        }
    }

    /**
     * Hozzáad egy mezőt a nézethez
     * @param f a mező
     * @param fc a mező színe
     */
    public void add(Field f, FieldView.Colors fc) {
        removeFieldView(f.getId());
        fieldViews.add(new FieldView(f, fc));
        frame.repaint();
    }


    /**
     * Hozzáad egy fieldElementet a nézethez
     * @param fe fieldElement
     * @param ic az ikon, amivel majd meg kell jelennie a képernyőn
     */
    public void add(FieldElement fe, Icons ic) {
        removeDrawable(fe.getId());
        Drawable dw = new Drawable(fe.getId());
        FieldView fw = getFieldViewForId(fe.getField().getId());
        if (fw == null) return;
        dw.setPosition(fw.getMiddle());

        ImageIcon icon = icons.get(ic);
        Rectangle2D.Double rect = fw.getMaxRectangle(icon.getIconWidth(), icon.getIconHeight());
        dw.setPosition(new Vertex((int) (rect.x + 1), (int) (rect.y + 1)));
        dw.setHeight((int) rect.height);
        dw.setWidth((int) rect.width);
        dw.setIcon(icon);
        drawables.add(dw);
        frame.repaint();
    }

    /**
     * Hozzáad egy bejáratot a nézethez( nem FieldElement)
     * @param entrance a bejárat mezője
     */
    public void addEntrance(Field entrance) {
        int id = entrance.getId();
        removeDrawable(id);
        Drawable dw = new Drawable(id);
        FieldView fw = getFieldViewForId(id);
        if (fw == null) return;
        dw.setPosition(fw.getMiddle());
        dw.setIcon(icons.get(Icons.ENTRANCE));

        ImageIcon icon = icons.get(Icons.ENTRANCE);
        Rectangle2D.Double rect = fw.getMaxRectangle(icon.getIconWidth(), icon.getIconHeight());
        dw.setPosition(new Vertex((int) (rect.x + 1), (int) (rect.y + 1)));
        dw.setHeight((int) rect.height);
        dw.setWidth((int) rect.width);
        dw.setIcon(icon);
        drawables.add(dw);
    }

    /**
     * kitörli a nézeteket
     */
    public void clear() {
        drawables = new ArrayList<Drawable>();
        fieldViews = new ArrayList<FieldView>();
    }


    /**
     * Betölt egy ikont fájlból a /images mappából
     * @param name a fájl neve
     * @return a betöltött ikon
     */
    private ImageIcon loadIcon(String name) {
        String dir = System.getProperty("user.dir") + "\\images\\";
        ImageIcon ic = new ImageIcon(dir + name);
        return ic;
    }

    /**
     * A pályán kattintás történt, továbbítja a Game osztálynak, hogy
     * melyik mezőre lépjen az aktív orángután
     * @param x a kattintás x koordinátája
     * @param y a kattintás y koordinátája
     */
    public void clickedAt(int x, int y) {
        if (!getGame().getGameRunning()) return;
        for (int i = 0; i < fieldViews.size(); i++) {
            FieldView fw = fieldViews.get(i);
            Polygon poly = fw.getPolygon();
            if (poly.contains(x, y)) {
                int id = fw.getId();
                if (game.stepOrangutan(id)) {
                    GameEndDialog dialog = new GameEndDialog(frame, game.getGameWon(), game.getOrangutanResults());
                }
            }
        }
        ((GameFrame) frame).refreshLabels();
    }

    /**
     * Elindítja a játékot, addig váltogatja az ablakokat, amíg a felhasználó ki nem lép
     */
    public void start() {
        while (nextFrame != null) {
            switch (nextFrame) {
                case MAINMENU:
                    frame = new MainMenuFrame(this);
                    nextFrame = null;
                    break;
                case LOAD:
                    frame = new LoadMapFrame(this);
                    nextFrame = null;
                    break;
                case LEADERBOARD:
                    frame = new LeaderBoardFrame(this);
                    nextFrame = null;
                    break;
                case NEWGAME:
                    if (game.getMapid() < 0) {
                        nextFrame = Options.MAINMENU;
                        frame = null;
                    } else frame = new GameFrame(this);
                    break;
                default:
            }
            if (frame != null) frame.run();
        }
    }
}
