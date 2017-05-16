package physicsdemo.enemies;

import javafx.collections.ArrayChangeListener;
import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.HorzMoveBehavior;
import physicsdemo.controller.MoveBehavior;
import physicsdemo.obstacles.Ground;
import physicsdemo.physics.Physics2D;
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Quang Minh on 13/05/2017.
 */
public class EnemyController extends GameObject{
    protected int dx;
    protected int dy;
    private MoveBehavior moveBehavior;
    private boolean isGrounded;
    private boolean isLeft;
    private int cooldown = 100;
    protected int initPosX;
    private Animation animation;

    public EnemyController(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx=0;
        dy=0;
        moveBehavior = new MoveBehavior();
        initPosX = gameRect.getX();
        ArrayList<Image> images = new ArrayList<>();
        images.add(Utils.loadImage("res/Minh/run-left-1.png"));
        images.add(Utils.loadImage("res/Minh/run-left-2.png"));
        images.add(Utils.loadImage("res/Minh/run-left-3.png"));
        images.add(Utils.loadImage("res/Minh/run-left-4.png"));
        animation = new Animation(images,5,false);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
        //animation.draw(graphics,gameRect);
    }

    public void setMoveBehavior(MoveBehavior moveBehavior){
        this.moveBehavior = moveBehavior;
    }

    public void shooting(){
        EnemyBullet enemyBullet = new EnemyBullet(new GameRect(this.gameRect.getX(),this.gameRect.getY(),30,10),new SpriteRenderer("res/bullet-left.png"));
        enemyBullet.setMoveBehavior(new MoveBehavior());
    }

    @Override
    public void update() {
        dy += Physics2D.GRAVITY;
        isGrounded=false;

        GameObject gameObject = GameObject.objectAt(gameRect.getX(), gameRect.getBottom() + dy);

        if(gameObject != null && gameObject instanceof Ground) {
            dy = 0;
            GameRect groundRect = gameObject.getGameRect();

            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded=true;
        }
        //shooting
        cooldown--;
        if(cooldown<=0){
            shooting();
            cooldown=100;
        }

        //move behavior
        if(!isGrounded){
            dx=0;
        }
        else{
            if(gameRect.getX()<=initPosX){
                dx=2;
            }else if(gameRect.getX()>=initPosX+150){
                dx=-2;
            }
        }

        gameRect.move(dx,dy);
    }
}
