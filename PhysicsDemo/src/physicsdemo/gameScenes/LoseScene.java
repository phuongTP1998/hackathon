package physicsdemo.gameScenes;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.GameWindow;
import physicsdemo.controller.BackGround;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;
import physicsdemo.utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 5/14/2017.
 */
public class LoseScene implements GameScenes {
    private BackGround background_1, background_2;
    public LoseScene(){
        background_1= new BackGround(0,0,1000,700, Utils.loadImage("res/game-background1.jpg"));
        background_2= new BackGround(1000,0,1000,700, Utils.loadImage("res/game-background2.jpg"));
        GameWindow.instance.clip.close();
        GameWindow.instance.clip = Utils.playSound("res/music/loseSound.wav", false);
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            GameWindow.instance.clip.close();
            GameWindow.instance.setCurrentScene(new Level1Scene());
            ControllerManager.instance.setClear(false);
            CollisionManager.instance.setClear(false);
            GameObject.setClear(false);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        background_1.draw(graphics);
        background_2.draw(graphics);
    }

    @Override
    public void update() {
//        background_1.update();
//        background_2.update();
    }
}
