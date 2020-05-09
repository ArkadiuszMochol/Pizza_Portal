package service;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
    public void closeWindow(Node node){
        Stage stageToClose = (Stage) node.getScene().getWindow();
        stageToClose.close();
    }
    public static void getAlertWindow(Alert.AlertType alertType, String title, String header, String content){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }



}
