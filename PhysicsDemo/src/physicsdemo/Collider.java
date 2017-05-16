package physicsdemo;

/**
 * Created by trongphuong1011 on 5/14/2017.
 */
public interface Collider {
    GameRect getGameRect();

    void onCollide(Collider other);
}
