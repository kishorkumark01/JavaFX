package org.example.hosdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class PleaseProvideControllerClassName {

    @FXML
    private Button logout;

    @FXML
    public void userLogOut(ActionEvent event) throws IOException {
            HelloApplication m = new HelloApplication();
            m.changeScene("Signin.fxml");
    }

}