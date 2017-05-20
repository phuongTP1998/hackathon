package physicsdemo.gameScenes;

import javafx.scene.layout.Background;
import physicsdemo.GameWindow;
import physicsdemo.InputManager;
import physicsdemo.controller.BackGround;
import physicsdemo.utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class MenuScene implements GameScenes {
    private BackGround background_1, background_2;
    private Image image, logo, text;

    public MenuScene() {
      image= Utils.loadImage("res/menu/menu/3.jpg");
      logo=Utils.loadImage("res/menu/menu/Logo.png");
      text=Utils.loadImage("res/menu/menu/text.png");
      GameWindow.instance.clip = Utils.playSound("res/music/level1-1.wav", false);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            GameWindow.instance.clip.close();
            GameWindow.instance.setCurrentScene(new Level1Scene());
        }
    }

    @Override
    public void draw(Graphics graphics) {
       graphics.drawImage(image,0,0,1000,700,null);
        graphics.drawImage(logo,300,100,400,400,null);
        graphics.drawImage(text,150,500,700,150,null);
    }

    @Override
    public void update() {

    }
}
