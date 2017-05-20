package physicsdemo.controller;

import physicsdemo.GameRect;

/**
 * Created by Quang Minh on 17/05/2017.
 */
public class LeftRightBehavior extends MoveBehavior {
    public int deviation = 3;

    public int getDeviation() {
        return deviation;
    }

    public void move(GameRect gameRect) {
        if (gameRect.getX() >= 1550) {
            deviation = -deviation;
        } else if (gameRect.getX() <= 1300) {
            deviation = -deviation;
        }
        gameRect.move(deviation, 0);
    }
}
