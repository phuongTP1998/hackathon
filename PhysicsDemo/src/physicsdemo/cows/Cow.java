package physicsdemo.cows;

import physicsdemo.*;
import physicsdemo.gameScenes.Level1Scene;
import physicsdemo.gameScenes.MenuScene;
import physicsdemo.gameScenes.WinScene;
import physicsdemo.obstacles.Ground;
import physicsdemo.physics.Physics2D;
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;
import physicsdemo.view.Camera;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class Cow extends GameObject {

    private int dx;
    private int dy;
    private boolean isGrounded;
    private Animation animation;
    private boolean accept;
    public Cow(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx = 0;
        dy = 0;

        // mặc định animation lúc đầu
        ArrayList<Image> images = new ArrayList<Image>();
        {
            images.add(Utils.loadImage("res/Minh/run-forward-1.png"));
            images.add(Utils.loadImage("res/Minh/run-forward-2.png"));
            images.add(Utils.loadImage("res/Minh/run-forward-3.png"));
            images.add(Utils.loadImage("res/Minh/run-forward-4.png"));
        }
        animation = new Animation(images);
    }

    @Override
    public void draw(Graphics graphics) {
        animation.draw(graphics,gameRect);
    }

    @Override
    public void update() {
        dx = 0;
        dy += Physics2D.GRAVITY;
        isGrounded = false;

        if (InputManager.getInstance().isRight()) {
            dx += 5;
            ArrayList<Image> images = new ArrayList<Image>();
            {
                images.add(Utils.loadImage("res/Minh/run-right-1.png"));
                images.add(Utils.loadImage("res/Minh/run-right-2.png"));
                images.add(Utils.loadImage("res/Minh/run-right-3.png"));
                images.add(Utils.loadImage("res/Minh/run-right-4.png"));
            }
            animation = new Animation(images);
        }

        if (InputManager.getInstance().isLeft()) {
            dx -= 5;
            ArrayList<Image> images = new ArrayList<Image>();
            {
                images.add(Utils.loadImage("res/Minh/run-left-1.png"));
                images.add(Utils.loadImage("res/Minh/run-left-2.png"));
                images.add(Utils.loadImage("res/Minh/run-left-3.png"));
                images.add(Utils.loadImage("res/Minh/run-left-4.png"));
            }
            animation = new Animation(images);
        }

// tạo que cho chú Bò
        GameObject gameObjectCenterDown = GameObject.objectAt(gameRect.getCenterX(),gameRect.getBottom()+dy);
        {
            if(gameObjectCenterDown != null && gameObjectCenterDown instanceof Ground) {
                dy = 0;
                GameRect groundRect = gameObjectCenterDown.getGameRect();
                System.out.println(" Center Down");
                while(gameRect.getBottom() + 1 < groundRect.getY()) {
                    gameRect.move(0, 1);
                }
                isGrounded=true;
            }
        }


        GameObject gameObjectRightBottom=GameObject.objectAt(gameRect.getRight()+dx, gameRect.getBottom());
        if(gameObjectRightBottom !=null && gameObjectRightBottom instanceof Ground){
            dx=0;
            System.out.println(" Right Bottom");
        }

        GameObject gameObjectRightTop=GameObject.objectAt(gameRect.getRight()+dx,gameRect.getY());
        if(gameObjectRightTop !=null && gameObjectRightTop instanceof Ground){
            dx=0;
            System.out.println(" Right Top");
        }

        GameObject gameObjectLeftTop=GameObject.objectAt(gameRect.getX()+dx,gameRect.getY());
        if(gameObjectLeftTop !=null && gameObjectLeftTop instanceof Ground){
            dx=0;
            System.out.println(" Left Top");
        }

        GameObject gameObjectLeftBottom=GameObject.objectAt(gameRect.getX()+dx,gameRect.getBottom());
        if(gameObjectLeftBottom !=null && gameObjectLeftBottom instanceof Ground){
            dx=0;
            System.out.println(" Left Bottom");
        }

        GameObject gameObjectUpCenter=GameObject.objectAt(gameRect.getCenterX(),gameRect.getY()+dy);
        if(gameObjectUpCenter !=null && gameObjectUpCenter instanceof Ground){
            dy=0;
            System.out.println(" Center Up");
        }

        // chỉnh camera stop 2 đầu Map
    if(gameRect.getX()>500 && gameRect.getX()<1400) {
        Camera.instanse.x += dx;
    }
    if(gameRect.getX()==1500){
        GameWindow.instance.setCurrentScene(new WinScene());
    }
        if (InputManager.getInstance().isUp() && isGrounded) {
            dy = -30;
        }

        gameRect.move(dx, dy);
    }
}