package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomePage implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button btnClasses;

    @FXML
    private Button btnDashBoard;

    @FXML
    private Button btnReport;

    @FXML
    private Button btnSchedule;

    @FXML
    private Button btnStudent;

    @FXML
    private Button btnTeacher;
    @FXML
    private Button btnHome;

    @FXML
    private Label lbStatus;

    @FXML
    private Pane pnlStatus;
    @FXML
    private GridPane pnClasses;

    @FXML
    private GridPane pnDashboard;

    @FXML
    private GridPane pnReport;

    @FXML
    private GridPane pnSchedule;

    @FXML
    private GridPane pnStudent;

    @FXML
    private GridPane pnTeacher;
    @FXML
    private GridPane pnHome;
    public void logout(ActionEvent event) throws IOException
    {
        Alert alert= new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Sign out");
        alert.setHeaderText("Do you want to sign out?");
        if(alert.showAndWait().get()==ButtonType.OK)
        {
            FXMLLoader loader=new FXMLLoader(getClass().getResource("Login.fxml"));
            root=loader.load();
            stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
            stage.centerOnScreen();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    @FXML
    private void handleClicks(ActionEvent event) {
        if (event.getSource() == btnDashBoard) {
            lbStatus.setText("Dashboard");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(204, 119, 34), CornerRadii.EMPTY, Insets.EMPTY)));
            pnDashboard.toFront();
        } else if (event.getSource() == btnSchedule) {
            lbStatus.setText("Schedule");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(212, 175, 55), CornerRadii.EMPTY, Insets.EMPTY)));
            pnSchedule.toFront();
        } else if (event.getSource() == btnClasses) {
            lbStatus.setText("Classes");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255, 195, 0), CornerRadii.EMPTY, Insets.EMPTY)));
            pnClasses.toFront();
        } else if (event.getSource() == btnStudent) {
            lbStatus.setText("Student");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(156, 175, 136), CornerRadii.EMPTY, Insets.EMPTY)));
            pnStudent.toFront();
        } else if (event.getSource() == btnTeacher) {
            lbStatus.setText("Teacher");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(3, 26, 107), CornerRadii.EMPTY, Insets.EMPTY)));
            pnTeacher.toFront();
        } else if (event.getSource() == btnReport) {
            lbStatus.setText("Report");
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(204, 119, 34), CornerRadii.EMPTY, Insets.EMPTY)));
            pnReport.toFront();
        }else if (event.getSource() == btnHome) {
            pnlStatus.setBackground(new Background(new BackgroundFill(Color.rgb(255,255,255 ), CornerRadii.EMPTY, Insets.EMPTY)));
            pnHome.toFront();
        }
    }
}
