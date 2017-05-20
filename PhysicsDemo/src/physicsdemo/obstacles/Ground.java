package physicsdemo.obstacles;

import physicsdemo.Collider;
import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.MoveBehavior;
import physicsdemo.cows.Milk;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class Ground extends GameObject implements Collider{
    private MoveBehavior moveBehavior;

    public MoveBehavior getMoveBehavior() {
        return moveBehavior;
    }

    public Ground(GameRect gameRect, SpriteRenderer spriteRenderer, MoveBehavior moveBehavior) {
        super(gameRect, spriteRenderer);
        this.moveBehavior = moveBehavior;
        CollisionManager.instance.add(this);
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof Milk) {
            ((Milk) other).getHit(0);
        }
    }

    @Override
    public void update() {
        if(moveBehavior!=null){
            moveBehavior.move(gameRect);
        }
    }
}
