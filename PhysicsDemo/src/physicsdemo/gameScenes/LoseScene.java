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
    private Image image;
    public LoseScene(){
        System.out.println("LOSEEEEEEEEEEEEEEEEE");
        image= Utils.loadImage("res/SCREEN/lose-screen-03.png");
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
            
            ControllerManager.instance.setClear(false);
            CollisionManager.instance.setClear(false);
            GameObject.setClear(false);
            Level1Scene lvl1scene = new Level1Scene();
            GameWindow.instance.setCurrentScene(lvl1scene);
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
