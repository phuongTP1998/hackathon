package physicsdemo;

import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class InputManager {
    private boolean right;
    private boolean left;
    private boolean up;
    private boolean down;
    private boolean space;

    private static InputManager instance;

    public static InputManager getInstance() {
        return instance;
    }

    public InputManager() {
        instance = this;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = true;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = true;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = true;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            space = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            right = false;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = false;
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            down = false;
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            space = false;
        }
    }

    public boolean isRight() {
        return right;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public boolean isSpace() {
        return space;
    }
}
