package sample;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;

public class CircleObiect {
    Scene scene;
    Group group;
    double width = 50;
    double heigh = 50;
    double localX = 50;
    double localY = 50;
    Boolean isChangedDIrectory;
    Color color;
    CircleObiect circleObiect;

    public CircleObiect(Group group, Scene scene, double localX,Boolean isChangedDIrectory, double width, double heigh) {
        this.group = group;
        this.scene = scene;
        this.localX = localX;
        this.isChangedDIrectory = isChangedDIrectory;
        this.width = width;
        this.heigh = heigh;
        this.color = Color.RED;
    }

    public CircleObiect() {
    }


    public CircleObiect setColorAndGetBlock(Color color){
        this.color = color;
        return circleObiect;
    }

    public Color getColor() {
        return this.color;
    }
}

