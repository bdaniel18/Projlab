package Graphics;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Az egérkattintásokért felel a játék pályáján
 */
public class MouseEventHandler extends MouseAdapter {
    private View view;

    MouseEventHandler(View v) {
        view = v;
    }

    /**
     * Egérkattintás történt, szól a nézetnek
     *
     * @param e az egérkattintás adatai
     */
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() != MouseEvent.BUTTON1) return;
        view.clickedAt(e.getX(), e.getY());
    }
}
