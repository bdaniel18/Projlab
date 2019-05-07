package Graphics;

import java.awt.*;
import java.util.ArrayList;

public class GameCanvas extends Canvas {

    private View view;

    public GameCanvas(View v) {
        view = v;
        setSize(new Dimension(1000, 1000));
    }

    public void paint(java.awt.Graphics g) {
        ArrayList<FieldView> fieldViews = view.getFieldViews();
        for (int i = 0; i < fieldViews.size(); i++)
            fieldViews.get(i).draw(g);

        ArrayList<Drawable> drawables = view.getDrawables();
        for (int i = 0; i < drawables.size(); i++)
            drawables.get(i).draw(g);

    }
}
