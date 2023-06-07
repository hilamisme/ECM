package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.xml.stream.events.StartDocument;
import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class SignUp {
    @FXML
    private TextField usernameSU;
    @FXML
    private PasswordField passwordSU;
    @FXML
    private TextField firstNameSU;
    @FXML
    private TextField lastNameSU;
    @FXML
    private PasswordField confirmPasswordSU;
    @FXML
    private Label signUpNotification;
    @FXML
    private Label passwordConfirmNoti;
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void signUp(ActionEvent event) {
        if (usernameSU.getText().isBlank() == false && passwordSU.getText().isBlank() == false) {
            if(passwordSU.getText().equals(confirmPasswordSU.getText()))
            {
                passwordConfirmNoti.setText("Password matches");
                SignUpUser();
            }else{
                passwordConfirmNoti.setText("Password does not match");
                passwordSU.clear();
                confirmPasswordSU.clear();
            }
        } else {
            signUpNotification.setText("Please enter your username and password!");
        }
    }
    public void signInLink(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void SignUpUser() {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();
        String verify = "select count(1) from useraccounts where Username='" + usernameSU.getText()+"'";
        try{
            Statement statement1 = connectDB.createStatement();
            ResultSet resultSet = statement1.executeQuery(verify);
        while (resultSet.next()) {
            if (resultSet.getInt(1)==1) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("You can not use this username! Please try again.");
                alert.show();
                usernameSU.clear();
                passwordSU.clear();
                lastNameSU.clear();
                firstNameSU.clear();
                confirmPasswordSU.clear();
            }
            if(resultSet.getInt(1)!=1){
                String firstname = firstNameSU.getText();
                String lastname = lastNameSU.getText();
                String username = usernameSU.getText();
                String password = passwordSU.getText();

                String insertField = "insert into useraccounts (firstName,lastName,Username,Password) values('";
                String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
                String insertToRegister = insertField + insertValues;

                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(insertToRegister);
                    signUpNotification.setText("Register successfully!");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}



