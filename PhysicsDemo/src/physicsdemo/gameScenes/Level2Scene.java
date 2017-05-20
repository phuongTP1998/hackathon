package physicsdemo.gameScenes;

import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.cows.Cow;
import physicsdemo.obstacles.Ground;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 5/19/2017.
 */
public class Level2Scene implements GameScenes {
    public Level2Scene(){
        new Ground(new GameRect(0, 650, 1000, 50), new SpriteRenderer("res/ground/layer-5.png"), null);
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void draw(Graphics graphics) {

    }

    @Override
    public void update() {

    }
}
