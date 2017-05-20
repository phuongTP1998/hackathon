package physicsdemo;

import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.Controller;
import physicsdemo.enemies.EnemyBullet;

import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class GameObject extends Controller implements Collider {
    protected GameRect gameRect;
    protected SpriteRenderer spriteRenderer;
    static boolean clear = false;

    private static List<GameObject> gameObjects;

    static {
        gameObjects = new Vector<>();
    }

    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public static void setClear(boolean clear) {
        GameObject.clear = clear;
    }

    public static void updateAll() {
        if (clear == true) {
            Iterator<GameObject> iterator = gameObjects.iterator();
            while (iterator.hasNext()) {
                GameObject gameObject = iterator.next();
                iterator.remove();
            }
            // controllers =null;
        }
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).update();
        }

        for (GameObject gameObject : gameObjects) {
            gameObject.lateUpdate();
        }
    }


    public static void remove(GameObject gameObject) {
        if (gameObject.getGameRect().isDead()) {
            gameObjects.remove(gameObject);
        }
    }

    public static void drawAll(Graphics graphics) {
        for(int i=0;i<gameObjects.size();i++){
            gameObjects.get(i).draw(graphics);
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

    public void lateUpdate() {
    }

    public GameRect getGameRect() {
        return gameRect;
    }


    @Override
    public void onCollide(Collider other) {

    }

}
