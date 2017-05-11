package physicsdemo.gameScenes;

import physicsdemo.GameWindow;
import physicsdemo.InputManager;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class MenuScene implements GameScenes {

    public MenuScene(){

    }

    @Override
    public void draw(Graphics graphics) {

    }

    @Override
    public void update() {
        if(InputManager.getInstance().isSpace()){
            GameWindow.instance.setCurrentScene(new Level1Scene());
        }
    }
}
