package physicsdemo.enemies;

import physicsdemo.GameRect;
import physicsdemo.controller.MoveBehavior;
import physicsdemo.view.SpriteRenderer;

/**
 * Created by Quang Minh on 13/05/2017.
 */
public class SecondEnemyController extends EnemyController {

    public SecondEnemyController(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
    }

    @Override
    public void setMoveBehavior(MoveBehavior moveBehavior) {
        super.setMoveBehavior(moveBehavior);
    }

}
