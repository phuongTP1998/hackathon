package physicsdemo.enemies;

import physicsdemo.Collider;
import physicsdemo.GameRect;
import physicsdemo.controller.FlyBehavior;
import physicsdemo.controller.HorzMoveBehavior;
import physicsdemo.controller.MoveBehavior;
import physicsdemo.SpriteRenderer;
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Quang Minh on 13/05/2017.
 */
public class SecondEnemyController extends EnemyController implements Collider {
    private int cooldown = 200;
    private Animation animationLeft;
    private Animation animationRight;
    private boolean isLeft=false;

    public SecondEnemyController(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        this.setMoveBehavior(new FlyBehavior());

        ArrayList<Image> imagesLeft = new ArrayList<>();
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_1.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_2.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_3.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_4.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_5.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_6.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_7.png"));
        imagesLeft.add(Utils.loadImage("res/bird/bird_left_8.png"));
        animationLeft = new Animation(imagesLeft,10,false);

        ArrayList<Image> imagesRight = new ArrayList<>();
        imagesRight.add(Utils.loadImage("res/bird/bird_right_1.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_2.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_3.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_4.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_5.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_6.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_7.png"));
        imagesRight.add(Utils.loadImage("res/bird/bird_right_8.png"));
        animationRight = new Animation(imagesRight,10,false);
    }

    public void shooting() {
        EnemyBullet enemyBullet = new EnemyBullet(new GameRect(this.gameRect.getX(), this.gameRect.getY(), 30, 30),
                new SpriteRenderer("res/bomb.png"));
        enemyBullet.setMoveBehavior(new HorzMoveBehavior());
    }

    @Override
    public void draw(Graphics graphics) {

        if(isLeft){
            animationLeft.draw(graphics,gameRect);
        } else {
            animationRight.draw(graphics,gameRect);
        }
    }

    @Override
    public void setMoveBehavior(MoveBehavior moveBehavior) {
        super.setMoveBehavior(moveBehavior);
    }

    @Override
    public void update() {
        cooldown--;
        if(cooldown<=0){
            shooting();
            cooldown=200;
        }

        if (gameRect.getX() <= initPosX) {
            dx = 2;
            isLeft = false;
        } else if (gameRect.getX() >= initPosX + 300) {
            dx = -2;
            isLeft = true;
        }
        gameRect.move(dx,0);
    }

    @Override
    public void onCollide(Collider other) {
        super.onCollide(other);
    }
}
