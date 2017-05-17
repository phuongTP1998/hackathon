package physicsdemo.cows;

import physicsdemo.*;
import physicsdemo.Collider;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;
import physicsdemo.enemies.EnemyBullet;
import physicsdemo.enemies.EnemyController;
import physicsdemo.gameScenes.Level1Scene;
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
public class Cow extends GameObject implements Collider {

    private int dx;
    private int dy;
    private boolean isGrounded;
    private int playerHP = 10;
    private Animation animation;
    private int damage = 1;
    private ArrayList<Milk> milks;
    boolean moveLeft;
    boolean isShootable = true;
    int countDownForShoot = 10;
    protected boolean levelUp =false;

    public Cow(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx = 0;
        dy = 0;
        milks = new ArrayList<>();
        // mặc định animation lúc đầu
        ArrayList<Image> images = new ArrayList<Image>();
        {
            images.add(Utils.loadImage("res/Minh/run-forward-1.png"));
            images.add(Utils.loadImage("res/Minh/run-forward-2.png"));
            images.add(Utils.loadImage("res/Minh/run-forward-3.png"));
            images.add(Utils.loadImage("res/Minh/run-forward-4.png"));
        }
        animation = new Animation(images);
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);
    }

    public void setMilks(ArrayList<Milk> milks) {
        this.milks = milks;
    }

    public boolean isLevelUp() {
        return levelUp;
    }

    public void setLevelUp(boolean levelUp) {
        this.levelUp = levelUp;
    }

    public int getPlayerHP() {
        return playerHP;
    }

    public int getDamage() {
        return damage;
    }

    public void setPlayerHP(int playerHP) {
        this.playerHP = playerHP;
    }

    public GameRect getGameRect() {
        return gameRect;
    }

    public void getHit(int damage) {
        gameRect.setDead(true);
    }


    @Override
    public void draw(Graphics graphics) {
        animation.draw(graphics, gameRect);
    }

    @Override
    public void update() {
        dx = 0;
        dy += Physics2D.GRAVITY;
        isGrounded = false;

        if (InputManager.getInstance().isRight()) {
            moveLeft = false;
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
            moveLeft = true;
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
        GameObject gameObjectCenterDown = GameObject.objectAt(gameRect.getCenterX(), gameRect.getBottom() + dy);
        {
            if (gameObjectCenterDown != null && gameObjectCenterDown instanceof Ground) {
                dy = 0;
                GameRect groundRect = gameObjectCenterDown.getGameRect();
                isGrounded = true;
            }
        }

        GameObject gameObjectRightBottom = GameObject.objectAt(gameRect.getRight() + dx, gameRect.getBottom());
        if (gameObjectRightBottom != null && gameObjectRightBottom instanceof Ground) {
            dx = 0;
        }

        GameObject gameObjectRightTop = GameObject.objectAt(gameRect.getRight() + dx, gameRect.getY());
        if (gameObjectRightTop != null && gameObjectRightTop instanceof Ground) {
            dx = 0;
        }

        GameObject gameObjectLeftTop = GameObject.objectAt(gameRect.getX() + dx, gameRect.getY());
        if (gameObjectLeftTop != null && gameObjectLeftTop instanceof Ground) {
            dx = 0;
        }

        GameObject gameObjectLeftBottom = GameObject.objectAt(gameRect.getX() + dx, gameRect.getBottom());
        if (gameObjectLeftBottom != null && gameObjectLeftBottom instanceof Ground) {
            dx = 0;
        }

        GameObject gameObjectUpCenter = GameObject.objectAt(gameRect.getCenterX(), gameRect.getY() + dy);
        if (gameObjectUpCenter != null && gameObjectUpCenter instanceof Ground) {
            dy = 0;
        }

        // chỉnh camera stop 2 đầu Map
        if (gameRect.getX() > 500) {
            Camera.instanse.x += dx;
        }

        if (InputManager.getInstance().isUp() && isGrounded) {
            dy = -30;
        }
    if(!levelUp) {
        if (InputManager.getInstance().isSpace()) {
            if (isShootable) {
                isShootable = false;
                Milk milk;
                if (moveLeft) {
                    milk = new Milk(this.gameRect, new SpriteRenderer("res/bullet-left.png"));
                    milk.setMoveLeft(true);
                } else {
                    milk = new Milk(this.gameRect, new SpriteRenderer("res/bullet-right.png"));
                    milk.setMoveLeft(false);
                }
            } else {
                countDownForShoot--;
                if (countDownForShoot == 0) {
                    countDownForShoot = 10;
                    isShootable = true;
                }
            }
        }
    }
        gameRect.move(dx, dy);
//        if(playerHP<=0){
//            GameWindow.instance.setCurrentScene(new WinScene());
//            GameObject.removeAll();
//            ControllerManager.instance.setClear(true);
//        }
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof EnemyBullet) {
            ((EnemyBullet) other).getHit(damage);
            playerHP = playerHP - 1;
        }
        if (other instanceof EnemyController) {
            ((EnemyController) other).getHit(damage);
            playerHP = playerHP - 1;
        }
        if(other instanceof LevelUp){
            ((LevelUp) other ).getHit(damage);
            System.out.println(" Level Up");
            setLevelUp(true);
            setPlayerHP(30);
        }

    }
}