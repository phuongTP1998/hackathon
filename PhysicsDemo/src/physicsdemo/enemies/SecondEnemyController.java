package physicsdemo.enemies;

import physicsdemo.Collider;
import physicsdemo.GameRect;
import physicsdemo.controller.FlyBehavior;
import physicsdemo.controller.HorzMoveBehavior;
import physicsdemo.controller.MoveBehavior;
import physicsdemo.SpriteRenderer;

/**
 * Created by Quang Minh on 13/05/2017.
 */
public class SecondEnemyController extends EnemyController implements Collider {
    private int cooldown = 200;

    public SecondEnemyController(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        this.setMoveBehavior(new FlyBehavior());


    }

    public void shooting() {
        EnemyBullet enemyBullet = new EnemyBullet(new GameRect(this.gameRect.getX(), this.gameRect.getY(), 30, 30),
                new SpriteRenderer("res/bomb.png"));
        enemyBullet.setMoveBehavior(new HorzMoveBehavior());
    }

    @Override
    public void setMoveBehavior(MoveBehavior moveBehavior) {
        super.setMoveBehavior(moveBehavior);
    }

    @Override
    public void update() {
        cooldown--;
        if(cooldown<=0){
            shooting();
            cooldown=200;
        }

        if (gameRect.getX() <= initPosX) {
            dx = 2;
        } else if (gameRect.getX() >= initPosX + 150) {
            dx = -2;
        }
        gameRect.move(dx,0);
    }

    @Override
    public void onCollide(Collider other) {
        super.onCollide(other);
    }
}
