package physicsdemo.obstacles;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.MoveBehavior;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class Ground extends GameObject {
    private MoveBehavior moveBehavior;

    public Ground(GameRect gameRect, SpriteRenderer spriteRenderer, MoveBehavior moveBehavior) {
        super(gameRect, spriteRenderer);
        this.moveBehavior = moveBehavior;
    }

    @Override
    public void update() {
        if(moveBehavior!=null){
            moveBehavior.move(gameRect);
        }
    }
}
