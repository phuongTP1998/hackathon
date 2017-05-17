package physicsdemo.controller;

import physicsdemo.GameRect;
import physicsdemo.physics.Physics2D;

/**
 * Created by Quang Minh on 14/05/2017.
 */
public class FlyBehavior extends MoveBehavior {
    public void move(GameRect gameRect) {
        if (gameRect.getX() <= 900) {
            gameRect.move(2, 0);
        } else if (gameRect.getX() >= 1200) {
            gameRect.move(-2, 0);
        }
    }
}
