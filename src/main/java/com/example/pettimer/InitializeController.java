package com.example.pettimer;

import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.awt.Desktop;
import java.net.URI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
    private PasswordField passField;
    @FXML
    private TextField pass2Field;

    @FXML
    private AnchorPane sideField;

    @FXML
    private ImageView hidePassImage;
    @FXML
    private ImageView showPassImage;

    @FXML
    private ImageView closeImg;

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private ImageView collapseImg;

    @FXML
    void loginButtonClicked(ActionEvent event) {

        ScaleTransition st = new ScaleTransition(Duration.millis(200), slidingField);
        st.setToX(1);
        st.play();

        TranslateTransition tt = new TranslateTransition(Duration.millis(200), slidingField);
        tt.setToX(0);
        tt.play();
        loginButton.setText("Login");
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
    void hidePassword(MouseEvent event) {
        hidePassImage.setVisible(true);
        showPassImage.setVisible(false);

        passField.setText(pass2Field.getText());
        passField.setVisible(true);
        pass2Field.setVisible(false);
    }

    @FXML
    void showPassword(MouseEvent event) {
        hidePassImage.setVisible(false);
        showPassImage.setVisible(true);

        pass2Field.setText(passField.getText());
        pass2Field.setVisible(true);
        passField.setVisible(false);
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

    @FXML
    void helpClicked(ActionEvent event) throws URISyntaxException, IOException {
        Desktop.getDesktop().browse(new URI("https://github.com/SNK-LT/PetTimer/blob/master/README.md"));
    }

    @FXML
    void closeImgClicked(MouseEvent event) {
        Platform.exit();
        System.exit(0);
    }

    @FXML
    void collapseImgClicked(MouseEvent event) {
        Stage stage = (Stage) collapseImg.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setRotate(circle1, true, 360, 18);
        setRotate(circle2, true, 360, 10);

        ScaleTransition stFirst = new ScaleTransition(Duration.millis(1), slidingField);
        stFirst.setToX(0.3);
        stFirst.play();

        TranslateTransition ttFirst = new TranslateTransition(Duration.millis(1), slidingField);
        ttFirst.setToX(-200);
        ttFirst.play();



    }
}
