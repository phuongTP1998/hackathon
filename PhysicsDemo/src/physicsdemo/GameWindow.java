package physicsdemo;

import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;
import physicsdemo.cows.Cow;
import physicsdemo.gameScenes.GameScenes;
import physicsdemo.gameScenes.Level2Scene;
import physicsdemo.gameScenes.MenuScene;
import physicsdemo.obstacles.Ground;
import physicsdemo.utils.Utils;

import javax.sound.sampled.Clip;
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

    InputManager inputManager;
    GameScenes currentScene;
    public static GameWindow instance;
    public Clip clip;
    public void setCurrentScene(GameScenes currentScene) {
        this.currentScene = currentScene;
    }

    public GameWindow() {

        setVisible(true);
        setSize(1000, 700);
        inputManager = new InputManager();
        instance = this;
        currentScene = new MenuScene();

        backBufferImage = new BufferedImage(1000, 700, BufferedImage.TYPE_INT_ARGB);
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
                currentScene.keyPressed(e);
                inputManager.keyPressed(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                currentScene.keyReleased(e);
                inputManager.keyReleased(e);
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
                    currentScene.update();
                    CollisionManager.instance.update();
                    ControllerManager.instance.update();
                    repaint();
                }
            }
        });
        thread.start();
    }

    @Override
    public void update(Graphics graphics) {
        currentScene.draw(backbufferGraphics);
        ControllerManager.instance.draw(backbufferGraphics);
        GameObject.drawAll(backbufferGraphics);
        graphics.drawImage(backBufferImage, 0, 0, null);
    }
}
