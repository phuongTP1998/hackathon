package physicsdemo.cows;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.InputManger;
import physicsdemo.SpriteRenderer;
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

        if (InputManger.getInstance().isRight()) {
            dx += 5;
        }

        if (InputManger.getInstance().isLeft()) {
            dx -= 5;
        }

        GameObject gameObject = GameObject.objectAt(gameRect.getX(), gameRect.getBottom() + dy);
        if(gameObject != null && gameObject instanceof Ground) {
            dy = 0;

            GameRect groundRect = gameObject.getGameRect();

            while(gameRect.getBottom() + 1 < groundRect.getY()) {
                gameRect.move(0, 1);
            }

            isGrounded = true;
        }

        if (InputManger.getInstance().isUp() && isGrounded) {
            dy = -30;
        }

        gameRect.move(dx, dy);
    }
}