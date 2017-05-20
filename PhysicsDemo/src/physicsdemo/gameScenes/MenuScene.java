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
    private Image image, logo, text, cow;

    public MenuScene() {
        background_1=new BackGround(0,0,1000,700,Utils.loadImage("res/background/background1.png"));
        background_2=new BackGround(1000,0,1000,700,Utils.loadImage("res/background/background2.png"));
        cow= Utils.loadImage("res/menu/menu/COW004.png");
      logo=Utils.loadImage("res/menu/menu/Logo.png");
      text=Utils.loadImage("res/menu/menu/text.png");

        GameWindow.instance.clip = Utils.playSound("res/music/menu.wav", true);
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
        background_1.draw(graphics);
        background_2.draw(graphics);
        graphics.drawImage(logo,250,100,400,400,null);
        graphics.drawImage(text,150,500,700,150,null);
        graphics.drawImage(cow,620,100,350,300,null);
    }

    @Override
    public void update() {
        background_1.update();
        background_2.update();
    }
}
