package com.example.demoproj;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
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

    public static void postView(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(fxml));
        Stage stage = new Stage();
        stage.setTitle("提示");
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.show();
    }

    public static void postMessage(String mes) throws IOException {
        javafx.scene.text.Text text = new Text(120, 100, mes);
        Group root = new Group(text);
        Stage stage = new Stage();
        stage.setTitle("提示");
        stage.setScene(new Scene(root, 400, 200));
        stage.show();
    }
}
