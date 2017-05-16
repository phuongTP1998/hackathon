package physicsdemo.gameScenes;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public interface GameScenes {
    void keyPressed(KeyEvent e);

    void keyReleased(KeyEvent e);

    void draw(Graphics graphics);

    void update();
}
