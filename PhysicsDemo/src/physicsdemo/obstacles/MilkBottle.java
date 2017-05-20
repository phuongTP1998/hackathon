package physicsdemo.obstacles;

import physicsdemo.Collider;
import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.CollisionManager;
import physicsdemo.cows.Cow;
import physicsdemo.cows.Milk;

/**
 * Created by Quang Minh on 20/05/2017.
 */
public class MilkBottle extends GameObject implements Collider {

    public MilkBottle(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        CollisionManager.instance.add(this);
        CollisionManager.instance.add(this);
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof Cow) {
            ((Cow) other).win();
        }
    }
}
