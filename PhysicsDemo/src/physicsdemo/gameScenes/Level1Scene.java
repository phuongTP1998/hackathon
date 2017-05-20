package physicsdemo.gameScenes;

import physicsdemo.GameRect;

import physicsdemo.GameWindow;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.ControllerManager;
import physicsdemo.controller.LeftRightBehavior;
import physicsdemo.cows.Cow;
import physicsdemo.cows.Milk;
import physicsdemo.enemies.EnemyController;
import physicsdemo.enemies.SecondEnemyController;
import physicsdemo.obstacles.Ground;
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class Level1Scene implements GameScenes {
    private Image image, image1;
    private Animation animation;

    public static Level1Scene instance;
    public ArrayList<Milk> milks = new ArrayList<>();
    public Cow cow = new Cow(new GameRect(50, 10, 100, 100), new SpriteRenderer("res/Minh/run-right-1.png"));

    public Level1Scene() {
        System.out.println("Scene 1");
        instance = this;
        cow.setMilks(milks);
        for (int i = 600; i <= 900; i += 300) {
            EnemyController enemyController = new EnemyController(new GameRect(i, 10, 50, 50), new SpriteRenderer("res/Minh/run-left-3.png"));
            ControllerManager.instance.add(enemyController);
        }
        SecondEnemyController secondEnemyController = new SecondEnemyController(new GameRect(900, 200, 50, 50), new SpriteRenderer("res/Bat/bat-left-1.png"));

        ControllerManager.instance.add(secondEnemyController);

        new Ground(new GameRect(0, 600, 770, 100), new SpriteRenderer("res/ground/ground0.png"), null);
        new Ground(new GameRect(900, 600, 400, 100), new SpriteRenderer("res/ground/ground01.png"), null);
        new Ground(new GameRect(1120, 500, 200, 200), new SpriteRenderer("res/ground/ground111.png"), null);
        new Ground(new GameRect(1500, 400, 150, 50), new SpriteRenderer("res/ground/ground3.png"), new LeftRightBehavior());
        new Ground(new GameRect(1820, 600, 1400, 100), new SpriteRenderer("res/ground/ground10.png"), null);
        new Ground(new GameRect(2100, 520, 230, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(2550, 522, 230, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(3000, 520, 226, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(3400, 450, 150, 50), new SpriteRenderer("res/ground/ground3.png"), null);
        new Ground(new GameRect(3600, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(3800, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4100, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4300, 250, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4500, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4700, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(5000, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(5400, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(5800, 500, 400, 200), new SpriteRenderer("res/ground/ground111.png"), null);
        image = Utils.loadImage("res/background/background1.png");
        GameWindow.instance.clip = Utils.playSound("res/music/level1-1.wav", false);
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
