import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Exception {
    //@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/view/loginView.fxml"));
        primaryStage.setTitle("panel logowania");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
        //FileService.selectUsers();
        //FileService.selectBaskets();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
