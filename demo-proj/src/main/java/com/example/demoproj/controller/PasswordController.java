package com.example.demoproj.controller;

import com.example.demoproj.MainApplication;
import com.example.demoproj.request.DataRequest;
import com.example.demoproj.request.DataResponse;
import com.example.demoproj.request.HttpRequestUtil;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PasswordController {
    @FXML
    private TextField oldPasswordField;
    @FXML
    private TextField newPasswordField;
    @FXML
    private TextField usernameField;

    /**
     * 点击 确认按钮 执行 onSubmitButtonClick方法，请求后台修改密码
     */
    @FXML
    protected void onChangePassword() throws IOException {
        DataRequest request= new DataRequest();
        String oldPassword =oldPasswordField.getText();
        String newPassword =newPasswordField.getText();
        String username =usernameField.getText();
        if( oldPassword.length() == 0  || newPassword.length() == 0  || username.length() == 0 ) {
            MainApplication.postMessage("输入为空，不能修改！");
            return;
        }
        request.put("oldPassword", oldPassword);
        request.put("newPassword", newPassword);
        request.put("username", username);
        DataResponse res = HttpRequestUtil.request("/api/base/updatePassword",request);
        if(res.getCode() == 0) {
            MainApplication.postMessage("修改成功！");
        }else {
            MainApplication.postMessage(res.getMsg());
        }
    }
}
