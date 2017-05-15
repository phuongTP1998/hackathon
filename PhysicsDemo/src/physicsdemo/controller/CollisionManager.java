package physicsdemo.controller;

import physicsdemo.Collider;
import physicsdemo.GameRect;

import java.util.ArrayList;

/**
 * Created by trongphuong1011 on 5/14/2017.
 */
public class CollisionManager {
    public static final CollisionManager instance = new CollisionManager();
    public ArrayList<Collider> colliders;

    private CollisionManager() {
        colliders = new ArrayList<>();
    }

    public void update() {
        for (int i = 0; i < colliders.size() - 1; i++) {
            for (int j = i + 1; j < colliders.size(); j++) {

                Collider ci = colliders.get(i);
                Collider cj = colliders.get(j);

                GameRect recti = ci.getGameRect();
                GameRect rectj = cj.getGameRect();

                if (recti.intersects(rectj)) {
                    ci.onCollide(cj);
                    cj.onCollide(ci);
                }
            }
        }
    }

    public void add(Collider collider) {
        colliders.add(collider);
    }

    public void remove(Collider collider) {
        if (collider.getGameRect().isDead()) {
            colliders.remove(collider);
        }
    }
}
