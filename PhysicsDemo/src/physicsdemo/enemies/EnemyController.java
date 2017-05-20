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
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Quang Minh on 13/05/2017.
 */
public class EnemyController extends GameObject implements Collider {
    protected int dx;
    protected int dy;
    private MoveBehavior moveBehavior;
    private boolean isGrounded;
    private boolean isLeft=false;
    private boolean shootEnable;
    private int cooldown = 200;
    protected int initPosX;
    private int damage = 1;
    private Animation animationLeft;
    private Animation animationRight;

    public EnemyController(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx = 0;
        dy = 0;
        moveBehavior = new MoveBehavior();
        initPosX = gameRect.getX();
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);

        ArrayList<Image> imagesLeft = new ArrayList<>();
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_1.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_2.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_3.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_4.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_5.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_6.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_7.png"));
        imagesLeft.add(Utils.loadImage("res/walkEnemy/walkEnemy_left_8.png"));
        animationLeft = new Animation(imagesLeft,10,false);

        ArrayList<Image> imagesRight = new ArrayList<>();
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_1.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_2.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_3.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_4.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_5.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_6.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_7.png"));
        imagesRight.add(Utils.loadImage("res/walkEnemy/walkEnemy_right_8.png"));
        animationRight = new Animation(imagesRight,10,false);
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
        if(isLeft){
            animationLeft.draw(graphics,gameRect);
        } else {
            animationRight.draw(graphics,gameRect);
        }
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
                dx = 1;
                isLeft = false;
            } else if (gameRect.getX() >= initPosX + 150) {
                dx = -1;
                isLeft= true;
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
