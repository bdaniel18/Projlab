package Graphics;

import javax.swing.*;
import java.awt.*;

public class Drawable {
    private int id;
    private ImageIcon icon;
    private Vertex position;

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

    public void draw(Graphics g) {
        //TODO
    }


}
