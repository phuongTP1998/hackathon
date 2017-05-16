package physicsdemo.controller;

import physicsdemo.GameRect;

/**
 * Created by Quang Minh on 16/05/2017.
 */
public class HorzMoveBehavior extends MoveBehavior{
    @Override
    public void move(GameRect gameRect) {
        gameRect.move(0,6);
    }
}
