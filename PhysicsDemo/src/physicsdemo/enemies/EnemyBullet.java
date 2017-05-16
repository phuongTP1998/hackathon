package physicsdemo.enemies;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.MoveBehavior;

import java.awt.*;

/**
 * Created by Quang Minh on 14/05/2017.
 */
public class EnemyBullet extends GameObject{

    private MoveBehavior moveBehavior;
    public EnemyBullet(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        moveBehavior = new MoveBehavior();
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    public void setMoveBehavior(MoveBehavior moveBehavior) {
        this.moveBehavior = moveBehavior;
    }

    @Override
    public void update() {
        moveBehavior.move(gameRect);
    }
}
