package physicsdemo.enemies;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.Collider;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;
import physicsdemo.controller.MoveBehavior;
import physicsdemo.cows.Cow;
import physicsdemo.cows.Milk;
import physicsdemo.obstacles.Ground;
import physicsdemo.physics.Physics2D;

import java.awt.*;

/**
 * Created by Quang Minh on 13/05/2017.
 */
public class EnemyController extends GameObject implements Collider {
    protected int dx;
    protected int dy;
    private MoveBehavior moveBehavior;
    private boolean isGrounded;
    private boolean isLeft;
    private boolean shootEnable;
    private int cooldown = 200;
    protected int initPosX;
    private int damage = 1;


    public EnemyController(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx = 0;
        dy = 0;
        moveBehavior = new MoveBehavior();
        initPosX = gameRect.getX();
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);
    }

    public void setShootEnable(boolean shootEnable) {
        this.shootEnable = shootEnable;
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
        GameObject.remove(this);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    public int getDamage() {
        return damage;
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    public void shooting() {
        EnemyBullet enemyBullet = new EnemyBullet(new GameRect(this.gameRect.getX(), this.gameRect.getY(), 30, 10),
                new SpriteRenderer("res/bullet-left.png"));
        enemyBullet.setMoveBehavior(new MoveBehavior());
    }

    @Override
    public void update() {
        dy += Physics2D.GRAVITY;
        isGrounded = false;

        GameObject gameObject = GameObject.objectAt(gameRect.getX(), gameRect.getBottom() + dy);

        if (gameObject != null && gameObject instanceof Ground) {
            dy = 0;
            GameRect groundRect = gameObject.getGameRect();
            while (gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded = true;
        }

        if(shootEnable){
            cooldown--;
            if (cooldown <= 0) {
                shooting();
                cooldown = 100;
            }
        }

        //move behavior
        if (!isGrounded) {
            dx = 0;
        } else {
            if (gameRect.getX() <= initPosX) {
                dx = 2;
            } else if (gameRect.getX() >= initPosX + 150) {
                dx = -2;
            }
        }

        gameRect.move(dx, dy);
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof Cow) {
            ((Cow) other).getHit(damage);
        }else if (other instanceof Milk) {
            ((Milk) other).getHit(damage);
        }
    }
}
