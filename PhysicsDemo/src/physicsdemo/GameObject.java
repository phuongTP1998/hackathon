package physicsdemo;

import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class GameObject {
    protected GameRect gameRect;
    protected SpriteRenderer spriteRenderer;

    private static List<GameObject> gameObjects;

    static {
        gameObjects = new Vector<>();
    }

    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }


    public static void updateAll() {
        for (GameObject gameObject : gameObjects) {
            gameObject.update();
        }
    }

    public static void drawAll(Graphics graphics) {
        for (GameObject gameObject : gameObjects) {
            gameObject.draw(graphics);
        }
    }

    public static GameObject objectAt(int x, int y) {
        for (GameObject gameObject : gameObjects) {
            if (gameObject.contains(x, y)) {
                return gameObject;
            }
        }
        return null;
    }

    public boolean contains(int x, int y) {
        return this.gameRect.contains(x, y);
    }

    public GameObject(GameRect gameRect, SpriteRenderer spriteRenderer) {
        this.gameRect = gameRect;
        this.spriteRenderer = spriteRenderer;
        gameObjects.add(this);
    }

    public void draw(Graphics graphics) {
        this.spriteRenderer.render(graphics, gameRect);
    }

    public void update() {

    }

    public GameRect getGameRect() {
        return gameRect;
    }
}
