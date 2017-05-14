package physicsdemo.view;

import physicsdemo.GameRect;

import java.awt.*;
import java.util.List;

/**
 * Created by trongphuong1011 on 5/13/2017.
 */
public class Animation {
    private List<Image> images;
    private int imageIndex = 0;
    private int interval=10;
    private int time;

    private boolean isOneTime;
    private boolean hasEnded;

    public Animation(List<Image> images, int interval, boolean isOneTime) {
        this.images = images;
        this.interval=interval;
        this.isOneTime=isOneTime;
    }
    public Animation(List<Image> images) {
        this(images,5,false);
    }

    public Animation(List<Image> images,boolean isOneTime) {
        this(images,5, isOneTime);
    }

    public void draw(Graphics graphics, GameRect gameRect) {
        time++;
        if(time>=interval){
            time=0;
            imageIndex++;
            if(imageIndex >= images.size()){
                if(isOneTime){
                    hasEnded=true;
                }
                imageIndex=0;
            }
        }
        if(isOneTime&&hasEnded){
            return;
        }
        graphics.drawImage(images.get(imageIndex),gameRect.getX()- Camera.instanse.x,gameRect.getY()+7,null);
    }
}
