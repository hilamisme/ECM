package Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Project extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        try {
            stage.setResizable(false);
            Image icon = new Image("Project/icon1.png");
            stage.getIcons().add(icon);
            stage.setTitle("Anglicus");
            Parent root = FXMLLoader.load((getClass().getResource("Login.fxml")));
            Scene scene = new Scene(root);
            stage.centerOnScreen();
            String css= this.getClass().getResource("style.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
