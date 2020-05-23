package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import service.LoginService;
import service.WindowService;

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
        windowService.createWindow("registrationView", "panel rejestracji");
        windowService.closeWindow(lblInfo);
    }

    public void initialize() {
        loginService = new LoginService();
        windowService = new WindowService();
    }


}
