package physicsdemo.gameScenes;

import physicsdemo.GameRect;

import physicsdemo.GameWindow;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.ControllerManager;
import physicsdemo.cows.Cow;
import physicsdemo.cows.LevelUp;
import physicsdemo.cows.Milk;
import physicsdemo.enemies.EnemyController;
import physicsdemo.obstacles.Ground;
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class Level1Scene implements GameScenes {
    private Image image;
    private Clip clip;
    private Animation animation;
    public static ArrayList<Milk> milks = new ArrayList<>();

    public Level1Scene() {
        Cow cow = new Cow(new GameRect(50, 10, 100, 100), new SpriteRenderer("res/Minh/run-right-1.png"));
        cow.setMilks(milks);
        for (int i = 100; i <= 900; i += 100) {
            EnemyController enemyController = new EnemyController(new GameRect(i, 10, 50, 50), new SpriteRenderer("res/Minh/run-left-3.png"));
            ControllerManager.instance.add(enemyController);
        }

       LevelUp levelUp= new LevelUp(new GameRect(850,400,100,100),new SpriteRenderer("res/Object/Crate.png"));
        new Ground(new GameRect(0, 600, 800, 100), new SpriteRenderer("res/ground/ground0.png"));
        new Ground(new GameRect(900, 600, 200, 100), new SpriteRenderer("res/ground/ground4.png"));
        new Ground(new GameRect(1200, 600, 200, 100), new SpriteRenderer("res/ground/ground4.png"));
        new Ground(new GameRect(1500, 500, 200, 100), new SpriteRenderer("res/ground/ground4.png"));
        new Ground(new GameRect(1700, 400, 200, 100), new SpriteRenderer("res/ground/ground4.png"));
        image = Utils.loadImage("res/background/background1.png");
        clip = Utils.playSound("res/music/level1-1.wav", false);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image, 0, 0, 1000, 800, null);
    }

    @Override
    public void update() {
    }
}
