package physicsdemo.controller;

import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;

import java.awt.*;

/**
 * Created by trongphuong1011 on 5/12/2017.
 */
public class Controller {
    protected GameRect gameRect;
    protected SpriteRenderer spriteRenderer;

    public Controller() {
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public Controller(GameRect gameRect, SpriteRenderer spriteRenderer) {
        this.gameRect = gameRect;
        this.spriteRenderer = spriteRenderer;
    }

    public void draw(Graphics graphics) {
        spriteRenderer.render(graphics, gameRect);
    }

    public void update() {

    }
}
