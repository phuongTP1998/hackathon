package physicsdemo.enemies;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.view.SpriteRenderer;

import java.awt.*;

/**
 * Created by Quang Minh on 14/05/2017.
 */
public class EnemyBullet extends GameObject{


    public EnemyBullet(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    @Override
    public void update() {
        gameRect.move(-6,0);
    }
}
