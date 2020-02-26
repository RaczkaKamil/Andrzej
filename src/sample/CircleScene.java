package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.beans.Visibility;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;


class CircleScene{
    Circle rect = new Circle();
    Scene scene;
    double width;
    double height;
    double localX;
    CircleObiect circleObiect;
    Color color;
    Group group;
    Boolean isChangedDIrectory;
    TranslateTransition tt = new TranslateTransition();
    CircleScene(CircleObiect circleObiect){
        this.circleObiect = circleObiect;
        this.isChangedDIrectory = circleObiect.isChangedDIrectory;
        this.localX = circleObiect.localX;
        this.width = circleObiect.width;
        this.height = circleObiect.heigh;
        this.color = circleObiect.color;
        this.group = circleObiect.group;
        this.scene = circleObiect.scene;
        scene.setFill(Color.GRAY);
        System.out.println("KONCOWY KOLOR: "+ circleObiect.color);
        rect.setRadius(this.width/2);
        rect.setFill(this.color);
        if (group.getChildren().size()<9){
            group.getChildren().add(rect);
            System.out.println(group.getChildren().size());
            redraw();
        }else
        {
            redrawVortex();
        }

    }

    public void redrawVortex(){
        Thread thread = new Thread(() -> {
        for (int i = 0; i < group.getChildren().size(); i++) {

            double locX=scene.getWidth() / 2 - (width / 2 );
            double locY=scene.getHeight() / 2 - (height/2);
            group.getChildren().get(i).setVisible(false);
                try {
                    currentThread().sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



        }
        scene.setFill(Color.GREEN);
        });
        thread.start();

    }
    public void redraw() {
        Thread thread = new Thread(() -> {
            if(group.getChildren().size()==1){
                double locX=scene.getWidth() / 2 - (width / 2 );
                double locY=scene.getHeight() / 2 - (height/2);
                rect.setTranslateX(locX);
                rect.setTranslateY(locY);

            }else {
                double locX = scene.getWidth() / 2 - (width / 2);
                double locY = scene.getHeight() / 2 - (height / 2);
                rect.setTranslateX(locX);
                rect.setTranslateY(locY);


                if (isChangedDIrectory) {
                    tt.setFromY(rect.getTranslateY());
                    tt.setToY(rect.getTranslateY() + localX);
                    tt.setDuration(Duration.millis(1000));
                    tt.setNode(rect);
                    tt.play();
                } else {
                    tt.setFromX(rect.getTranslateX());
                    tt.setToX(rect.getTranslateX() + localX);
                    tt.setDuration(Duration.millis(1000));
                    tt.setNode(rect);
                    tt.play();
                }
            }
        });
        thread.start();

    }



}