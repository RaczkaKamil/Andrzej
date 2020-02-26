package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
    int numberOfColor=0;
    double localX =0;
    double localY =0;
    Scene scene;
    Group group;
    Boolean  isChangedDIrectory=false;
    double width = 50;
    double heigh = 50;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        group = new Group();
        scene = new Scene(group, 1500, 1500);
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();

        CircleObiect circleObiect = new CircleObiect(group, scene, localX,isChangedDIrectory, width, heigh);
        CircleBuilder sb = new CircleBuilder(circleObiect);
        CircleScene blockScene = sb.build();
        scene.setOnKeyPressed(eventKeyPressed);
    }

        EventHandler<KeyEvent> eventKeyPressed = new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SPACE) {

                    double finalLocalX = localX + 50;
                    double finalLocalY = localY + 50;
                    double finalHeigh = heigh / 2+15;
                    double finalWidth = width / 2+15;


                    CircleObiect circleObiect = new CircleObiect(group, scene, finalLocalX,isChangedDIrectory, finalWidth, finalHeigh);
                    CircleObiect circleObiect2 = new CircleObiect(group, scene, -finalLocalX,isChangedDIrectory, finalWidth, finalHeigh);


                    CircleObiectDecorator blockDecorator = new CircleObiectDecorator(circleObiect, numberOfColor);
                    CircleObiectDecorator blockDecorator2 = new CircleObiectDecorator(circleObiect2, numberOfColor);
                    CircleBuilder sb = new CircleBuilder(blockDecorator.baseCircleObiect);
                    CircleBuilder sb2 = new CircleBuilder(blockDecorator2.baseCircleObiect);
                    CircleScene blockScener = sb.build();
                    CircleScene blockScener2 = sb2.build();

                    localX = finalLocalX;
                    width = finalWidth;
                    heigh = finalHeigh;
                    isChangedDIrectory=!isChangedDIrectory;
                    if (blockDecorator.list.size() < numberOfColor + 2) {
                        numberOfColor=0;
                    } else {
                        numberOfColor++;
                    }
                }
            }
        };


    public static void main(String[] args) {
        launch(args);
    }
}

