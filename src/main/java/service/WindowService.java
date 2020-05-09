package service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class WindowService {
    public void createWindow(String viewName, String title) throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/" + viewName + ".fxml"));
        stage.setTitle(title);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.show();
    }
}
