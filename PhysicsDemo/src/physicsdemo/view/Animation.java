package physicsdemo.view;

import physicsdemo.GameRect;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Quang Minh on 13/05/2017.
 */
public class Animation {
    private List<Image> images;
    private int imageIndex = 1;
    private int interval = 5;
    private int time;
    private boolean isOneTime;
    private boolean hasEnded;

    public void draw(Graphics graphics, GameRect rect) {
        time++;
        if (time >= interval) {
            imageIndex++;
            if (imageIndex >= images.size()) {
                imageIndex = 1;
                if(isOneTime){
                    hasEnded=true;
                }
            }
            time = 0;
        }
        if(isOneTime && hasEnded){
            return;
        }
        graphics.drawImage(images.get(imageIndex), rect.getX(), rect.getY(), null);
    }

    public boolean isEnded() {
        return hasEnded;
    }

    public Animation(ArrayList<Image> images, int interval, boolean isOneTime) {
        this.images = images;
        this.interval = interval;
        this.isOneTime = isOneTime;
    }

}
