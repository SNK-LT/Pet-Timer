package com.example.pettimer;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

public class HelloController {

    @FXML
    private Button changeUserNameButton;

    @FXML
    private Text userNameText;

    @FXML
    private TextField userNameTextField;

    @FXML
    void changeUserNameButtonClicked(MouseEvent event) {
        if(userNameTextField.isVisible())
        {
            userNameText.setText(userNameTextField.getText());
            userNameTextField.setVisible(false);
            changeUserNameButton.setText("Change User Name");
        }
        else
        {
            userNameTextField.setVisible(true);
            changeUserNameButton.setText("Accept");
        }
    }

}
