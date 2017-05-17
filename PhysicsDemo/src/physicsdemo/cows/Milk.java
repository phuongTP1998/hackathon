package physicsdemo.cows;

import physicsdemo.Collider;
import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;
import physicsdemo.enemies.EnemyController;
import physicsdemo.gameScenes.Level1Scene;
import physicsdemo.physics.Physics2D;

import java.awt.*;

/**
 * Created by zTitiK on 15-May-17.
 */
public class Milk extends GameObject implements Collider {
    private int dx, dy;
    private boolean moveLeft;
    private boolean maxHeight = false;
    GameRect cowNow;
    int damage = 1;


    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
        if (moveLeft)
            this.gameRect = new GameRect(gameRect.getX(),
                    gameRect.getBottom() - gameRect.getHeight() / 2,
                    spriteRenderer.getImage().getWidth(null),
                    spriteRenderer.getImage().getHeight(null));
        else
            this.gameRect = new GameRect(gameRect.getRight(),
                    gameRect.getBottom() - gameRect.getHeight() / 2,
                    spriteRenderer.getImage().getWidth(null),
                    spriteRenderer.getImage().getHeight(null));
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
        GameObject.remove(this);
        ControllerManager.instance.remove(this);
        Level1Scene.milks.remove(this);
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof EnemyController) {

            ((EnemyController) other).getHit(damage);
        }
    }

    public Milk(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);
        Level1Scene.milks.add(this);
        cowNow = gameRect;
    }

    int countDown = 3;

    @Override
    public void update() {
        if (moveLeft) {
            dx = -15;
        } else {
            dx = 15;
        }
        //     if (countDown == 0) {
        if (this.gameRect.getY() <= cowNow.getY()) {
            maxHeight = true;
            dy = 0;
        }
        if (maxHeight) {
            dy += Physics2D.GRAVITY / 2;
        } else {
            dy -= 1;
        }
        this.gameRect.move(dx, dy);
        //      countDown = 3;
        //  } else {
        //       countDown--;
        //  }
    }
}
