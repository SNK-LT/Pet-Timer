package com.example.pettimer;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    private Button loginButton;

    @FXML
    private AnchorPane slidingField;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passwordField;

    @FXML
    private AnchorPane sideField;

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    void loginButtonClicked(ActionEvent event) {

        ScaleTransition st = new ScaleTransition(Duration.millis(300), slidingField);
        st.setToX(1);
        st.play();

        TranslateTransition tt = new TranslateTransition(Duration.millis(300), slidingField);
        tt.setToX(0);
        tt.play();

        /*slidingField.setMinWidth(400);
        slidingField.setLayoutX(180);
        slidingField.setPrefWidth(400);

        Insets loginInsets = new Insets(35,86,140,165);
        Insets passwordInsets = new Insets(75,86,100,165);

        loginField.setPadding(loginInsets);*/
    }

    private void setRotate(Circle c, boolean reverse, int angle, int duration)
    {
        RotateTransition rt = new RotateTransition(Duration.seconds(duration), c);

        rt.setAutoReverse(reverse);

        rt.setByAngle(angle);
        rt.setDelay(Duration.seconds(0));
        rt.setRate(3);
        rt.setCycleCount(-1);
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

        ScaleTransition stFirst = new ScaleTransition(Duration.millis(300), slidingField);
        stFirst.setToX(0.3);
        stFirst.play();

        TranslateTransition ttFirst = new TranslateTransition(Duration.millis(300), slidingField);
        ttFirst.setToX(-200);
        ttFirst.play();

    }
}
