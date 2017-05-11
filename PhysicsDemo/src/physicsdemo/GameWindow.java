package physicsdemo;

import physicsdemo.cows.Cow;
import physicsdemo.obstacles.Ground;
import physicsdemo.utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by trongphuong1011 on 4/8/2017.
 */
public class GameWindow extends Frame {

    BufferedImage backBufferImage;
    Graphics backbufferGraphics;

    InputManger inputManger;

    public GameWindow() {

        setVisible(true);
        setSize(400, 600);
        inputManger = new InputManger();

        new Cow(new GameRect(10, 10, 100, 100), new SpriteRenderer("res/Minh/run-right-1.png"));
        new Ground(new GameRect(10, 500, 300, 300), new SpriteRenderer("res/Minh/run-right-1.png"));

        backBufferImage = new BufferedImage(400, 600, BufferedImage.TYPE_INT_ARGB);
        backbufferGraphics = backBufferImage.getGraphics();

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
                //dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });


        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                inputManger.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                inputManger.keyReleased(e);
            }
        });

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(17);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    GameObject.updateAll();
                    repaint();
                }
            }
        });
        thread.start();
    }

    Image backgroundImage = Utils.loadImage("res/background/background1.png");

    @Override
    public void update(Graphics graphics) {
        backbufferGraphics.drawImage(backgroundImage, 0, 0, null);
        GameObject.drawAll(backbufferGraphics);
        graphics.drawImage(backBufferImage, 0, 0, null);
    }
}
