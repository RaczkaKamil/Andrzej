package sample;

import javafx.scene.paint.Color;

public class CircleBuilder {
    Color color;
    CircleObiect circleObiect;



    public CircleBuilder(CircleObiect circleObiect) {
        this.circleObiect = circleObiect;
    }

    CircleScene build(){
        return new CircleScene(circleObiect);
    }

}

