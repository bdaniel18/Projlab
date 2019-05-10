package Graphics;

import businesslogic.Field;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Egy játékbeli mező grafikus léte.
 */
public class FieldView {
    private ArrayList<Vertex> vertices;
    private int id;
    private Color color;
    private Color borderColor = Color.BLUE;

    private static final Color FRAGILE_COLOR = new Color(147, 177, 130),
            NON_FRAGILE_COLOR = new Color(128, 177, 205),
            BROKEN_COLOR = Color.BLUE,
            GOING_TO_STEP = new Color(255, 255, 110),
            GOING_TO_STEP_FOLLOWER = new Color(255, 127, 80);

    private Polygon polygon;
    private Vertex middle;

    public FieldView(Field f) {
        id = f.getId();
        vertices = f.getVertices();
        getMiddle(); // init middle

        //TODO COLOR SET

        int x[] = new int[vertices.size()];
        int y[] = new int[vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            Vertex v = vertices.get(i);
            x[i] = v.x;
            y[i] = v.y;
        }
        polygon = new Polygon(x, y, vertices.size());
    }

    public Rectangle2D.Double getMaxRectangle(int width, int height) {
        double dw = (double) 2 * width / height, dh = 2;
        double w = 2, h = 2;
        Rectangle2D.Double rect
                = new Rectangle2D.Double(middle.x - w / 2, middle.y - h / 2, w, h);
        Rectangle2D.Double fitRect = rect;
        while (polygon.contains(rect)) {
            fitRect = rect;
            w += dw;
            h += dh;
            rect = new Rectangle2D.Double(middle.x - w / 2, middle.y - h / 2, w, h);
        }
        return fitRect;
    }

    public Polygon getPolygon() {
        return polygon;
    }

    public int getId() {
        return id;
    }

    public Vertex getMiddle() {
        if (middle == null) {
            middle = new Vertex();
            for (int i = 0; i < vertices.size(); i++) {
                Vertex v = vertices.get(i);
                middle.x += v.x;
                middle.y += v.y;
            }
            middle.x = middle.x / vertices.size();
            middle.y = middle.y / vertices.size();
        }
        return middle;
    }

    public void draw(java.awt.Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(color);
        g2.fillPolygon(polygon);

        g2.setColor(borderColor);
        g2.setStroke(new BasicStroke(3));
        g2.drawPolygon(polygon);
    }


}
