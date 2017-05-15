package physicsdemo;

import physicsdemo.controller.CollisionManager;
import physicsdemo.enemies.EnemyBullet;

import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class GameObject implements Collider {
    protected GameRect gameRect;
    protected SpriteRenderer spriteRenderer;
    private int damage = 1;


    private static List<GameObject> gameObjects;

    static {
        gameObjects = new Vector<>();
    }

    public static List<GameObject> getGameObjects() {
        return gameObjects;
    }


    public static void updateAll() {
        for (int i = 0; i < gameObjects.size(); i++) {
            gameObjects.get(i).update();
        }

        for (GameObject gameObject : gameObjects) {
            gameObject.lateUpdate();
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

    public int getDamage() {
        return damage;
    }

    public boolean contains(int x, int y) {
        return this.gameRect.contains(x, y);
    }

    public GameObject(GameRect gameRect, SpriteRenderer spriteRenderer) {
        this.gameRect = gameRect;
        this.spriteRenderer = spriteRenderer;
        gameObjects.add(this);
        CollisionManager.instance.add(this);
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
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
        if (other instanceof EnemyBullet) {
            ((EnemyBullet) other).getHit(damage);
        }
    }
}
