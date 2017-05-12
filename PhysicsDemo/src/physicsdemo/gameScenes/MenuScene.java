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
    private Clip clip;

    public MenuScene(){
        background_1= new BackGround(0,0,1000,700, Utils.loadImage("res/background/background1.png"));
        background_2= new BackGround(1000,0,1000,700, Utils.loadImage("res/background/background2.png"));
        clip=Utils.playSound("res/music/level1-1.wav",false);
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode()== KeyEvent.VK_ENTER) {
            clip.close();
        GameWindow.instance.setCurrentScene(new Level1Scene());
        System.out.println(" Helo");
        }
    }

    @Override
    public void draw(Graphics graphics) {
        background_1.draw(graphics);
        background_2.draw(graphics);
    }

    @Override
    public void update() {
        background_1.update();
        background_2.update();
    }
}
