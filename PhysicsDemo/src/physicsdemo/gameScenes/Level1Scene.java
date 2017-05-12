package physicsdemo.gameScenes;

import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * Created by trongphuong1011 on 5/11/2017.
 */
public class Level1Scene implements GameScenes {
    private Image image;
//    BufferedImage backBufferImage;
//    Graphics backbufferGraphics;
    public Level1Scene(){
//        backBufferImage = new BufferedImage(1000, 700, BufferedImage.TYPE_INT_ARGB);
//        backbufferGraphics = backBufferImage.getGraphics();
        image= Utils.loadImage("res/Minh/run-right-1.png");
    }
    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void draw(Graphics graphics) {
        graphics.drawImage(image,100,100,200,200,null);
    }

    @Override
    public void update() {
//        GameObject.drawAll(backbufferGraphics);
    }
}
