package physicsdemo.controller;

import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;

import java.awt.*;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class BackGround extends Controller {
    public BackGround(int x, int y, int width, int height, Image image) {
        gameRect = new GameRect(x, y, width, height);
        spriteRenderer = new SpriteRenderer(image);
    }

    @Override
    public void update() {
        gameRect.move(-1, 0);
        if (gameRect.getX() <= -1000) {
            gameRect.setX(1000);
        }
    }
}
