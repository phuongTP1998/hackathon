package physicsdemo;

import java.awt.*;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class GameRect {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isDead;

    public GameRect(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean contains(int x, int y) {
        return this.x <= x && this.x + this.width >= x
                && this.y <= y && this.y + this.height >= y;
    }

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBottom() {
        return y + height;
    }

    public int getRight() {
        return x + width;
    }

    public int getCenterX() {
        return x + width / 2;
    }

    public int getCenterY() {
        return y + height / 2;
    }

    public GameRect translate(GameRect gameRect) {
        return new GameRect(this.x + gameRect.getX(), this.y + gameRect.y, gameRect.getWidth(), gameRect.getHeight());
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean intersects(GameRect other) {
        Rectangle rect1 = new Rectangle(x, y, width, height);
        Rectangle rect2 = new Rectangle(other.x, other.y, other.width, other.height);
        return rect1.intersects(rect2);
    }
}
