package physicsdemo.gameScenes;

import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.ControllerManager;
import physicsdemo.cows.Cow;
import physicsdemo.enemies.EnemyController;
import physicsdemo.obstacles.Ground;
import physicsdemo.utils.Utils;
import physicsdemo.view.Camera;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 5/19/2017.
 */
public class Level2Scene implements GameScenes {
    private Image background;
    SpriteRenderer spriteRenderer = new SpriteRenderer("res/coww/cow-right-1.png");
    public Cow cow = new Cow(new GameRect(0, 200, spriteRenderer.getImage().getWidth(null), spriteRenderer.getImage().getHeight(null)), spriteRenderer );

    public Level2Scene(){
        background= Utils.loadImage("res/background/background1.png");
        EnemyController enemyController2 = new EnemyController(new GameRect(0, 10, 50, 50), new SpriteRenderer("res/Minh/run-left-3.png"));
        ControllerManager.instance.add(enemyController2);
        new Ground(new GameRect(-20, 500, 300, 200), new SpriteRenderer("res/ground/ground21.png"), null);
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(background,0,0,1000,700,null);
    }

    @Override
    public void update() {
    }
}
