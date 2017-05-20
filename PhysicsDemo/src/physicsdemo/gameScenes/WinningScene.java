package physicsdemo.gameScenes;

import physicsdemo.GameObject;
import physicsdemo.GameWindow;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;
import physicsdemo.utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Quang Minh on 20/05/2017.
 */
public class WinningScene implements GameScenes{
    private Image image;
    private Clip clip;

    public WinningScene() {
        image= Utils.loadImage("res/SCREEN/win-screen.png");
        GameWindow.instance.clip.close();
        GameWindow.instance.clip = Utils.playSound("res/music/winsound.wav", true);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            GameWindow.instance.clip.close();

            ControllerManager.instance.setClear(false);
            CollisionManager.instance.setClear(false);
            GameObject.setClear(false);
            MenuScene menuScene = new MenuScene();
            GameWindow.instance.setCurrentScene(menuScene);
        }
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image,0,0,1000,700,null);
    }

    @Override
    public void update() {

    }
}
