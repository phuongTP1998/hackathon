package physicsdemo.cows;

import physicsdemo.Collider;
import physicsdemo.GameObject;
import physicsdemo.GameRect;
import physicsdemo.SpriteRenderer;
import physicsdemo.controller.CollisionManager;
import physicsdemo.controller.ControllerManager;

import java.awt.*;

/**
 * Created by trongphuong1011 on 5/16/2017.
 */
public class LevelUp extends GameObject implements Collider {
    private int damage=0;
    public LevelUp(GameRect gameRect, SpriteRenderer spriteRenderer) {
        super(gameRect, spriteRenderer);
        CollisionManager.instance.add(this);
        ControllerManager.instance.add(this);
    }
    public void getHit(int damage) {
        gameRect.setDead(true);
        CollisionManager.instance.remove(this);
        GameObject.remove(this);
    }
    public int getDamage() {
        return damage;
    }

    @Override
    public void draw(Graphics graphics) {
        super.draw(graphics);
    }

    @Override
    public void update() {
    }

    @Override
    public void onCollide(Collider other) {
        if(other instanceof Cow){
            ((Cow)other).getHit(damage);
        }
    }
}
