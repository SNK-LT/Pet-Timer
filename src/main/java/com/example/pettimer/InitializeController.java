package com.example.pettimer;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class InitializeController implements Initializable {

    @FXML
    private Circle circle1;

    @FXML
    private Circle circle2;

    @FXML
    private AnchorPane sideField;

    private double xOffset = 0;
    private double yOffset = 0;

    private void setRotate(Circle c, boolean reverse, int angle, int duration)
    {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);

        rt.setAutoReverse(reverse);

        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(18);
        rt.play();
    }


    @FXML
    void sideFieldDragged(MouseEvent event) {
        Stage stage = (Stage)sideField.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }

    @FXML
    void sideFieldPressed(MouseEvent event) {
        Stage stage = (Stage)sideField.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRotate(circle1, true, 360, 18);
        setRotate(circle2, true, 360, 10);
    }
}
