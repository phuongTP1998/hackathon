package physicsdemo.controller;

import physicsdemo.GameRect;

/**
 * Created by Quang Minh on 17/05/2017.
 */
public class UpDownBehavior extends MoveBehavior {
    int var = 1;

    public void move(GameRect gameRect) {
        System.out.println(gameRect.getY());
        if (gameRect.getY() >= 700) {
            var = -var;
        } else if (gameRect.getY() <= 200) {
            var = -var;
        }
        gameRect.move(0, var);
    }
}
