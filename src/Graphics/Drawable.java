package Graphics;

import javax.swing.*;
import java.awt.*;

/**
 * A FieldElementek, és a bejárat grafikus megfelelője
 */
public class Drawable {
    private int id; // az eredeti objektum idje
    private ImageIcon icon; //  a kirajzolandó ikon
    private Vertex position; // a kirajzolás helye
    private int width = 0, height = 0; // a mérete

    public Drawable(int _id) {
        id = _id;
    }

    public int getId() {
        return id;
    }

    public void setIcon(ImageIcon img) {
        icon = img;
    }

    public void setPosition(Vertex v) {
        position = v;
    }

    public void setHeight(int h) {
        height = h;
    }

    public void setWidth(int w) {
        width = w;
    }

    /**
     * Kirajzolódik az ikon a kapott grafikus felületre
     *
     * @param g a grafikus felület, amire kirajzoljuk
     */
    public void draw(Graphics g) {
        g.drawImage(icon.getImage(), position.x, position.y, width, height, null);
    }


}
