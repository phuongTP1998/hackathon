package physicsdemo.gameScenes;

import physicsdemo.GameObject;
import physicsdemo.GameRect;

import physicsdemo.SpriteRenderer;
import physicsdemo.controller.BackGround;
import physicsdemo.cows.Cow;
import physicsdemo.enemies.EnemyController;
import physicsdemo.enemies.SecondEnemyController;
import physicsdemo.obstacles.Ground;
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class Level1Scene implements GameScenes {
private Image image;
private Clip clip;
private Animation animation;
    public Level1Scene(){
        new Cow(new GameRect(50, 10, 100, 100), new SpriteRenderer("res/Minh/run-right-1.png"));
        for(int i=500;i<900;i+=400){
            new EnemyController(new GameRect(500,10,50,50),new SpriteRenderer("res/Minh/run-left-3.png"));
        }
        new SecondEnemyController(new GameRect(900,10,50,50),new SpriteRenderer("res/Minh/run-left-3.png"));
        new Ground(new GameRect(0, 600, 800, 100), new SpriteRenderer("res/ground/ground0.png"));
        new Ground(new GameRect(900,600,200,100),new SpriteRenderer("res/ground/ground4.png"));
        new Ground(new GameRect(1200,600,200,100),new SpriteRenderer("res/ground/ground4.png"));
        new Ground(new GameRect(1500,500,200,100),new SpriteRenderer("res/ground/ground4.png"));
        new Ground(new GameRect(1700,400,200,100),new SpriteRenderer("res/ground/ground4.png"));
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
