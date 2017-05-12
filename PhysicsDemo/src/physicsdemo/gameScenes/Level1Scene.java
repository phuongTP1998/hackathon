package physicsdemo.gameScenes;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.cows.Cow;
import physicsdemo.obstacles.Ground;
import physicsdemo.utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class Level1Scene implements GameScenes {

    public Level1Scene(){
        new Cow(new GameRect(10, 10, 100, 100), new SpriteRenderer("res/Minh/run-right-1.png"));
        new Ground(new GameRect(0, 600, 800, 100), new SpriteRenderer("res/1.png"));
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
