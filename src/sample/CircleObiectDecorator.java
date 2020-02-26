package sample;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class CircleObiectDecorator extends CircleObiect {
    final CircleObiect baseCircleObiect;
    List<Color> list = new ArrayList<>();
    int number;


    public CircleObiectDecorator(CircleObiect baseCircleObiect, int number) {
        setUpList();
        this.number = number;
        this.baseCircleObiect = baseCircleObiect;
        this.baseCircleObiect.setColorAndGetBlock(getColor());
    }

    public List<Color> setUpList() {
        list.add(Color.BLUE);
        list.add(Color.CYAN);
        list.add(Color.GREEN);
        list.add(Color.WHITESMOKE);
        list.add(Color.RED);
        list.add(Color.ORANGE);
        return list;
    }


    @Override
    public Color getColor()
    {
        return list.get(this.number);
    }

}
