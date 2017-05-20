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

    //    public static Level1Scene instance;
    public ArrayList<Milk> milks = new ArrayList<>();
    public Cow cow = new Cow(new GameRect(50, 10, 100, 100), new SpriteRenderer("res/Minh/run-right-1.png"));

    public Level1Scene() {
        System.out.println("Scene 1");
//        instance = this;
        cow.setMilks(milks);
        EnemyController enemyController = new EnemyController(new GameRect(900, 10, 50, 50), new SpriteRenderer("res/Minh/run-left-3.png"));
        enemyController.setShootEnable(false);
        ControllerManager.instance.add(enemyController);
        for (int i = 3200; i <= 4000; i += 800) {
            SecondEnemyController secondEnemyController = new SecondEnemyController(new GameRect(i, 150, 50, 50), new SpriteRenderer("res/Bat/bat-left-1.png"));
            ControllerManager.instance.add(secondEnemyController);
        }

        new Ground(new GameRect(0, 600, 770, 100), new SpriteRenderer("res/ground/ground0.png"), null);
        new Ground(new GameRect(900, 600, 400, 100), new SpriteRenderer("res/ground/ground01.png"), null);
        new Ground(new GameRect(1120, 500, 200, 200), new SpriteRenderer("res/ground/ground111.png"), null);
        new Ground(new GameRect(1500, 400, 150, 50), new SpriteRenderer("res/ground/ground3.png"), new LeftRightBehavior());
        new Ground(new GameRect(1820, 600, 900, 100), new SpriteRenderer("res/ground/ground10.png"), null);
        new Ground(new GameRect(2000, 520, 140, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(2300, 522, 140, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(2580, 520, 140, 100), new SpriteRenderer("res/ground/ground11.png"), null);
        new Ground(new GameRect(2800, 450, 150, 50), new SpriteRenderer("res/ground/ground3.png"), null);
        new Ground(new GameRect(3000, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(3200, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(3400, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(3600, 250, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(3800, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4000, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4200, 350, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4400, 450, 100, 50), new SpriteRenderer("res/ground/ground001.png"), null);
        new Ground(new GameRect(4600, 500, 400, 200), new SpriteRenderer("res/ground/ground111.png"), null);
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
