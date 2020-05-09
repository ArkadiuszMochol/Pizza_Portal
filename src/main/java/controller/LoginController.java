package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import jdk.jfr.Label;
import service.LoginService;
import service.WindowService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoginController {
    LoginService loginService;
    WindowService windowService;

    @FXML
    private PasswordField pfPassword;
    @FXML
    private TextField tfLogin;
    @FXML
    private Label lblInfo;

    @FXML
    void keyLoginAction(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER) {
            loginService.login(tfLogin, pfPassword, lblInfo);
        }
    }

    @FXML
    void loginAction(ActionEvent event) {
        loginService.login(tfLogin, pfPassword, lblInfo);
    }

    @FXML
    void registerAction(ActionEvent event) throws IOException {
        windowService.createWindow()

    }
}
