package Project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label loginNotification;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public void login(ActionEvent event){
        if(!username.getText().isBlank() && !password.getText().isBlank())
        {
            validateLogin(event);
        }
        else{
            loginNotification.setText("Please enter your username and password!");
        }
    }
    public void signUp(ActionEvent event)throws IOException
    {
        root = FXMLLoader.load(getClass().getResource("SignUp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void validateLogin(ActionEvent event) {
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB=connectNow.getConnection();
        String verifyLogin= "select count(1) from useraccounts where Username='" +username.getText()+ "' and Password='"+ password.getText() +"'";
        try{
            Statement statement=connectDB.createStatement();
            ResultSet queryResult=statement.executeQuery(verifyLogin);
            while(queryResult.next())
            {
                if(queryResult.getInt(1)==1){
                    FXMLLoader loader=new FXMLLoader(getClass().getResource("HomePage.fxml"));
                    root=loader.load();
                    stage=(Stage)((Node)event.getSource()).getScene().getWindow();
                    scene =new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                    stage.centerOnScreen();
                }
                else{
                    loginNotification.setText("Invalid login. Please try again!");
                    username.clear();
                    password.clear();
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
