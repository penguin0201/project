package com.example.demoproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    private static Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("教务管理系统");
        changeView("login.fxml");
        stage.show();
    }

    public static void changeView(String fxml) throws IOException {
        Parent root =FXMLLoader.load(MainApplication.class.getResource(fxml));
        stage.setScene(new Scene(root));

    }

}
