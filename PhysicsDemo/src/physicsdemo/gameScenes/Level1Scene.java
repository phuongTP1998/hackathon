package physicsdemo.gameScenes;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.BackGround;
import physicsdemo.cows.Cow;
import physicsdemo.obstacles.Ground;
import physicsdemo.utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class Level1Scene implements GameScenes {
private Image image;
private Clip clip;
    public Level1Scene(){
        new Cow(new GameRect(500, 10, 100, 100), new SpriteRenderer("res/Minh/run-right-1.png"));
        new Ground(new GameRect(0, 600, 800, 100), new SpriteRenderer("res/1.png"));
        new Ground(new GameRect(400,450,800,100),new SpriteRenderer("res/1.png"));
        new Ground(new GameRect( 50,470,50,50),new SpriteRenderer("res/Object/Crate.png"));

        image= Utils.loadImage("res/background/background1.png");
        clip=Utils.playSound("res/music/level1-1.wav",false);
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image,0,0,1000,800,null);
    }

    @Override
    public void update() {

    }
}
