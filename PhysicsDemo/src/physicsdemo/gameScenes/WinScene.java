//package physicsdemo.gameScenes;
//
//import physicsdemo.GameRect;
//import physicsdemo.controller.BackGround;
//import physicsdemo.utils.Utils;
//
//import javax.sound.sampled.Clip;
//import java.awt.*;
//import java.awt.event.KeyEvent;
//
///**
// * Created by trongphuong1011 on 5/14/2017.
// */
//public class WinScene implements GameScenes {
//    private BackGround background_1, background_2;
//    private Clip clip;
//    public WinScene(){
//        background_1= new BackGround(0,0,1000,700, Utils.loadImage("res/game-background1.png"));
//        background_2= new BackGround(1000,0,1000,700, Utils.loadImage("res/game-background2.png"));
//    }
//    @Override
//    public void keyPressed(KeyEvent e) {
//
//    }
//
//    @Override
//    public void keyReleased(KeyEvent e) {
//
//    }
//
//    @Override
//    public void draw(Graphics graphics) {
//        background_1.draw(graphics);
//        background_2.draw(graphics);
//    }
//
//    @Override
//    public void update() {
//        background_1.update();
//        background_2.update();
//    }
//}
