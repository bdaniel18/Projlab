package Graphics;

import businesslogic.Field;

import java.awt.*;
import java.util.ArrayList;

/**
 * Egy játékbeli mező grafikus léte.
 */
public class FieldView {
    private ArrayList<Vertex> vertices;
    private int id;
    private Color color = Color.CYAN;

    public void draw(java.awt.Graphics g) {
        int x[] = new int[vertices.size()];
        int y[] = new int[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);
            x[i] = v.x;
            y[i] = v.y;
        }
        Polygon p = new Polygon(x, y, vertices.size());
        g.setColor(color);
        g.drawPolygon(p);
    }

    public FieldView(Field f) {
        id = f.getId();
        vertices = f.getVertices();
    }
}
