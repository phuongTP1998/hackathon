package physicsdemo.cows;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.gameScenes.Level1Scene;
import physicsdemo.physics.Physics2D;

import java.awt.*;

/**
 * Created by zTitiK on 15-May-17.
 */
public class Milk extends GameObject {
    private int dx, dy;
    private boolean moveLeft;

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    public Milk(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        this.gameRect = new GameRect(gameRect.getRight(),
                gameRect.getBottom() - gameRect.getHeight() / 2,
                spriteRenderer.getImage().getWidth(null),
                spriteRenderer.getImage().getHeight(null));
        Level1Scene.milks.add(this);
    }
    int countDown = 3;

    @Override
    public void update() {
        if (moveLeft) {
            dx = -30;
        } else {
            dx = 30;
        }
        if (countDown == 0) {
//        if (maxHeight)
            dy += Physics2D.GRAVITY;
//        else {
//            dy -= 1;
//            if (gameRect.getY()<=cowNow.getY() - 20)
//                maxHeight = true;
//        }
            gameRect.move(dx, dy);
            countDown = 3;
        } else {
            countDown--;
        }
    }
}
