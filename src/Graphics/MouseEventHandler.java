package Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventHandler extends MouseAdapter {
    private View view;

    MouseEventHandler(View v) {
        view = v;
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) return;
        view.clickedAt(e.getX(), e.getY());
    }
}
