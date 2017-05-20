package physicsdemo.enemies;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.Collider;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;
import physicsdemo.controller.MoveBehavior;
import physicsdemo.cows.Cow;

import java.awt.*;

/**
 * Created by Quang Minh on 14/05/2017.
 */
public class EnemyBullet extends GameObject implements Collider {
    private int damage = 1;
    private MoveBehavior moveBehavior;

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public EnemyBullet(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);
        moveBehavior = new MoveBehavior();
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
        GameObject.remove(this);
    }

    public int getDamage() {
        return damage;
    }


    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    @Override
    public void update() {
        moveBehavior.move(gameRect);
        if (gameRect.getX() < 0 || gameRect.getY() > 700) {
            getHit(0);
        }
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof Cow) {
            ((Cow) other).getHit(damage);
        }
    }
}
