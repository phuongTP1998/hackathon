package physicsdemo.enemies;

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
public class SecondEnemyController extends EnemyController {
    private int cooldown = 150;
    private Animation animation;

    public SecondEnemyController(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        this.setMoveBehavior(new FlyBehavior());
        ArrayList<Image> images = new ArrayList<>();
        images.add(Utils.loadImage("res/Bat/bat-left-1.png"));
        images.add(Utils.loadImage("res/Bat/bat-left-2.png"));
        images.add(Utils.loadImage("res/Bat/bat-left-3.png"));
        images.add(Utils.loadImage("res/Bat/bat-left-4.png"));
        animation = new Animation(images,5,false);
    }

    @Override
    public void draw(Graphics graphics) {
        animation.draw(graphics,gameRect);
    }

    @Override
    public void setMoveBehavior(MoveBehavior moveBehavior) {
        super.setMoveBehavior(moveBehavior);
    }

    @Override
    public void shooting() {
        EnemyBullet enemyBullet = new EnemyBullet(new GameRect(this.gameRect.getX(),this.gameRect.getY(),30,30),new SpriteRenderer("res/bomb.png"));
        enemyBullet.setMoveBehavior(new HorzMoveBehavior());
    }

    @Override
    public void update() {
        //shooting
        cooldown--;
        if(cooldown<=0){
            shooting();
            cooldown=150;
        }


        //moving
        if(gameRect.getX()<=initPosX){
            dx=2;
        }else if(gameRect.getX()>=initPosX+150){
            dx=-2;
        }
        gameRect.move(dx,0);
    }
}
