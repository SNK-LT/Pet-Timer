package com.example.pettimer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloController {

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    private MenuBar menuBar;

    @FXML
    void menuBarDragged(MouseEvent event) {
        Stage stage = (Stage)menuBar.getScene().getWindow();
        stage.setX(event.getScreenX() + xOffset);
        stage.setY(event.getScreenY() + yOffset);
    }

    @FXML
    void menuBarPressed(MouseEvent event) {
        Stage stage = (Stage)menuBar.getScene().getWindow();
        xOffset = stage.getX() - event.getScreenX();
        yOffset = stage.getY() - event.getScreenY();
    }
}
