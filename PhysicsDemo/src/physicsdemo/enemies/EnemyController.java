package physicsdemo.enemies;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.MoveBehavior;
import physicsdemo.obstacles.Ground;
import physicsdemo.physics.Physics2D;

import java.awt.*;

/**
 * Created by Quang Minh on 13/05/2017.
 */
public class EnemyController extends GameObject{
    private int dx;
    private int dy;
    private MoveBehavior moveBehavior;
    private boolean isGrounded;
    private boolean isLeft;

    public EnemyController(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx=0;
        dy=0;
        moveBehavior = new MoveBehavior();
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
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
        //move behavior
        if(!isGrounded){
            dx=0;
        }
        else{
            if(gameRect.getX()<=100){
                dx=3;
            }else if(gameRect.getX()>=300){
                dx=-3;
            }
        }

        gameRect.move(dx,dy);

        System.out.println(""+gameRect.getX());
    }


}
