package physicsdemo.cows;

import physicsdemo.*;
import physicsdemo.Collider;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;
import physicsdemo.controller.LeftRightBehavior;
import physicsdemo.enemies.EnemyBullet;
import physicsdemo.enemies.EnemyController;
import physicsdemo.gameScenes.Level1Scene;
import physicsdemo.gameScenes.LoseScene;
import physicsdemo.obstacles.Ground;
import physicsdemo.physics.Physics2D;
import physicsdemo.utils.Utils;
import physicsdemo.view.Animation;
import physicsdemo.view.Camera;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class Cow extends GameObject implements Collider {

    private int dx;
    private int dy;
    private boolean isGrounded;
    private int playerHP = 12;
    private Animation animationLeft;
    private Animation animationRight;
    private Animation animationJumpLeft;
    private Animation animationJumpRight;
    private Animation animationFallLeft;
    private Animation animationFallRight;
    private int damage = 1;
    private ArrayList<Milk> milks;
    boolean moveLeft;
    boolean isShootable = true;
    int countDownForShoot = 10;
    protected boolean levelUp = false;
    private Clip soundJump, soundFight;
    private Image hp1, hp2;
    private boolean isLeft = false;

    public Cow(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        dx = 0;
        dy = 0;
        milks = new ArrayList<>();
        // mặc định animation lúc đầu
        ArrayList<Image> imagesLeft = new ArrayList<Image>();
        {
            imagesLeft.add(Utils.loadImage("res/coww/cow-left-1.png"));
            imagesLeft.add(Utils.loadImage("res/coww/cow-left-2.png"));
            imagesLeft.add(Utils.loadImage("res/coww/cow-left-3.png"));
            imagesLeft.add(Utils.loadImage("res/coww/cow-left-4.png"));
        }
        animationLeft = new Animation(imagesLeft);

        ArrayList<Image> imagesRight = new ArrayList<Image>();
        {
            imagesRight.add(Utils.loadImage("res/coww/cow-right-1.png"));
            imagesRight.add(Utils.loadImage("res/coww/cow-right-2.png"));
            imagesRight.add(Utils.loadImage("res/coww/cow-right-3.png"));
            imagesRight.add(Utils.loadImage("res/coww/cow-right-4.png"));
        }
        animationRight = new Animation(imagesRight);

        ArrayList<Image> imagesJumpLeft = new ArrayList<Image>();
        {
            imagesJumpLeft.add(Utils.loadImage("res/coww/cow-jump-left.png"));
        }
        animationJumpLeft = new Animation(imagesJumpLeft);

        ArrayList<Image> imagesJumpRight = new ArrayList<Image>();
        {
            imagesJumpRight.add(Utils.loadImage("res/coww/cow-jump-right.png"));
        }
        animationJumpRight = new Animation(imagesJumpRight);

        ArrayList<Image> imagesFallRight = new ArrayList<Image>();
        {
            imagesFallRight.add(Utils.loadImage("res/coww/fall_right.png"));
        }
        animationFallRight = new Animation(imagesFallRight);

        ArrayList<Image> imagesFallLeft = new ArrayList<Image>();
        {
            imagesFallLeft.add(Utils.loadImage("res/coww/fall_left.png"));
        }
        animationFallLeft = new Animation(imagesFallLeft);

        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);
        hp2 = Utils.loadImage("res/hp2.png");
        hp1 = Utils.loadImage("res/hp1.png");
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

        if (isGrounded) {
            if (isLeft) {
                animationLeft.draw(graphics, gameRect);
            } else {
                animationRight.draw(graphics, gameRect);
            }
        } else {

            if (isLeft) {
                animationJumpLeft.draw(graphics, gameRect);
            } else {
                animationJumpRight.draw(graphics, gameRect);
            }
        }


        graphics.drawImage(hp2, 50, 50, 100, 20, null);
        if (playerHP == 10) {
            graphics.drawImage(hp1, 50, 50, 100, 20, null);
        }
        if (playerHP == 9) {
            graphics.drawImage(hp1, 50, 50, 90, 20, null);
        }
        if (playerHP == 8) {
            graphics.drawImage(hp1, 50, 50, 80, 20, null);
        }
        if (playerHP == 7) {
            graphics.drawImage(hp1, 50, 50, 70, 20, null);
        }
        if (playerHP == 6) {
            graphics.drawImage(hp1, 50, 50, 60, 20, null);
        }
        if (playerHP == 5) {
            graphics.drawImage(hp1, 50, 50, 50, 20, null);
        }
        if (playerHP == 4) {
            graphics.drawImage(hp1, 50, 50, 40, 20, null);
        }
        if (playerHP == 3) {
            graphics.drawImage(hp1, 50, 50, 30, 20, null);
        }
        if (playerHP == 2) {
            graphics.drawImage(hp1, 50, 50, 20, 20, null);
        }
        if (playerHP == 1) {
            graphics.drawImage(hp1, 50, 50, 10, 20, null);
        }
    }

    @Override
    public void update() {
        dx = 0;
        dy += Physics2D.GRAVITY;
        isGrounded = false;

        if (InputManager.getInstance().isRight()) {
            moveLeft = false;
            dx += 7;
            isLeft = false;
        }

        if (InputManager.getInstance().isLeft()) {
            moveLeft = true;
            dx -= 7;
            isLeft = true;
        }


// tạo que cho chú Bò
        GameObject gameObjectCenterDown = GameObject.objectAt(gameRect.getCenterX(), gameRect.getBottom() +7 + dy);
        {
            if (gameObjectCenterDown != null && gameObjectCenterDown instanceof Ground) {
                dy = 0;
                isGrounded = true;
                if(gameObjectCenterDown != null && ((((Ground) gameObjectCenterDown).getMoveBehavior()) instanceof LeftRightBehavior)){
                    int deviation = ((LeftRightBehavior)(((Ground) gameObjectCenterDown).getMoveBehavior())).getDeviation();
                    gameRect.move(deviation, 0);
                    Camera.instanse.x += deviation;
                }
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
        if (gameRect.getX() > 500 && gameRect.getX() < 5800) {
            Camera.instanse.x += dx;
        }

        if (InputManager.getInstance().isUp() && isGrounded) {
            dy = -20;
            soundJump = Utils.playSound("res/music/jump.wav", false);
        }
        if (!levelUp) {
            if (InputManager.getInstance().isSpace()) {
                if (isShootable) {
                    soundFight = Utils.playSound("res/music/scratch.wav", false);
                    isShootable = false;
                    Milk milk;
                    if (moveLeft) {
                        milk = new Milk(this.gameRect, new SpriteRenderer("res/milkbullet-left.png"));
                        milk.setMoveLeft(true);
                    } else {
                        milk = new Milk(this.gameRect, new SpriteRenderer("res/milkbullet-2.png"));
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
//        if(dx>0){
//        }else if(dx<0){
//
//        }
        if (gameRect.getY() > 800 || playerHP <= 0) {
            GameWindow.instance.setCurrentScene(new LoseScene());
            Camera.instanse.x = 0;
            ControllerManager.instance.setClear(true);
            CollisionManager.instance.setClear(true);
            GameObject.setClear(true);
        }
    }

    @Override
    public void onCollide(Collider other) {
        if (other instanceof EnemyBullet) {
            ((EnemyBullet) other).getHit(damage);
            playerHP = playerHP - 1;
        }
        if (other instanceof EnemyController) {
            ((EnemyController) other).getHit(damage);
            playerHP = playerHP - 2;
        }
        if (other instanceof LevelUp) {
            ((LevelUp) other).getHit(damage);
            System.out.println(" Level Up");
            setLevelUp(true);
            setPlayerHP(30);
        }
    }
}