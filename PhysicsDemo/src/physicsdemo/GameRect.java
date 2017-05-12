package physicsdemo;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class GameRect {
    private int x;
    private int y;
    private int width;
    private int height;

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
    public int getRight(){return x + width; }

    public GameRect translate(GameRect gameRect) {
        return new GameRect(this.x + gameRect.getX(), this.y + gameRect.y, gameRect.getWidth(), gameRect.getHeight());
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
}
