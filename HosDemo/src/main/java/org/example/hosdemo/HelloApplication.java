package org.example.hosdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    public static Stage stg;
    @Override
    public void start(Stage primaryStage) throws IOException {
        stg=primaryStage;
        primaryStage.setResizable(false);
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Signin.fxml")));
        primaryStage.setTitle("HOSPITAL APPOINTMENT SCHEDULER");
        primaryStage.setScene(new Scene(root,900,500));
        primaryStage.show();
    }

    public void changeScene(String fxml) throws IOException{
        Parent pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(fxml)));
        stg.getScene().setRoot(pane);
    }

    public static void main(String[] args) {
        launch();
    }
}