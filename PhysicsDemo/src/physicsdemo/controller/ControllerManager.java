//package physicsdemo.controller;
//
//import physicsdemo.enemies.EnemyController;
//
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.Iterator;
//
///**
// * Created by trongphuong1011 on 5/14/2017.
// */
//public class ControllerManager {
//        private ArrayList<Controller> controllers;
//        private boolean clear = false;
//
//        public static final ControllerManager instance = new ControllerManager();
//
//        private ControllerManager() {
//            controllers = new ArrayList<>();
//        }
//
////        public void add(EnemyController controller) {
////            controllers.add(controller);
////        }
//
//        public void draw(Graphics graphics) {
//            for (Controller controller : controllers) {
//                controller.draw(graphics);
//            }
//        }
//
//        public void setClear(boolean clear) {
//            this.clear = clear;
//        }
//
//        public void update() {
//            if (clear == true) {
//                Iterator<Controller> iterator = controllers.iterator();
//                while (iterator.hasNext()) {
//                    Controller controller = iterator.next();
//                    iterator.remove();
//                }
//
//            }
//            Iterator<Controller> iterator = controllers.iterator();
//            while (iterator.hasNext()) {
//                Controller controller = iterator.next();
//                if (controller.getGameRect().isDead()) {
//                    iterator.remove();
//                }
//            }
//            for (Controller controller : controllers) {
//                controller.update();
//            }
//        }
//}
