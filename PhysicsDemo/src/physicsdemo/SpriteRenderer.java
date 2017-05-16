package physicsdemo;

import physicsdemo.view.Camera;
import physicsdemo.GameRect;
import physicsdemo.utils.Utils;
import physicsdemo.view.Camera;

import java.awt.*;

/**
 * Created by trongphuong1011 on 5/10/2017.
 */
public class SpriteRenderer {
    private Image image;

    public Image getImage() {
        return image;
    }

    public SpriteRenderer(Image image) {
        this.image = image;
    }

    public SpriteRenderer(String path) {
        this(Utils.loadImage(path));
    }

    public void render(Graphics graphics, GameRect gameRect) {
        graphics.drawImage(image,
                gameRect.getX() - Camera.instanse.x, gameRect.getY(),
                gameRect.getWidth(), gameRect.getHeight(),
                null);
    }
}
