package Graphics;

import javax.swing.*;
import java.awt.*;

public class Drawable {
    private int id;
    private ImageIcon icon;
    private Vertex position;
    private int width = 0, height = 0;

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

    public void draw(Graphics g) {
        g.drawImage(icon.getImage(), position.x, position.y, width, height, null);
    }


}
