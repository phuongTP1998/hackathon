package physicsdemo.cows;

import physicsdemo.*;
import physicsdemo.gameScenes.GameScenes;
import physicsdemo.obstacles.Ground;
import physicsdemo.physics.Physics2D;

import java.awt.*;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class Cow extends GameObject {

    private int dx;
    private int dy;

    private boolean isGrounded;

    public Cow(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx = 0;
        dy = 0;
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    @Override
    public void update() {
        dx = 0;
        dy += Physics2D.GRAVITY;
        isGrounded = false;

        if (InputManager.getInstance().isRight()) {
            dx += 5;
        }

        if (InputManager.getInstance().isLeft()) {
            dx -= 5;
        }

        GameObject gameObject = GameObject.objectAt(gameRect.getX(), gameRect.getBottom() + dy);

        if(gameObject != null && gameObject instanceof Ground) {
            dy = 0;
            GameRect groundRect = gameObject.getGameRect();

            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded=true;
        }

        gameObject = GameObject.objectAt(gameRect.getX()+gameRect.getWidth()/2, gameRect.getBottom() + dy);
        if(gameObject != null && gameObject instanceof Ground) {
            dy = 0;
            GameRect groundRect = gameObject.getGameRect();

            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded=true;
        }


        gameObject = GameObject.objectAt(gameRect.getRight(), gameRect.getBottom() + dy);

        if(gameObject != null && gameObject instanceof Ground) {
            dy = 0;
            GameRect groundRect = gameObject.getGameRect();

            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded=true;
        }

        gameObject = GameObject.objectAt(gameRect.getRight(), gameRect.getBottom() + dy);

        if(gameObject != null && gameObject instanceof Ground) {
            dy = 0;
            GameRect groundRect = gameObject.getGameRect();

            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded=true;
        }


        GameObject gameObject1=GameObject.objectAt(gameRect.getRight()+dx, gameRect.getBottom());
        if(gameObject1 !=null && gameObject1 instanceof Ground){
            dx=0;
            System.out.println(" 1");
            isGrounded=true;
        }

        GameObject gameObject2=GameObject.objectAt(gameRect.getRight()+dx,gameRect.getY());
        if(gameObject2 !=null && gameObject2 instanceof Ground){
            dx=0;
            System.out.println(" 2");
            GameRect groundRect = gameObject.getGameRect();
            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }
            isGrounded=true;
        }

        GameObject gameObject4=GameObject.objectAt(gameRect.getX() +dx,gameRect.getY());
        if(gameObject4 !=null && gameObject4 instanceof Ground){
            dx=0;
            System.out.println(" 4");
            isGrounded=true;
        }


        if (InputManager.getInstance().isUp() && isGrounded) {
            dy = -30;
        }

        Camera.instanse.x += dx;
        gameRect.move(dx, dy);
    }
}