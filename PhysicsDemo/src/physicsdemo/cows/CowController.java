//package physicsdemo.cows;
//
//import physicsdemo.GameRect;
//import physicsdemo.controller.Controller;
//import physicsdemo.utils.Utils;
//import physicsdemo.view.Animation;
//
//import java.awt.*;
//import java.util.ArrayList;
//
///**
// * Created by trongphuong1011 on 5/13/2017.
// */
//public class CowController extends Controller {
//    private Animation animation;
//
//    public CowController(GameRect gameRect){
//        super(gameRect, null);
//        ArrayList<Image> images= new ArrayList<>();
//        images.add(Utils.loadImage("res/Minh/run-right-1.png"));
//        images.add(Utils.loadImage("res/Minh/run-right-2.png"));
//        images.add(Utils.loadImage("res/Minh/run-right-3.png"));
//        images.add(Utils.loadImage("res/Minh/run-right-4.png"));
//
//        this.animation= new Animation(images, 1, true);
//    }
//
//    @Override
//    public void draw(Graphics graphics) {
//        animation.draw(graphics, gameRect);
//    }
//}
