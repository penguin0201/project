package com.example.demoproj.controller;

import com.example.demoproj.MainApplication;
import com.example.demoproj.util.StringUtil;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class LoginController {

    @FXML
    private Label errorinfo;

    @FXML
    private Button login;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField textField;

    @FXML
    public void onLoginClick(ActionEvent actionEvent) throws IOException {
        String accountText = this.textField.getText();
        String passwordText = this.passwordField.getText();

        if (StringUtil.isEmpty(accountText) || StringUtil.isEmpty(passwordText)) {
            errorinfo.setText("用户名或密码不能为空");
            errorinfo.setVisible(true);
            errorinfo.setStyle("-fx-text-fill: red");
            return;
        }

        if (accountText.equals("admin") && passwordText.equals("123456")) {
            errorinfo.setText("登录成功");
            errorinfo.setVisible(true);
            errorinfo.setStyle("-fx-text-fill: blue");
            //进入系统
            MainApplication.changeView("main-frame.fxml");

        } else {
            errorinfo.setText("用户名或密码错误");
            errorinfo.setVisible(true);
            errorinfo.setStyle("-fx-text-fill: red");
        }
    }
}
